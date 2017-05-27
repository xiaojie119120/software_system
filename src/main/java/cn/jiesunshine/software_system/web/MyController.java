package cn.jiesunshine.software_system.web;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.jiesunshine.software_system.auth.AuthPassport;
import cn.jiesunshine.software_system.dto.Execution;
import cn.jiesunshine.software_system.entity.BaiduLink;
import cn.jiesunshine.software_system.entity.ExecutionDataInfo;
import cn.jiesunshine.software_system.entity.SoftGroup;
import cn.jiesunshine.software_system.entity.SoftPic;
import cn.jiesunshine.software_system.entity.Software;
import cn.jiesunshine.software_system.entity.User;
import cn.jiesunshine.software_system.enums.GroupStateEnum;
import cn.jiesunshine.software_system.enums.SoftwareStateEnum;
import cn.jiesunshine.software_system.enums.UserStateEnum;
import cn.jiesunshine.software_system.service.BaiduLinkService;
import cn.jiesunshine.software_system.service.GroupService;
import cn.jiesunshine.software_system.service.SoftPicService;
import cn.jiesunshine.software_system.service.SoftwareService;
import cn.jiesunshine.software_system.service.UserService;
import cn.jiesunshine.software_system.utils.IPUtil;
import cn.jiesunshine.software_system.utils.InspectUtil;
import cn.jiesunshine.software_system.utils.PicUtil;
import cn.jiesunshine.software_system.utils.SoftUtil;
import cn.jiesunshine.software_system.utils.UserType;

