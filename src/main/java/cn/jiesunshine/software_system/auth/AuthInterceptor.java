package cn.jiesunshine.software_system.auth;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.jiesunshine.software_system.entity.User;
import cn.jiesunshine.software_system.utils.XssUtil;
import cn.jiesunshine.software_system.utils.UserType;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		XssUtil.filter(request);
		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			AuthPassport authPassport = ((HandlerMethod) handler)
					.getMethodAnnotation(AuthPassport.class);
			// 没有声明需要权限,或者声明不验证权限
			if (authPassport == null
					|| (authPassport.validate() == false
							&& authPassport.isUser() == false
							&& authPassport.isDevelop() == false && authPassport
							.isAdmin() == false))
				return true;
			else {
				User user = (User) request.getSession().getAttribute("user");
				if (user != null) {
					if (authPassport.isUser()) {
						// /如果是普通用户认证，执行判断操作
						if (user.getType() == UserType.USER || user.getType() == UserType.DEVELOP || user.getType() == UserType.ADMIN)
							return true;
					}
					if (authPassport.isDevelop()) {
						// /如果是开发者认证，执行判断操作
						if (user.getType() == UserType.DEVELOP || user.getType() == UserType.ADMIN)
							return true;
					}
					if (authPassport.isAdmin()) {
						// /如果是管理员认证，执行判断操作
						if (user.getType() == UserType.ADMIN)
							return true;
					}
					request.getRequestDispatcher("/WEB-INF/jsp/noPower.jsp").forward(request, response);
					return false;

				}else {
					response.sendRedirect(request.getContextPath()+"/login");
					return false;
				}
				
			}
		} else
			return true;
	}
}
