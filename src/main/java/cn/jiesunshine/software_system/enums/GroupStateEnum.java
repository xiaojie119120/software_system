package cn.jiesunshine.software_system.enums;

/**
 * @author xiaojie119120
 *
 */
public enum GroupStateEnum {
	SUCCESS(1,"操作成功"),
	INNER_ERROR(0, "系统异常"),
	GROUP_NO_EXIST(-1,"该分类不存在"),
	NAME_REPEAT(-2,"分类名重复"),
	NO_GROUP(-3,"没有分类");
	private int state;
	private String stateInfo;
	
	private GroupStateEnum(int state,String stateInfo) {
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

	public static GroupStateEnum stateOf(int index) {
		for (GroupStateEnum stateEnum : values()) {
			if (stateEnum.getState() == index){
				return stateEnum;
			}
		}
		return null;
	}
}
