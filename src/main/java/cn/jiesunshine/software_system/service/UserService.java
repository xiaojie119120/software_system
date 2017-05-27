package cn.jiesunshine.software_system.service;

import java.util.List;

import cn.jiesunshine.software_system.dto.Execution;
import cn.jiesunshine.software_system.entity.User;

public interface UserService {
	
	//使用者：管理员
	/***
	 * 通过id查询一个用户
	 * @param id
	 * @return
	 */
	Execution<User> getUserById(int id);
	/***
	 * 通过用户名查询一个用户
	 * @param name
	 * @return
	 */
	Execution<User> getUserByName(String name);
	/***
	 * 查询所有用户
	 * @param page
	 * @return
	 */
	Execution<List<User>> getUsers(int page);
	/***
	 * 通过用户名关键字查找用户
	 * @param name
	 * @param page
	 * @return
	 */
	Execution<List<User>> getUsersByName(String name,int page);
	/***
	 * 通过id删除某个用户
	 * @param id
	 * @return
	 */
	Execution<User> deleteUser(int id);
	/***
	 * 增加用户
	 * @param user 需要传入  用户名、密码、邮箱、用户类型、所有ip
	 * @return
	 */
	Execution<User> addUser(User user);
	/***
	 * 更新用户所有信息
	 * @param user 需要传人 id、用户名、邮箱、密码、用户类型、头像、更新ip
	 * @return
	 */
	Execution<User> updateUserAllInfo(User user);
	//使用者：普通用户
	/***
	 * 注册用户
	 * @param user 需要传入  用户名、密码、邮箱、用户类型、所有ip
	 * @return
	 */
	Execution<User> register(User user);
	/***
	 * 用户登录
	 * @param name
	 * @param pwd
	 * @param ip
	 * @return
	 */
	Execution<User> login(String name,String pwd,String ip);
	/***
	 * 更新用户信息
	 * @param user 
	 * @return
	 */
	Execution<User> updateUserInfo(User user);
	/***
	 * 软件数量-1
	 * @param uid
	 * @param ip
	 * @return
	 */
	void delSoftCount(int uid,String ip);
	/***
	 * 软件数量+1
	 * @param uid
	 * @param ip
	 * @return
	 */
	void addSoftCount(int uid,String ip);
	
}
