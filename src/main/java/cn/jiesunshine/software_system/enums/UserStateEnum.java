package cn.jiesunshine.software_system.enums;


public enum UserStateEnum {
	SUCCESS(1,"操作成功"),
	USER_NO_EXIST(0,"用户不存在"),
	NAME_REPEAT(-1,"用户名已注册"),
	NAME_NO_SPEC(-2,"用户名格式错误"),
	NAME_LONG(-3,"用户名太长"),
	NAME_SHORT(-4,"用户名太短"),
	PWD_NO_SPEC(-5,"密码格式错误"),
	PWD_LONG(-6,"密码太长"),
	PWD_SHORT(-7,"密码太短"),
	PWD_ERROR(-8,"密码错误"),
	EMAIL_REPEAT(-9,"邮箱已注册"),
	EMAIL_NO_SPEC(-10,"邮箱格式错误"),
	NAME_PWD_ERROR(-11,"用户名或密码错误"),
	REPWD_ERROR(-12,"两次输入的密码不相同"),
	INNER_ERROR(-13, "系统异常"),
	HAS_NULL(-14,"不能输入空项");
	private int state;
	private String stateInfo;
	private UserStateEnum(int state,String stateInfo) {
		// TODO Auto-generated constructor stub
		this.state=state;
		this.stateInfo=stateInfo;
	}
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public static UserStateEnum stateOf(int index) {
		for (UserStateEnum stateEnum : values()) {
			if (stateEnum.getState() == index){
				return stateEnum;
			}
		}
		return null;
	}
}
