package cn.jiesunshine.software_system;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.jiesunshine.software_system.dao.UserDao;
import cn.jiesunshine.software_system.entity.User;

public class UserDaoTest extends BaseTest{
	@Autowired
	private UserDao userDao;
	
	public void testAddUser() throws Exception{
		User user = new User();
		
		//System.out.println(user);
	}
	
	public void testDelUser() throws Exception{

		userDao.delUserById(54);
	}
	
	
	public void testUpdateUser() throws Exception{
		User user = new User();
		user.setId(52);
		user.setName("xiaojie119120");
		user.setPicLink("null");
		user.setEmail("584719514@qq.com");
		user.setPreUpdateIp("127.0.0.1");
		userDao.updateUserInfo(user);
		System.out.println(user);
	}
	
	public void testUpdateUserPwd() throws Exception{
		
		userDao.updateUserPwd(46, "123123", "127.0.0.1");
	}
	
	public void testUpdateUserType() throws Exception{
		
		userDao.updateUserType(46, 3, "127.0.0.1");
	}
	
	public void testUpdateUserLoginIp() throws Exception{
		
		userDao.updateUserLoginIp(46, "127.0.0.1");
	}
	
	public void testQueryUser() throws Exception{
		
		User user = userDao.queryUserById(44);
		System.out.println(user);
	}
	
	public void testQueryUserAll() throws Exception{
		
		List<User> users = userDao.queryAllUsersInfo(0, 10);
		System.out.println(users);
	}
	@Test
	public void testQueryUserCount() {
		System.out.println(userDao.queryUserCount()+"");
	}

}
