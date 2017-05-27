package cn.jiesunshine.software_system.web;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import cn.jiesunshine.software_system.auth.AuthPassport;
import cn.jiesunshine.software_system.dto.Execution;
import cn.jiesunshine.software_system.entity.ExecutionDataInfo;
import cn.jiesunshine.software_system.entity.User;
import cn.jiesunshine.software_system.enums.UserStateEnum;
import cn.jiesunshine.software_system.service.UserService;
import cn.jiesunshine.software_system.utils.IPUtil;
import cn.jiesunshine.software_system.utils.InspectUtil;
import cn.jiesunshine.software_system.utils.PicUtil;
import cn.jiesunshine.software_system.utils.UserUtil;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	@AuthPassport(isAdmin = true)
	@RequestMapping(value = "/list/{page}")
	private String getUserList(HttpServletRequest request, @PathVariable int page) {
		Execution<List<User>> uExecution = userService.getUsers(page);
		if (uExecution.getState()==UserStateEnum.SUCCESS.getState()){
			ExecutionDataInfo eInfo = (ExecutionDataInfo)uExecution.getObjInfo();
			request.setAttribute("nowPage", page);
			request.setAttribute("maxPage", eInfo.getPageCount());
			request.setAttribute("userCount", eInfo.getDataCount());
			request.setAttribute("shows", UserUtil.usersToShows(uExecution.getObj()));
		}else {
			request.setAttribute("delInfo", 1);
			request.setAttribute("delInfo", "出错了："+uExecution.getStateInfo());
		}
		return "adminUser";
	}
	@AuthPassport(isAdmin = true)
	@RequestMapping(value = "/edit/{id}")
	private String editUser(HttpServletRequest request, @PathVariable int id) {
		Execution<User> userExecution = userService.getUserById(id);
		if (userExecution.getState() == UserStateEnum.SUCCESS.getState()){
			request.setAttribute("user", userExecution.getObj());
		}
		request.setAttribute("state", userExecution.getState());	
		request.setAttribute("stateInfo", userExecution.getStateInfo());
		return "userEdit";
	}
	@AuthPassport(isAdmin = true)
	@RequestMapping(value = "/editExecution",method = RequestMethod.POST)
	private String editUserExecution(HttpServletRequest request, User user,@RequestParam(value="head_pic",required=false) MultipartFile head_pic) throws IllegalStateException, IOException {
		request.setAttribute("uid", user.getId());
		Execution<User> inspectExecution;
		if ((user.getName()!=null && (inspectExecution = InspectUtil.UserNameInspect(user.getName()))!=null) 
				|| (user.getPassword()!=null && (inspectExecution = InspectUtil.UserPwdInspect(user.getPassword()))!=null)
				|| (user.getEmail()!=null && (inspectExecution = InspectUtil.UserEmailInspect(user.getEmail()))!=null)){
			request.setAttribute("stateInfo", inspectExecution.getStateInfo());
			return "userExecution";
		}
		String ip = IPUtil.getIpAddress(request);
		user.setPreUpdateIp(ip);
		user.setPreUpdateTime(new Date());
		if (head_pic!=null){
			String oname = head_pic.getOriginalFilename().toLowerCase();
			if (oname!=null && oname.length()>0){
				String pic_link = user.getPicLink();
				String pic_path = request.getRealPath("/")+"user/head/";
				File f = new File(pic_path+pic_link);
				if (pic_link!=null && !pic_link.trim().equals("") && f.exists()){
					f.delete();
				}
				String pic_name;
				pic_name = UUID.randomUUID()+oname.substring(oname.lastIndexOf('.'));
				String head_type = oname.substring(oname.lastIndexOf('.')+1);
				if ( !PicUtil.resizeAndSaveImage(head_pic.getInputStream(), pic_path+pic_name, PicUtil.HEAD_WIDTH, head_type)){
					File file = new File(pic_path+pic_name);
					head_pic.transferTo(file);
				}
				user.setPicLink(pic_name);
				 
			}
		}
		Execution<User> userExecution = userService.updateUserInfo(user);
		request.setAttribute("stateInfo", userExecution.getStateInfo());
		return "userExecution";
	}
	@AuthPassport(isAdmin = true)
	@RequestMapping(value = "/delete")
	private String deleteUserExecution(HttpServletRequest request, HttpSession session , int id,int page) {
		request.setAttribute("delState", 1);
		User u = (User)session.getAttribute("user");
		if (id==u.getId()){
			request.setAttribute("delInfo", "你不能删除自己！");
		}else {
			//删除头像图片
			request.setAttribute("nowPage", page);
			Execution<User> execution = userService.getUserById(id);
			if (execution.getState()==UserStateEnum.SUCCESS.getState()){
				User user = execution.getObj();
				String pic_link = user.getPicLink();
				String pic_path = request.getRealPath("/")+"user/head/";
				File f = new File(pic_path+pic_link);
				if (pic_link!=null && !pic_link.trim().equals("") && f.exists()){
					f.delete();
				}
				Execution<User> userExecution = userService.deleteUser(id);
				request.setAttribute("delInfo", userExecution.getStateInfo());
				
			}else {
				request.setAttribute("delInfo", execution.getStateInfo());
			}
		}
		Execution<List<User>> uExecution = userService.getUsers(page);
		if (uExecution.getState()==UserStateEnum.SUCCESS.getState()){
			ExecutionDataInfo eInfo = (ExecutionDataInfo)uExecution.getObjInfo();
			request.setAttribute("nowPage", page);
			request.setAttribute("maxPage", eInfo.getPageCount());
			request.setAttribute("userCount", eInfo.getDataCount());
			request.setAttribute("shows", UserUtil.usersToShows(uExecution.getObj()));
		}else {
			request.setAttribute("delInfo", 1);
			request.setAttribute("delInfo", "出错了："+uExecution.getStateInfo());
		}
		return "adminUser";
	}
	
}
