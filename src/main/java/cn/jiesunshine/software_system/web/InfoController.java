package cn.jiesunshine.software_system.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info")
public class InfoController {
	@RequestMapping(value = "/noPower")
	private String noPower(HttpServletRequest request) {
		return "noPower";
	}
	@RequestMapping(value = "/achieve")
	private String noAchieve(HttpServletRequest request) {
		request.setAttribute("resultInfo", "该功能还未实现，敬请期待！");
		return "result";
	}
}
