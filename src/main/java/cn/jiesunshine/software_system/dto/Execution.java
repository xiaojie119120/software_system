package cn.jiesunshine.software_system.dto;
import cn.jiesunshine.software_system.enums.GroupStateEnum;
import cn.jiesunshine.software_system.enums.SoftwareStateEnum;
/***
 * 负责service和web之间数据传输，封装类
 * @author xiaojie119120
 */
import cn.jiesunshine.software_system.enums.UserStateEnum;

public class Execution<T> {
	//操作状态码
	private int state;
	//操作状态信息
	private String stateInfo;
	//操作成功后的对象
	private T obj = null;
	//备用信息
	private Object objInfo = null;
	
	public Execution() {
		// TODO Auto-generated constructor stub
	}
	//操作失败的构造方法
	public Execution(Enum<?> stateEnum) {
		// TODO Auto-generated constructor stub
		setStateEnum(stateEnum);
	}
	//操作成功的构造方法
	public Execution(Enum<?> stateEnum,T obj) {
		// TODO Auto-generated constructor stub
		setStateEnum(stateEnum);
		this.obj = obj;
	}
	//
	public Execution(Enum<?> stateEnum,T obj, Object objInfo) {
		setStateEnum(stateEnum);
		this.obj = obj;
		this.objInfo = objInfo;
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
	
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		return "UserExecution [state=" + state + ", stateInfo=" + stateInfo
				+ ", user=" + obj + "]";
	}
	public Object getObjInfo() {
		return objInfo;
	}
	public void setObjInfo(Object objInfo) {
		this.objInfo = objInfo;
	}
	
	private void setStateEnum(Enum<?> stateEnum) {
		if (stateEnum instanceof UserStateEnum){
			UserStateEnum iStateEnum = (UserStateEnum) stateEnum;
			this.state = iStateEnum.getState();
			this.stateInfo = iStateEnum.getStateInfo();
		}else if (stateEnum instanceof SoftwareStateEnum){
			SoftwareStateEnum iStateEnum = (SoftwareStateEnum) stateEnum;
			this.state = iStateEnum.getState();
			this.stateInfo = iStateEnum.getStateInfo();
		}else if (stateEnum instanceof GroupStateEnum){
			GroupStateEnum iStateEnum = (GroupStateEnum) stateEnum;
			this.state = iStateEnum.getState();
			this.stateInfo = iStateEnum.getStateInfo();
		}
	}
	
	
	
}
