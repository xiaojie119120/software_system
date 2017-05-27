package cn.jiesunshine.software_system.utils;

import java.util.regex.Pattern;

import cn.jiesunshine.software_system.dto.Execution;
import cn.jiesunshine.software_system.entity.Software;
import cn.jiesunshine.software_system.entity.User;
import cn.jiesunshine.software_system.enums.SoftwareStateEnum;
import cn.jiesunshine.software_system.enums.UserStateEnum;

public class InspectUtil {
	/***
	 * 验证用户名——空值验证，长度验证，格式验证
	 * @param name
	 * @return
	 */
	public static Execution<User> UserNameInspect(String name) {
		if ((name==null || name.equals(""))){
			return new Execution<User>(UserStateEnum.HAS_NULL);
		}
		int len = 0;
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i)>=0x4e00 && name.charAt(i)<=0x9fa5){
				len++;
			}
			len++;
		}
		if (len>14)
			return new Execution<User>(UserStateEnum.NAME_LONG);
		if (len<4)
			return new Execution<User>(UserStateEnum.NAME_SHORT); 
		if (!Pattern.compile("^[\u4e00-\u9fa5A-Za-z0-9_]+$").matcher(name).find()){
			return new Execution<User>(UserStateEnum.NAME_NO_SPEC);
		}
		return null;
	}
	/***
	 * 验证email——空值验证，格式验证
	 * @param email
	 * @return
	 */
	public static Execution<User> UserEmailInspect(String email) {
		if ((email==null || email.equals(""))){
			return new Execution<User>(UserStateEnum.HAS_NULL);
		}
		if (!Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*").matcher(email).find()){
			return new Execution<User>(UserStateEnum.EMAIL_NO_SPEC);
		}
		return null;
	}
	/***
	 * 验证密码——空值验证，长度验证，格式验证
	 * @param pwd
	 * @return
	 */
	public static Execution<User> UserPwdInspect(String pwd) {
		if ((pwd==null || pwd.equals(""))){
			return new Execution<User>(UserStateEnum.HAS_NULL);
		}
		int len = pwd.length();
		if (len>16)
			return new Execution<User>(UserStateEnum.PWD_LONG);
		if (len<6)
			return new Execution<User>(UserStateEnum.PWD_SHORT); 
		if (!Pattern.compile("^[A-Za-z0-9!@#$]{6,16}$").matcher(pwd).find()){
			return new Execution<User>(UserStateEnum.NAME_NO_SPEC);
		}
		return null;
	}
	public static Execution<Software> SoftwareNameInspect(String name) {
		if ((name==null || name.equals(""))){
			return new Execution<Software>(SoftwareStateEnum.NAME_NULL);
		}
		if (name.length()>50){
			return new Execution<Software>(SoftwareStateEnum.NAME_LONG);
		}
		if (name.length()<4){
			return new Execution<Software>(SoftwareStateEnum.NAME_SHORT);
		}
		return null;
	}
}
