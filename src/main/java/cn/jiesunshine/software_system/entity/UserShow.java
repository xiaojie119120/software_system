package cn.jiesunshine.software_system.entity;

public class UserShow {
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserExpand getUserExpand() {
		return userExpand;
	}
	public void setUserExpand(UserExpand userExpand) {
		this.userExpand = userExpand;
	}
	private UserExpand userExpand;
}
