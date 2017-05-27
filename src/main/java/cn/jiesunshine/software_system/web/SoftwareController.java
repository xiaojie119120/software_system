package cn.jiesunshine.software_system.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;








import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.jiesunshine.software_system.auth.AuthPassport;
import cn.jiesunshine.software_system.dao.BaiduLinkMapper;
import cn.jiesunshine.software_system.dao.UserDao;
import cn.jiesunshine.software_system.dto.Execution;
import cn.jiesunshine.software_system.entity.BaiduLink;
import cn.jiesunshine.software_system.entity.ExecutionDataInfo;
import cn.jiesunshine.software_system.entity.SoftGroup;
import cn.jiesunshine.software_system.entity.SoftPic;
import cn.jiesunshine.software_system.entity.Software;
import cn.jiesunshine.software_system.entity.SoftwareExtend;
import cn.jiesunshine.software_system.entity.User;
import cn.jiesunshine.software_system.enums.GroupStateEnum;
import cn.jiesunshine.software_system.enums.SoftwareStateEnum;
import cn.jiesunshine.software_system.service.BaiduLinkService;
import cn.jiesunshine.software_system.service.GroupService;
import cn.jiesunshine.software_system.service.SoftPicService;
import cn.jiesunshine.software_system.service.SoftwareService;
import cn.jiesunshine.software_system.service.UserService;
import cn.jiesunshine.software_system.utils.IPUtil;
import cn.jiesunshine.software_system.utils.InspectUtil;
import cn.jiesunshine.software_system.utils.ListValue;
import cn.jiesunshine.software_system.utils.PicUtil;
import cn.jiesunshine.software_system.utils.SoftUtil;
import cn.jiesunshine.software_system.utils.XssUtil;

