package cn.jiesunshine.software_system.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.jiesunshine.software_system.dto.Execution;
import cn.jiesunshine.software_system.enums.UserStateEnum;
import cn.jiesunshine.software_system.service.UserService;

@Controller
@RequestMapping("/ajax/user")
public class AjaxUserController {
	
}
