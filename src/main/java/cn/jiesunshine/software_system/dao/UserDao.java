package cn.jiesunshine.software_system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jiesunshine.software_system.entity.User;

public interface UserDao {
	/***
	 * 增加一条用户记录，不设置id，自增
	 * @param user
	 * @return
	 */
	void addUser(User user);
	/***
	 * 通过id删除一条用户记录
	 * @param id
	 * @return
	 */
	void delUserById(int id);
	/***
	 * 通过id更新用户信息，时间CURRENT_TIMESTAMP
	 * @param user 需要传人  id、用户名、邮箱、头像、更新ip
	 */
	void updateUserInfo(User user);
	/***
	 * 通过id更新用户所有信息，时间CURRENT_TIMESTAMP
	 * @param user 需要传人  id、用户名、邮箱、密码、用户类型、头像、更新ip
	 */
	void updateUserAllInfo(User user);
	/***
	 * 减少上传的软件数，时间CURRENT_TIMESTAMP
	 * @param id
	 * @param ip 更新的ip
	 * @return 返回值为0时，代表减少失败
	 */
	int reduceSoftwareCount(@Param("id") int id,@Param("ip") String ip);
	/***
	 * 增加上传的软件数，时间CURRENT_TIMESTAMP
	 * @param id
	 * @param ip 更新的ip
	 */
	void addSoftwareCount(@Param("id") int id,@Param("ip") String ip);
	/***
	 * 通过id更新用户密码，时间CURRENT_TIMESTAMP
	 * @param id
	 * @param pwd
	 * @param ip
	 */
	void updateUserPwd(@Param("id") int id,@Param("pwd") String pwd,@Param("ip") String ip);
	/***
	 * 通过id更新用户类型，时间CURRENT_TIMESTAMP
	 * @param id
	 * @param type
	 * @param ip
	 */
	void updateUserType(@Param("id") int id,@Param("type") int type,@Param("ip") String ip);
	/***
	 * 通过id更新用户登录时间和ip，时间CURRENT_TIMESTAMP
	 * @param id
	 * @param ip
	 */
	void updateUserLoginIp(@Param("id") int id,@Param("ip") String ip);
	/***
	 * 通过id查询一条用户记录
	 * @param id
	 * @return
	 */
	User queryUserById(int id);
	/***
	 * 查询所有用户信息（仅包含用户信息）
	 * @param offset 起始位置
	 * @param limit  查询条数
	 * @return
	 */
	List<User> queryAllUsersInfo(@Param("offset") int offset,@Param("limit") int limit);
	/***
	 * 查询所有用户记录（所有字段）
	 * @param offset 起始位置
	 * @param limit  查询条数
	 * @return
	 */
	List<User> queryAllUsers(@Param("offset") int offset,@Param("limit") int limit);
	/***
	 * 通过用户名查询一条用户记录
	 * @param name
	 * @return
	 */
	User queryUserByName(String name);
	/***
	 * 通过用户名查询记录是否存在
	 * @param name
	 * @return 0：不存在  1：存在
	 */
	int queryUserExistByName(String name);
	/***
	 * 通过邮箱查询记录是否存在
	 * @param email
	 * @return 0：不存在  1：存在
	 */
	int queryUserExistByEmail(String email);
	/***
	 * 查询用户总数
	 * @return
	 */
	int queryUserCount();
	
}