@Controller
@RequestMapping(value = "soft")
public class SoftwareController {
	@Autowired
	private SoftwareService softwareService;
	@Autowired
	private SoftPicService softPicService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private UserService userService;
	@Autowired
	private BaiduLinkService baiduLinkService;
	@RequestMapping(value = "/user/{uid}/{page}")
	private String viewSoftListByUser(HttpServletRequest request, @PathVariable int page,@PathVariable int uid) {
		Execution<List<Software>> execution = softwareService.getSoftwaresByUserId(uid, page);
		request.setAttribute("nowPage", page);
		request.setAttribute("uid", uid);
		if (execution.getState()==SoftwareStateEnum.SUCCESS.getState()){
			int maxPage = (int)execution.getObjInfo();
			if (page<1)
				return "redirect:1";
			else if (page>maxPage) {
				return "redirect:"+maxPage;
			}
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("softs", SoftUtil.softsToShows(execution.getObj()));
		}
		return "userSoftList";
	}
	@RequestMapping(value = "/group/{gid}/{page}")
	private String viewSoftListByGroup(HttpServletRequest request, @PathVariable int page,@PathVariable int gid) {
		Execution<List<SoftGroup>> gExecution = groupService.getGroups();
		if (gExecution.getState()==GroupStateEnum.SUCCESS.getState()){
			request.setAttribute("groups", gExecution.getObj());
			Execution<List<Software>> execution = softwareService.getSoftwaresByGroupId(gid, page);
			request.setAttribute("nowPage", page);
			request.setAttribute("gid", gid);
			if (execution.getState()==SoftwareStateEnum.SUCCESS.getState()){
				int maxPage = (int)execution.getObjInfo();
				if (page<1)
					return "redirect:1";
				else if (page>maxPage) {
					return "redirect:"+maxPage;
				}
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("softs", SoftUtil.softsToShows(execution.getObj()));
			}
		}
		
		return "groupSoftList";
	}
	@RequestMapping(value = "/group")
	private String viewSoftGroup(HttpServletRequest request) {
		Execution<List<SoftGroup>> gExecution = groupService.getGroups();
		
		if (gExecution.getState()==GroupStateEnum.SUCCESS.getState()){
			int page = 1;
			int gid = gExecution.getObj().get(0).getGroupId();
			request.setAttribute("groups", gExecution.getObj());
			Execution<List<Software>> execution = softwareService.getSoftwaresByGroupId(gid, page);
			request.setAttribute("nowPage",page);
			request.setAttribute("gid", gid);
			if (execution.getState()==SoftwareStateEnum.SUCCESS.getState()){
				int maxPage = (int)execution.getObjInfo();
				if (page<1)
					return "redirect:1";
				else if (page>maxPage) {
					return "redirect:"+maxPage;
				}
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("softs", SoftUtil.softsToShows(execution.getObj()));
			}
		}
		
		return "groupSoftList";
	}
	@RequestMapping(value = "/search/{page}")
	private String viewSoftListBySearch(HttpServletRequest request,RedirectAttributes attr, @PathVariable int page,String sname) {
		if (sname==null || sname.trim().equals("")){
			return "redirect:/"+request.getContextPath();
		}
		Execution<List<Software>> execution = softwareService.getSoftwaresBySoftNameLike(sname, page);
		request.setAttribute("searchName", XssUtil.decode(sname));
		if (execution.getState()==SoftwareStateEnum.SUCCESS.getState()){
			int maxPage = (int)execution.getObjInfo();
			if (page<1){
				attr.addAttribute("sname", sname);
				return "redirect:1";
			}
			else if (page>maxPage) {
				attr.addAttribute("sname", sname);
				return "redirect:"+maxPage;
			}
			request.setAttribute("nowPage", page);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("softs", SoftUtil.softToShowAndRedKey(execution.getObj(),sname));
		}
		return "searchSoftList";
	}
	@RequestMapping(value="/details/{id}")
	private String viewSoftwareDetails(HttpServletRequest request , @PathVariable int id) {
		Execution<SoftwareExtend> execution = softwareService.getSoftwareExtendById(id);
		if (execution.getState() == SoftwareStateEnum.SUCCESS.getState()){
			List<SoftPic> pics = softPicService.getPicBySid(id);
			request.setAttribute("soft", SoftUtil.softToShow(execution.getObj()));
			request.setAttribute("pics", pics);
			BaiduLink baiduLink = baiduLinkService.getBaiduLinkBySid(id);
			request.setAttribute("baiduLink", baiduLink);
			return "softDetails";
		}else {
			request.setAttribute("errorInfo", execution.getStateInfo());
			return "error";
		}
		
	}
	@RequestMapping(value="/new/all/{page}")
	private String viewNewSoft(HttpServletRequest request, @PathVariable int page) {
		Execution<List<Software>> sExecution = softwareService.getNewSoftware(page,ListValue.USERLISTROWS_NUM);
		request.setAttribute("nowPage", page);
		request.setAttribute("pageType", 0);
		if (sExecution.getState() == SoftwareStateEnum.SUCCESS.getState()){
			int maxPage = (int)sExecution.getObjInfo();
			if (page<1)
				return "redirect:1";
			else if (page>maxPage) {
				return "redirect:"+maxPage;
			}
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("newSofts", SoftUtil.softsToShows(sExecution.getObj()));
		}
		return "newSoft";
	}
	@RequestMapping(value="/new/today/{page}")
	private String viewTodaySoft(HttpServletRequest request, @PathVariable int page) {
		Execution<List<Software>> sExecution = softwareService.getSoftwaresByDate(new Date(),page,ListValue.USERLISTROWS_NUM);
		request.setAttribute("nowPage", page);
		request.setAttribute("pageType", 1);
		if (sExecution.getState() == SoftwareStateEnum.SUCCESS.getState()){
			int maxPage = (int)sExecution.getObjInfo();
			if (page<1)
				return "redirect:1";
			else if (page>maxPage) {
				return "redirect:"+maxPage;
			}
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("newSofts", SoftUtil.softsToShows(sExecution.getObj()));
		}
		return "newSoft";
	}
	@RequestMapping(value="/new/yestoday/{page}")
	private String viewYestodaySoft(HttpServletRequest request, @PathVariable int page) {
		Execution<List<Software>> sExecution = softwareService.getSoftwaresByDate(new Date(new Date().getTime()-86400000L),page,ListValue.USERLISTROWS_NUM);
		request.setAttribute("nowPage", page);
		request.setAttribute("pageType", 2);
		if (sExecution.getState() == SoftwareStateEnum.SUCCESS.getState()){
			int maxPage = (int)sExecution.getObjInfo();
			if (page<1)
				return "redirect:1";
			else if (page>maxPage) {
				return "redirect:"+maxPage;
			}
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("newSofts", SoftUtil.softsToShows(sExecution.getObj()));
		}
		return "newSoft";
	}
	@AuthPassport(isDevelop = true)
	@RequestMapping(value="/upload")
	private String addSoftware(HttpServletRequest request) {
		Execution<List<SoftGroup>> execution = groupService.getGroups();
		if (execution.getState() == GroupStateEnum.SUCCESS.getState()){
			request.setAttribute("groups", execution.getObj());
		}
		return "uploadSoft";
	}
	@AuthPassport(isDevelop = true)
	@RequestMapping(value="/uploadExecution")
	private String addSoftwareExecution(HttpServletRequest request , Software soft ,String baiduLink , @RequestParam(value = "file",required = false) MultipartFile file , @RequestParam(value = "icon",required = false) MultipartFile icon) throws IllegalStateException, IOException {
		//空值验证
		Execution<Software> inspectExecution = InspectUtil.SoftwareNameInspect(soft.getSoftName());
		if (inspectExecution!=null){
			request.setAttribute("errorInfo", inspectExecution.getStateInfo());
			return "error";
		}
		if (icon==null || icon.isEmpty()) {
			request.setAttribute("errorInfo", "必须上传软件图标！");
			return "error";
		}
		if ((file==null|| file.isEmpty()) && baiduLink == null){
			request.setAttribute("errorInfo", "必须上传软件文件或者输入百度网盘地址！");
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
		//设置软件大小为0，设置下载量为0
		soft.setSoftSize(0l);
		soft.setSoftDownloadVolume(0);
		//设置ip
		String ip = IPUtil.getIpAddress(request);
		soft.setSoftCreateIp(ip);
		soft.setPreUpdateIp(ip);
		//设置时间
		Date nowDate = new Date();
		soft.setSoftCreateTime(nowDate);
		soft.setPreUpdateTime(nowDate);
		soft.setSoftDate(nowDate);
		//设置上传者id
		if (request.getSession().getAttribute("user")==null){
			return "login";
		}
		int uid = ((User)request.getSession().getAttribute("user")).getId();
		soft.setSoftUserId(uid);
		Execution<Software> execution = softwareService.addSoftware(soft);
		if (execution.getState() == SoftwareStateEnum.SUCCESS.getState()){
			userService.addSoftCount(uid, ip);
			String base_path = request.getRealPath("/");
			Software software = execution.getObj();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
			String path_end = sdf.format(nowDate);
			//保存文件
			String file_path = base_path + "soft/file/"+path_end;
			File dir = new File(file_path);
			if (!dir.exists()){
				dir.mkdirs();
			}
			//保存百度网盘地址
			if (baiduLink!=null){
				BaiduLink bLink = new BaiduLink();
				bLink.setBdLink(baiduLink);
				bLink.setBdSoftId(software.getSoftId());
				bLink.setBdType(1);
				baiduLinkService.addBaiduLink(bLink);
			}
			else if (!file.isEmpty()){
				String oname = file.getOriginalFilename();
				if (oname!=null && oname.length()>0){
					String file_name = UUID.randomUUID()+oname.substring(oname.lastIndexOf('.'));
					File f = new File(file_path+file_name);
					file.transferTo(f);
					software.setSoftFileLink(path_end+file_name);
					software.setSoftSize(file.getSize());
				}
			}
			//保存图标
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
						software.setSoftIconLink(path_end+icon_name);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
			//更新数据库
			softwareService.updateSoftware(software);
			//保存截图到数据库
			int sid = execution.getObj().getSoftId();
			//匹配一下详细介绍里的图片
			String regEx = "(?<=<img src=\"/soft/image/)[\\S]*\\.[a-z]{3,4}";
			Pattern pattern = Pattern.compile(regEx);
			Matcher matcher = pattern.matcher(software.getSoftDetails());
			while (matcher.find()) {
				String link = matcher.group();
				File f = new File(base_path+"soft/image/"+link);
				if (f.exists() && f.isFile()){
					SoftPic pic = new SoftPic();
					pic.setPicSize(f.length());
					pic.setPicLink(link);
					pic.setPicType(link.substring(link.lastIndexOf('.')+1));
					pic.setPicUserId(uid);
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
	@AuthPassport(isAdmin = true)
	@RequestMapping(value = "/delete/{id}")
	private String deleteSoftware(HttpServletRequest request ,HttpSession session, @PathVariable int id,@RequestParam(value="page",required=false,defaultValue="0")int page) {
		if (page == 0){
			return "redirect:"+request.getContextPath()+"/my/soft/1";
		}
		User user = (User)session.getAttribute("user");
		if (user==null){
			return "login";
		}
		Execution<Software> execution = softwareService.getSoftwareById(id);
		if (execution.getState() == SoftwareStateEnum.SUCCESS.getState()){
			Software software = execution.getObj();
			int uid = 0;
			if (software.getSoftUserId()!=null)
				uid = software.getSoftUserId();
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
			execution = softwareService.deleteSoftware(id);
			if (execution.getState() == SoftwareStateEnum.SUCCESS.getState()){
				userService.delSoftCount(uid, IPUtil.getIpAddress(request));
				request.setAttribute("delState", 1);
				request.setAttribute("delInfo", "删除成功！");
			}
		}else {
			request.setAttribute("delState", 1);
			request.setAttribute("delInfo", "删除失败，"+execution.getStateInfo());
		}
		request.setAttribute("nowPage", page);
		Execution<List<Software>> sExecution = softwareService.getAllSoftwares(page);
		if (sExecution.getState()==SoftwareStateEnum.SUCCESS.getState()){
			ExecutionDataInfo eInfo = (ExecutionDataInfo)sExecution.getObjInfo();
			int maxPage = eInfo.getPageCount();
			int softCount = eInfo.getDataCount();
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("softCount", softCount);
			request.setAttribute("softs", sExecution.getObj());
		}
		return "adminSoft";
	}
	@AuthPassport(isAdmin = true)
	@RequestMapping(value="/edit/{id}")
	private String updateSoftware(HttpServletRequest request , @PathVariable int id) {
		Execution<Software> execution = softwareService.getSoftwareById(id);
		if (execution.getState() == SoftwareStateEnum.SUCCESS.getState()){
			//读取网盘地址
			BaiduLink baiduLink = baiduLinkService.getBaiduLinkBySid(id);
			request.setAttribute("baiduLink", baiduLink);
			request.setAttribute("soft", execution.getObj());
			Execution<List<SoftGroup>> gExecution = groupService.getGroups();
			if (execution.getState() == GroupStateEnum.SUCCESS.getState()){
				request.setAttribute("groups", gExecution.getObj());
			}
			return "adminEditSoft";
		}else {
			request.setAttribute("errorInfo", execution.getStateInfo());
			return "error";
		}
		
	}
	/***
	 * 编辑软件提交
	 * @param request
	 * @param soft
	 * @param file
	 * @param icon
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@AuthPassport(isAdmin = true)
	@RequestMapping(value="/editExecution")
	private String updateSoftwareExecution(HttpServletRequest request , Software soft , @RequestParam(value = "file",required = false) MultipartFile file , @RequestParam(value = "icon",required = false) MultipartFile icon , String baiduLink) throws IllegalStateException, IOException {
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
	@RequestMapping(value="/download/{id}")
	private String download(@PathVariable int id,HttpServletRequest request,HttpServletResponse response) {
		if (id != 0) {
			Execution<Software> execution = softwareService.downSoftwaresById(id);
			if (execution.getState()==SoftwareStateEnum.SUCCESS.getState()){
				Software software = execution.getObj();
				String link = software.getSoftFileLink();
				if (link == null || link.equals("")){
					//读取网盘地址
					BaiduLink baiduLink = baiduLinkService.getBaiduLinkBySid(id);
					return "redirect:http://"+baiduLink.getBdLink();
				}else {
					String path = request.getServletContext().getRealPath(
		                    "soft/file/"+software.getSoftFileLink());
		            
		            File file = new File(path);
		            String fileName = file.getName();
		            if (file.exists()) {
		                response.setContentType("application/force-download");// 设置强制下载不打开
		                response.addHeader("Content-Disposition",
		                        "attachment;fileName=" + fileName);// 设置文件名
		                response.setContentLength(software.getSoftSize().intValue());
		                byte[] buffer = new byte[1024];
		                FileInputStream fis = null;
		                BufferedInputStream bis = null;
		                try {
		                    fis = new FileInputStream(file);
		                    bis = new BufferedInputStream(fis);
		                    OutputStream os = response.getOutputStream();
		                    int i = bis.read(buffer);
		                    while (i != -1) {
		                        os.write(buffer, 0, i);
		                        i = bis.read(buffer);
		                    }
		                } catch (Exception e) {
		                    // TODO: handle exception
		                    e.printStackTrace();
		                } finally {
		                    if (bis != null) {
		                        try {
		                            bis.close();
		                        } catch (IOException e) {
		                            // TODO Auto-generated catch block
		                            e.printStackTrace();
		                        }
		                    }
		                    if (fis != null) {
		                        try {
		                            fis.close();
		                        } catch (IOException e) {
		                            // TODO Auto-generated catch block
		                            e.printStackTrace();
		                        }
		                    }
		                }
		                return null;
		            }
				}
	            
			}
			
        }
		request.setAttribute("errorInfo", "该软件已经被删除，请联系管理员!");
		return "error";
	}
	@RequestMapping("/downVolume/{page}")
	private String viewDownSoft(HttpServletRequest request,@PathVariable int page) {
		Execution<List<Software>> execution = softwareService.getSoftwaresByDown(page);
		if (execution.getState() == SoftwareStateEnum.SUCCESS.getState()){
			int maxPage = (int)execution.getObjInfo();
			if (page<1)
				return "redirect:1";
			else if (page>maxPage) {
				return "redirect:"+maxPage;
			}
			request.setAttribute("softs", SoftUtil.softsToShows(execution.getObj()));
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("nowPage", page);
		}
		return "downSoft";
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/upload_json",  produces = "text/html;charset=UTF-8")
	private String uploadJson(HttpServletRequest request) {
		//文件保存目录路径
		String savePath = request.getRealPath("/") + "soft/";
		//文件保存目录URL
		String saveUrl = request.getContextPath()+"/soft/";
		//定义允许上传的文件扩展名
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		//最大文件大小
		long maxSize = 5000000;

		if (!ServletFileUpload.isMultipartContent(request)) {
			return getError("请选择文件。");
		}
		//检查目录
		File uploadDir = new File(savePath);
		if (!uploadDir.isDirectory()) {
			return getError("上传目录不存在。" + savePath);
		}
		//检查目录写权限
		if (!uploadDir.canWrite()) {
			return getError("上传目录没有写权限。");
		}

		String dirName = request.getParameter("dir");
		if (dirName == null) {
			dirName = "image";
		}
		if (!extMap.containsKey(dirName)) {
			return getError("目录名不正确。");
		}
		//创建文件夹
		savePath += dirName + "/";
		saveUrl += dirName + "/";
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String ymd = sdf.format(new Date());
		savePath += ymd + "/";
		saveUrl += ymd + "/";
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		
		MultipartHttpServletRequest multipartrequest = (MultipartHttpServletRequest) request;
		
		try {
			@SuppressWarnings("rawtypes")
			Iterator itr = multipartrequest.getFileNames();
			while (itr.hasNext()) {
				//FileItem item = (FileItem) itr.next();
				String name = (String) itr.next();
				MultipartFile mul = multipartrequest.getFile(name);
				String fileName = mul.getOriginalFilename();
				long fileSize = mul.getSize();
					//检查文件大小
					if (fileSize > maxSize) {
						return getError("上传文件大小超过限制。");
					}
					//检查扩展名
					String fileExt = fileName.substring(
							fileName.lastIndexOf(".") + 1).toLowerCase();
					if (!Arrays.<String> asList(extMap.get(dirName).split(","))
							.contains(fileExt)) {
						return getError("上传文件扩展名是不允许的扩展名。\n只允许"
								+ extMap.get(dirName) + "格式。");
					}
					String newFileName = UUID.randomUUID() + "." + fileExt;
					try {
						File uploadedFile = new File(savePath, newFileName);
						byte[] bytes =  mul.getBytes();
						FileOutputStream fos = new FileOutputStream(uploadedFile);
						fos.write(bytes);
						fos.flush();
						fos.close();

					} catch (Exception e) {
						e.printStackTrace();
						return getError("上传文件失败。");
					}

					JSONObject obj = new JSONObject();
					obj.put("error", 0);
					if (fileExt.contains("gif") 
							|| fileExt.contains("jpg")
							|| fileExt.contains("jpeg")
							|| fileExt.contains("png")
							|| fileExt.contains("bmp"))
						obj.put("url", saveUrl + newFileName);
					else {
						
					}
					return obj.toJSONString();
				}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return getError("未知错误");
	}
	@SuppressWarnings("unchecked")
	private String getError(String message) {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		return obj.toJSONString();
	}
}
