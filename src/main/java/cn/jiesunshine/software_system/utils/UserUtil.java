package cn.jiesunshine.software_system.utils;

import java.util.ArrayList;
import java.util.List;

import cn.jiesunshine.software_system.entity.User;
import cn.jiesunshine.software_system.entity.UserExpand;
import cn.jiesunshine.software_system.entity.UserShow;

public class UserUtil {
	/***
	 * Users--->UserShows
	 * @param users
	 * @return
	 */
	public static List<UserShow> usersToShows(List<User> users) {
		List<UserShow> uss = new ArrayList<UserShow>();
		for (User user : users) {
			uss.add(userToShow(user));
		}
		return uss;
	}
	/***
	 * User--->UserShow
	 * @param user
	 * @return
	 */
	public static UserShow userToShow(User user) {
		UserShow us = new UserShow();
		UserExpand ue = new UserExpand();
		us.setUser(user);
		ue.setUserTypeStr(new UserType(user.getType()).getUserTypeStr());
		us.setUserExpand(ue);
		return us;
	}
}