@Controller
@RequestMapping(value = "my")
public class MyController {
	@Autowired
	private UserService userService;
	@Autowired
	private SoftwareService softwareService;
	@Autowired
	private SoftPicService softPicService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private BaiduLinkService baiduLinkService;
	@AuthPassport(isUser = true)
	@RequestMapping(value="/home")
	private String myHome(HttpServletRequest request , HttpSession session) {
		return "redirect:dynamic/1";
	}
	@AuthPassport(isUser = true)
	@RequestMapping(value="/dynamic/{page}")
	private String myDynamic(HttpServletRequest request , HttpSession session , @PathVariable("page")int page) {
		User user = (User)session.getAttribute("user");
		if (user==null){
			return "login";
		}
		return "myDynamic";
	}
	@AuthPassport(isDevelop = true)
	@RequestMapping(value = "/soft/{page}")
	private String mySoftList(HttpServletRequest request ,HttpSession session , @PathVariable("page")int page) {
		User user = (User)session.getAttribute("user");
		if (user==null){
			return "login";
		}
		int uid = user.getId();
		Execution<User> uExecution = userService.getUserById(uid);
		User nowUser = uExecution.getObj();
		request.setAttribute("user", nowUser);
		request.setAttribute("nowPage", page);
		if (nowUser.getType()==UserType.ADMIN){
			Execution<List<Software>> execution = softwareService.getAllSoftwares(page);
			if (execution.getState()==SoftwareStateEnum.SUCCESS.getState()){
				ExecutionDataInfo eInfo = (ExecutionDataInfo)execution.getObjInfo();
				int maxPage = eInfo.getPageCount();
				int softCount = eInfo.getDataCount();
				if (page<1)
					return "redirect:1";
				else if (page>maxPage) {
					return "redirect:"+maxPage;
				}
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("softs", execution.getObj());
				request.setAttribute("softCount", softCount);
			}
			return "adminSoft";
		}else {
			Execution<List<Software>> execution = softwareService.getSoftwaresByUserId(uid, page);
			if (execution.getState()==SoftwareStateEnum.SUCCESS.getState()){
				int maxPage = (int)execution.getObjInfo();
				if (page<1)
					return "redirect:1";
				else if (page>maxPage) {
					return "redirect:"+maxPage;
				}
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("softs", execution.getObj());
			}
			return "mySoft";
		}
		
	}
	@AuthPassport(isUser = true)
	@RequestMapping(value = "/edit")
	private String editUserInfo(HttpServletRequest request , HttpSession session) {
		User user = (User)session.getAttribute("user");
		if (user==null){
			return "login";
		}
		Execution<User> userExecution = userService.getUserById(user.getId());
		if (userExecution.getState() == UserStateEnum.SUCCESS.getState()){
			User nUser = userExecution.getObj();
			request.setAttribute("user", nUser);
			request.setAttribute("userTypeStr", new UserType(nUser.getType()).getUserTypeStr());
		}
		request.setAttribute("state", userExecution.getState());	
		request.setAttribute("stateInfo", userExecution.getStateInfo());
		return "myEdit";
	}
	@AuthPassport(isUser = true)
	@RequestMapping(value = "/editExecution",method = RequestMethod.POST)
	private String editUserExecution(HttpServletRequest request,HttpSession session, User up_user) throws IllegalStateException, IOException {
		Execution<User> inspectExecution;
		if ((up_user.getName()!=null && (inspectExecution = InspectUtil.UserNameInspect(up_user.getName()))!=null) 
				|| (up_user.getPassword()!=null && (inspectExecution = InspectUtil.UserPwdInspect(up_user.getPassword()))!=null)
				|| (up_user.getEmail()!=null && (inspectExecution = InspectUtil.UserEmailInspect(up_user.getEmail()))!=null)){
			request.setAttribute("errorInfo", inspectExecution.getStateInfo());
			return "error";
		}
		User sUser = (User)session.getAttribute("user");
		request.setAttribute("userTypeStr", new UserType(sUser.getType()).getUserTypeStr());
		String ip = IPUtil.getIpAddress(request);
		up_user.setPreUpdateIp(ip);
		up_user.setId(sUser.getId());
		up_user.setType(null);
		up_user.setPicLink(null);
		up_user.setPreUpdateTime(new Date());
		Execution<User> userExecution = userService.updateUserInfo(up_user);
		if (userExecution.getState() == UserStateEnum.SUCCESS.getState()){
			session.setAttribute("user", userExecution.getObj());
		}
		request.setAttribute("updateInfo", userExecution.getStateInfo());
		return "myEdit";
	}
	@AuthPassport(isUser=true)
	@RequestMapping(value = "/editPwdExecution",method = RequestMethod.POST)
	private String editUserPwdExecution(HttpServletRequest request,HttpSession session, String nowPass,String password,String rePass) throws IllegalStateException, IOException {
		Execution<User> inspectExecution;
		User sUser = (User)session.getAttribute("user");
		request.setAttribute("userTypeStr", new UserType(sUser.getType()).getUserTypeStr());
		if ((inspectExecution=InspectUtil.UserPwdInspect(password))!=null){
			request.setAttribute("updateInfo", inspectExecution.getStateInfo());
			return "myEdit";
		}
		if (!rePass.equals(password)){
			request.setAttribute("updateInfo", UserStateEnum.REPWD_ERROR.getStateInfo());
			return "myEdit";
		}
		Execution<User> execution = userService.getUserById(((User)(session.getAttribute("user"))).getId());
		if (execution.getState() != UserStateEnum.SUCCESS.getState()){
			request.setAttribute("updateInfo", execution.getStateInfo());
			return "myEdit";
		}
		User user = execution.getObj();
		if (!nowPass.equals(user.getPassword())){
			request.setAttribute("updateInfo", UserStateEnum.PWD_ERROR.getStateInfo());
			return "myEdit";
		}
		user.setPassword(password);
		execution = userService.updateUserInfo(user);
		if (execution.getState() != UserStateEnum.SUCCESS.getState()){
			request.setAttribute("updateInfo", execution.getStateInfo());
			return "myEdit";
		}
		session.setAttribute("user", execution.getObj());
		request.setAttribute("updateInfo", "密码修改成功！");
		return "myEdit";
	}
	@AuthPassport(isDevelop = true)
	@RequestMapping(value = "/soft/delete/{id}")
	private String deleteMySoftware(HttpServletRequest request ,HttpSession session, @PathVariable int id,@RequestParam(value="page",required=false)int page) {
		if (page == 0){
			return "redirect:"+request.getContextPath()+"/my/soft/1";
		}
		User user = (User)session.getAttribute("user");
		if (user==null){
			return "login";
		}
		int uid = user.getId();
		Execution<Software> execution = softwareService.getSoftwareById(id);
		if (execution.getState() == SoftwareStateEnum.SUCCESS.getState()){
			Software software = execution.getObj();
			if (uid != software.getSoftUserId()){
				//不是用户自己的软件
				request.setAttribute("delState", 1);
				request.setAttribute("delInfo", "删除失败，您没有权限删除他人分享的软件！");
				return mySoftList(request, session, page);
			}
			List<SoftPic> softPics = softPicService.getPicBySid(id);
			String base_path = request.getRealPath("/");
			if (softPics!=null){
				String pic_path = base_path + "soft/image/";
				for (SoftPic softPic : softPics) {
					//删除截图文件
					File f = new File(pic_path+softPic.getPicLink());
					if (f.exists()){
						f.delete();
					}
				}
			}
			//删除截图记录
			softPicService.delPicBySid(id);
			//删除图标
			String icon_path = base_path + "soft/icon/"+software.getSoftIconLink();
			File f = new File(icon_path);
			if (f.exists()){
				f.delete();
			}
			//删除文件
			String file_path = base_path + "soft/file/"+software.getSoftFileLink();
			f= new File(file_path);
			if (f.exists()){
				f.delete();
			}
			//删除记录
			execution = softwareService.deleteSoftwareByIdAndUid(id, uid);
			if (execution.getState() == SoftwareStateEnum.SUCCESS.getState()){
				userService.delSoftCount(uid, IPUtil.getIpAddress(request));
				request.setAttribute("delState", 1);
				request.setAttribute("delInfo", "删除成功！");
			}
		}else {
			request.setAttribute("delState", 1);
			request.setAttribute("delInfo", "删除失败，"+execution.getStateInfo());
		}
		Execution<User> uExecution = userService.getUserById(uid);
		User nowUser = uExecution.getObj();
		request.setAttribute("user", nowUser);
		request.setAttribute("nowPage", page);
		Execution<List<Software>> sExecution = softwareService.getSoftwaresByUserId(uid, page);
		if (sExecution.getState()==SoftwareStateEnum.SUCCESS.getState()){
			int maxPage = (int)sExecution.getObjInfo();
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("softs", sExecution.getObj());
		}
		return "mySoft";
	}
	@AuthPassport(isDevelop = true)
	@RequestMapping(value="/soft/edit/{id}")
	private String updateSoftware(HttpServletRequest request ,HttpSession session , @PathVariable int id) {
		Execution<Software> execution = softwareService.getSoftwareById(id);
		User user = (User)session.getAttribute("user");
		int uid = user.getId();
		if (execution.getState() == SoftwareStateEnum.SUCCESS.getState()){
			if (uid != execution.getObj().getSoftUserId()){
				//不是用户自己的软件
				request.setAttribute("errorInfo", "编辑失败，您没有权限编辑他人分享的软件！");
				return "error";
			}
			//读取网盘地址
			BaiduLink baiduLink = baiduLinkService.getBaiduLinkBySid(id);
			request.setAttribute("baiduLink", baiduLink);
			request.setAttribute("soft", execution.getObj());
			Execution<List<SoftGroup>> gExecution = groupService.getGroups();
			if (execution.getState() == GroupStateEnum.SUCCESS.getState()){
				request.setAttribute("groups", gExecution.getObj());
			}
			return "editMySoft";
		}else {
			request.setAttribute("errorInfo", execution.getStateInfo());
			return "error";
		}
	}
	@AuthPassport(isDevelop = true)
	@RequestMapping(value="/soft/editExecution")
	private String updateSoftwareExecution(HttpServletRequest request ,HttpSession session , Software soft , @RequestParam(value = "file",required = false) MultipartFile file , @RequestParam(value = "icon",required = false) MultipartFile icon, String baiduLink) throws IllegalStateException, IOException {
		User user = (User)session.getAttribute("user");
		int uid = user.getId();
		//空值验证
		Execution<Software> inspectExecution = InspectUtil.SoftwareNameInspect(soft.getSoftName());
		if (inspectExecution!=null){
			request.setAttribute("errorInfo", inspectExecution.getStateInfo());
			return "error";
		}
		if (soft.getSoftAbstract() == null || soft.getSoftAbstract().equals("")) {
			soft.setSoftAbstract("该软件暂无简介。");
		}
		if (soft.getSoftDetails() == null || soft.getSoftDetails().equals("")) {
			soft.setSoftDetails("该软件暂无详细介绍。");
		}
		if (soft.getSoftGroupId() <= 0) {
			soft.setSoftGroupId(null);
		}
		//设置ip
		String ip = IPUtil.getIpAddress(request);
		soft.setPreUpdateIp(ip);
		//设置时间
		Date nowDate = new Date();
		soft.setPreUpdateTime(nowDate);
		soft.setSoftDate(nowDate);
		String base_path = request.getRealPath("/");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
		String path_end = sdf.format(nowDate);
		File dir;
		//保存文件
		Execution<Software> sExecution = softwareService.getSoftwareById(soft.getSoftId());
		if (sExecution.getState() != SoftwareStateEnum.SUCCESS.getState()){
			request.setAttribute("errorInfo", sExecution.getStateInfo());
			return "error";
		}
		if (uid != sExecution.getObj().getSoftUserId()){
			//不是用户自己的软件
			request.setAttribute("errorInfo", "修改失败，您没有权限修改他人分享的软件！");
			return "error";
		}
		//判断是否接收到百度网盘网址
		if (baiduLink!=null){
			if (sExecution.getState() == SoftwareStateEnum.SUCCESS.getState()){
				//删除文件
				String file_path = base_path + "soft/file/"+sExecution.getObj().getSoftFileLink();
				File f = new File(file_path);
				if (f.exists()){
					f.delete();
				}
			}
			soft.setSoftFileLink("");
			soft.setSoftSize(0l);
			BaiduLink bLink = new BaiduLink();
			bLink.setBdLink(baiduLink);
			bLink.setBdSoftId(soft.getSoftId());
			bLink.setBdType(1);
			if (baiduLinkService.getBaiduLinkBySid(soft.getSoftId())!=null){
				baiduLinkService.updateBaiduLinkBySid(bLink);
			}
			else {
				baiduLinkService.addBaiduLink(bLink);
			}
		}
		else if (file!=null&&!file.isEmpty()){
			if (sExecution.getState() == SoftwareStateEnum.SUCCESS.getState()){
				
				//删除文件
				String file_path = base_path + "soft/file/"+sExecution.getObj().getSoftFileLink();
				File f = new File(file_path);
				if (f.exists()){
					f.delete();
				}
			}
			String file_path = base_path + "soft/file/"+path_end;
			dir = new File(file_path);
			if (!dir.exists()){
				dir.mkdirs();
			}
			if (!file.isEmpty()){
				String oname = file.getOriginalFilename();
				if (oname!=null && oname.length()>0){
					String file_name = UUID.randomUUID()+oname.substring(oname.lastIndexOf('.'));
					File f = new File(file_path+file_name);
					file.transferTo(f);
					soft.setSoftFileLink(path_end+file_name);
					soft.setSoftSize(file.getSize());
				}
			}
		}
		//保存图标
		if (icon!=null&&!icon.isEmpty()){
			if (sExecution.getState() == SoftwareStateEnum.SUCCESS.getState()){
				//删除图标
				String icon_path = base_path + "soft/icon/"+sExecution.getObj().getSoftIconLink();
				File f = new File(icon_path);
				if (f.exists()){
					f.delete();
				}
			}
			int icon_width = 120;
			String icon_path = base_path + "soft/icon/"+path_end;
			dir = new File(icon_path);
			if (!dir.exists()){
				dir.mkdirs();
			}
			if (!icon.isEmpty()){
				String oname = icon.getOriginalFilename();
				
				if (oname!=null && oname.length()>0){
					String icon_type = oname.substring(oname.lastIndexOf('.')+1);
					String icon_name = UUID.randomUUID()+"."+icon_type;
					try {
						if ( !PicUtil.resizeAndSaveImage(icon.getInputStream(), icon_path+icon_name, icon_width, icon_type)){
							File f = new File(path_end+icon_name);
							icon.transferTo(f);
						}
						soft.setSoftIconLink(path_end+icon_name);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}
		//更新数据库
		Execution<Software> execution = softwareService.updateSoftware(soft);
		//保存截图到数据库
		if (execution.getState() == SoftwareStateEnum.SUCCESS.getState()){
			int sid = execution.getObj().getSoftId();
			softPicService.delPicBySid(sid);
			//匹配一下详细介绍里的图片
			String regEx = "(?<=<img src=\"/soft/image/)[\\S]*\\.[a-z]{3,4}";
			Pattern pattern = Pattern.compile(regEx);
			Matcher matcher = pattern.matcher(soft.getSoftDetails());
			while (matcher.find()) {
				String link = matcher.group();
				File f = new File(base_path+"soft/image/"+link);
				if (f.exists() && f.isFile()){
					SoftPic pic = new SoftPic();
					pic.setPicSize(f.length());
					pic.setPicLink(link);
					pic.setPicType(link.substring(link.lastIndexOf('.')+1));
					pic.setPicUserId(execution.getObj().getSoftUserId());
					pic.setPicSoftId(sid);
					softPicService.addPic(pic);
				}
			}
			request.setAttribute("resultInfo", execution.getStateInfo());
			return "result";
		}
		request.setAttribute("errorInfo", execution.getStateInfo());
		return "error";
	}
	@AuthPassport(isUser=true)
	@RequestMapping("/editHead")
	private String editHead(HttpServletRequest request) {
		return "headEdit";
	}
	@AuthPassport(isUser=true)
	@ResponseBody
	@RequestMapping("/editHeadExecution")
	private Execution<User> editHeadExecution(HttpServletRequest request,HttpSession session , @RequestParam(value = "head_pic",required = false) MultipartFile head_pic ) throws IllegalStateException, IOException {
		User sUser = (User)session.getAttribute("user");
		String ip = IPUtil.getIpAddress(request);
		User user = new User();
		user.setId(sUser.getId());
		user.setPreUpdateIp(ip);
		user.setPreUpdateTime(new Date());
		if (head_pic!=null){
			String oname = head_pic.getOriginalFilename().toLowerCase();
			if (oname!=null && oname.length()>0){
				String pic_link = sUser.getPicLink();
				String pic_path = request.getRealPath("/")+"user/head/";
				File f = new File(pic_path+pic_link);
				if (pic_link!=null && !pic_link.trim().equals("") && f.exists()){
					f.delete();
				}
				String pic_name;
				pic_name = UUID.randomUUID()+oname.substring(oname.lastIndexOf('.'));
				String head_type = oname.substring(oname.lastIndexOf('.')+1);
				if ( !PicUtil.resizeAndSaveImageForHead(head_pic.getInputStream(), pic_path+pic_name, PicUtil.HEAD_WIDTH, head_type)){
					File file = new File(pic_path+pic_name);
					head_pic.transferTo(file);
				}
				user.setPicLink(pic_name);
				 
			}
		}
		Execution<User> userExecution = userService.updateUserInfo(user);
		if (userExecution.getState()==UserStateEnum.SUCCESS.getState()) {
			session.setAttribute("user", userExecution.getObj());
		}
		
		return userExecution;
	}
}
