package cn.jiesunshine.software_system.utils;

public class UserType {
	/***
	 * 普通用户
	 */
	final public static int USER = 0;
	final public static String USER_STRING = "普通用户";
	/***
	 * 开发者
	 */
	final public static int DEVELOP = 1;
	final public static String DEVELOP_STRING = "软件分享者";
	/***
	 * 管理员
	 */
	final public static int ADMIN = 2;
	final public static String ADMIN_STRING = "管理员";
	
	private int userType;

	public UserType(int userType) {
		this.userType = userType;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	public String getUserTypeStr() {
		switch (this.userType) {
		case USER:
			return USER_STRING;
		case DEVELOP:
			return DEVELOP_STRING;
		case ADMIN:
			return ADMIN_STRING;
		default:
			return USER_STRING;
		}
	}
}
