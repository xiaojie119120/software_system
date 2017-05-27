package cn.jiesunshine.software_system.enums;

/**
 * @author xiaojie119120
 *
 */
public enum SoftwareStateEnum {
	SUCCESS(1,"操作成功"),
	SOFT_NO_EXIST(-0,"该软件不存在"),
	NAME_REPEAT(-1,"软件名重复"),
	USERID_NO_ERROR(-2,"用户ID错误"),
	GROUPID_NO_ERROR(-3,"分类ID错误"),
	KEY_ERROR(-4,"请输入关键字"),
	NAME_NULL(-5,"软件名不能为空"),
	NAME_LONG(-6,"软件名太长"),
	NAME_SHORT(-7,"软件名太短"),
	SOFT_NO_FIND(-8,"没找到相关的软件"),
	INNER_ERROR(-9, "系统异常");
	private int state;
	private String stateInfo;
	
	private SoftwareStateEnum(int state,String stateInfo) {
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

	public static SoftwareStateEnum stateOf(int index) {
		for (SoftwareStateEnum stateEnum : values()) {
			if (stateEnum.getState() == index){
				return stateEnum;
			}
		}
		return null;
	}
}
