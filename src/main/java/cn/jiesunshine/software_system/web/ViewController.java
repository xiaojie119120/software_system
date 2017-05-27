package cn.jiesunshine.software_system.web;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.jiesunshine.software_system.dto.Execution;
import cn.jiesunshine.software_system.entity.SoftGroup;
import cn.jiesunshine.software_system.entity.Software;
import cn.jiesunshine.software_system.entity.User;
import cn.jiesunshine.software_system.enums.GroupStateEnum;
import cn.jiesunshine.software_system.enums.UserStateEnum;
import cn.jiesunshine.software_system.service.GroupService;
import cn.jiesunshine.software_system.service.SoftwareService;
import cn.jiesunshine.software_system.service.UserService;
import cn.jiesunshine.software_system.utils.IPUtil;
import cn.jiesunshine.software_system.utils.InspectUtil;
import cn.jiesunshine.software_system.utils.ListValue;
import cn.jiesunshine.software_system.utils.SoftUtil;
/***
 * 写一些整个系统的视图Controller，比如主页、注册、登录、注销等
 * @author xiaojie119120
 *
 */
@Controller
public class ViewController {
	@Autowired
	private UserService userService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private SoftwareService softwareService;
	/***
	 * 主页
	 * @return
	 */
	@RequestMapping(value = "/")
	private String index(HttpServletRequest request) {
		Execution<List<SoftGroup>> gExecution = groupService.getGroups();
		Execution<List<Software>> sExecution = softwareService.getNewSoftware(1,ListValue.USERLISTROWS_NUM);
		if (gExecution.getState() == GroupStateEnum.SUCCESS.getState()){
			request.setAttribute("groups", gExecution.getObj());
		}
		if (sExecution.getState() == GroupStateEnum.SUCCESS.getState()){
			request.setAttribute("newSofts", SoftUtil.softsToShows(sExecution.getObj()));
		}
		return "index";
	}
	/***
	 * 登录执行地址
	 * @param name
	 * @param pwd
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	private String loginExecution(String name,String pwd,HttpServletRequest request,HttpSession session) {
		Execution<User> inspectExecution;
		if ((inspectExecution = InspectUtil.UserNameInspect(name))!=null 
				|| (inspectExecution = InspectUtil.UserPwdInspect(pwd))!=null){
			request.setAttribute("state", inspectExecution.getState());	
			request.setAttribute("stateInfo", inspectExecution.getStateInfo());
			return "login";
		}
		String ip = IPUtil.getIpAddress(request);
		Execution<User> userExecution = userService.login(name, pwd,ip);
		request.setAttribute("state", userExecution.getState());	
		request.setAttribute("stateInfo", userExecution.getStateInfo());
		if (userExecution.getState() == UserStateEnum.SUCCESS.getState()){
			session.setMaxInactiveInterval(60*60*24*7);
			session.setAttribute("user", userExecution.getObj());	
			return "redirect:/";
		}else {
			return "login";
		}
	}
	/***
	 * 注册执行地址
	 * @param user
	 * @param repwd
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	private String registerExecution(User user,String repwd, HttpServletRequest request,HttpSession session) {
		Execution<User> inspectExecution;
		if ((inspectExecution = InspectUtil.UserNameInspect(user.getName()))!=null 
				|| (inspectExecution = InspectUtil.UserPwdInspect(user.getPassword()))!=null
				|| (inspectExecution = InspectUtil.UserEmailInspect(user.getEmail()))!=null){
			request.setAttribute("state",inspectExecution.getState());
			request.setAttribute("stateInfo", inspectExecution.getStateInfo());
			return "register";
		}
		if(!user.getPassword().equals(repwd)){
			request.setAttribute("state",UserStateEnum.REPWD_ERROR.getState());
			request.setAttribute("stateInfo",UserStateEnum.REPWD_ERROR.getStateInfo());
		}else {
			String ip = IPUtil.getIpAddress(request);
			user.setType(0);
			user.setRegIp(ip);
			user.setPreUpdateIp(ip);
			Execution<User> userExecution = userService.addUser(user);
			request.setAttribute("state",userExecution.getState());
			request.setAttribute("stateInfo",userExecution.getStateInfo());
			request.setAttribute("user", userExecution.getObj());
		}
		
		return "register";
	}
	/***
	 * 注销执行地址
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value="logout")
	public String logoutExecution(HttpServletRequest request,HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	/***
	 * 登录页面地址
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login")
	private String login(HttpServletRequest request,HttpSession session) {
		return "login";
	}
	/***
	 * 注册页面地址
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/register")
	private String register(HttpServletRequest request,HttpSession session) {
		return "register";
	}
	@RequestMapping(value = "/about")
	private String about(HttpServletRequest request) {
		return "about";
	}
}
