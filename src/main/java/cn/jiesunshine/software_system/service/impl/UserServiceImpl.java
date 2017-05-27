package cn.jiesunshine.software_system.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jiesunshine.software_system.dao.UserDao;
import cn.jiesunshine.software_system.dao.UserMapper;
import cn.jiesunshine.software_system.dto.Execution;
import cn.jiesunshine.software_system.entity.ExecutionDataInfo;
import cn.jiesunshine.software_system.entity.User;
import cn.jiesunshine.software_system.enums.UserStateEnum;
import cn.jiesunshine.software_system.service.UserService;
import cn.jiesunshine.software_system.utils.ListValue;

@Service
public class UserServiceImpl implements UserService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserMapper userMapper;
	@Override
	public Execution<User> getUserById(int id) {
		// TODO Auto-generated method stub
		try {
			User user = userDao.queryUserById(id);
			if (user == null) {
				return new Execution<User>(UserStateEnum.USER_NO_EXIST);
			} else {
				return new Execution<User>(UserStateEnum.SUCCESS, user);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new Execution<User>(UserStateEnum.INNER_ERROR);
		}
	}

	@Override
	public Execution<User> getUserByName(String name) {
		// TODO Auto-generated method stub
		try {
			User user = userDao.queryUserByName(name);
			if (user == null) {
				return new Execution<User>(UserStateEnum.USER_NO_EXIST);
			} else {
				return new Execution<User>(UserStateEnum.SUCCESS, user);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new Execution<User>(UserStateEnum.INNER_ERROR);
		}
	}

	@Override
	public Execution<List<User>> getUsers(int page) {
		// TODO Auto-generated method stub
		List<User> users = null;
		ExecutionDataInfo eInfo = new ExecutionDataInfo();
		try {
			
			int maxPage=1;
			int count = userDao.queryUserCount();
			eInfo.setDataCount(count);
			if (count <= ListValue.USERLISTROWS_NUM) {
				users = userDao.queryAllUsersInfo(0, ListValue.USERLISTROWS_NUM);
				eInfo.setPageCount(maxPage);
				return new Execution<List<User>>(UserStateEnum.SUCCESS, users, eInfo);
			} else {
				maxPage = count % ListValue.USERLISTROWS_NUM == 0 ? count / ListValue.USERLISTROWS_NUM : count
						/ ListValue.USERLISTROWS_NUM + 1;
				eInfo.setPageCount(maxPage);
				if (page <= 1) {
					users = userDao.queryAllUsersInfo(0, ListValue.USERLISTROWS_NUM);
					return new Execution<List<User>>(UserStateEnum.SUCCESS, users, eInfo);
					
				} else if (page >= maxPage) {
					users = userDao.queryAllUsersInfo((maxPage - 1) * ListValue.USERLISTROWS_NUM,
							ListValue.USERLISTROWS_NUM);
					return new Execution<List<User>>(UserStateEnum.SUCCESS, users, eInfo);
				} else {
					users = userDao.queryAllUsersInfo((page - 1) * ListValue.USERLISTROWS_NUM,
							ListValue.USERLISTROWS_NUM);
					return new Execution<List<User>>(UserStateEnum.SUCCESS, users, eInfo);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new Execution<List<User>>(UserStateEnum.INNER_ERROR);
		}
	}

	@Override
	public Execution<User> deleteUser(int id) {
		// TODO Auto-generated method stub
		try {
			User user = userDao.queryUserById(id);
			if (user!=null){
				userDao.delUserById(id);
				return new Execution<User>(UserStateEnum.SUCCESS,user);
			}else {
				return new Execution<User>(UserStateEnum.USER_NO_EXIST);
			}
		} catch(Exception e){
			logger.error(e.getMessage(), e);
			return new Execution<User>(UserStateEnum.INNER_ERROR);
		}
	}

	@Override
	public Execution<User> addUser(User user) {
		// TODO Auto-generated method stub
		try {
			//进行用户名、邮箱重复验证
			if (userDao.queryUserExistByName(user.getName()) == 1)
				return new Execution<User>(UserStateEnum.NAME_REPEAT);
			if (userDao.queryUserExistByEmail(user.getEmail()) == 1)
				return new Execution<User>(UserStateEnum.EMAIL_REPEAT);
			
			userDao.addUser(user);
			user = userDao.queryUserByName(user.getName());
			if (user!=null){
				return new Execution<User>(UserStateEnum.SUCCESS,user);
			}else {
				return new Execution<User>(UserStateEnum.INNER_ERROR);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new Execution<User>(UserStateEnum.INNER_ERROR);
		}
	}
	@Override
	public Execution<User> register(User user) {
		user.setType(0);
		return addUser(user);
	}
	@Override
	public Execution<User> login(String name, String pwd, String ip) {
		// TODO Auto-generated method stub
		try {
			User user = userDao.queryUserByName(name);
			if (user == null){
				return new Execution<User>(UserStateEnum.USER_NO_EXIST);
			}
			if (user.getPassword().equals(pwd)){
				userDao.updateUserLoginIp(user.getId(), ip);
				return new Execution<User>(UserStateEnum.SUCCESS,user);
			}
			else {
				return new Execution<User>(UserStateEnum.NAME_PWD_ERROR);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
			return new Execution<User>(UserStateEnum.INNER_ERROR);
		}
		
	}

	@Override
	public Execution<User> updateUserAllInfo(User user) {
		// TODO Auto-generated method stub
		try {
			//用户名、邮箱重复验证
			Execution<User> uExecution = userNERepeatInspect(user);
			if (uExecution != null)
				return uExecution;
			else {
				if (userMapper.updateByPrimaryKeySelective(user)>0){
					user = userDao.queryUserByName(user.getName());
					if (user != null) {
						return new Execution<User>(UserStateEnum.SUCCESS, user);
					} else {
						return new Execution<User>(UserStateEnum.INNER_ERROR);
					}
				}else {
					return new Execution<User>(UserStateEnum.INNER_ERROR);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
			return new Execution<User>(UserStateEnum.INNER_ERROR);
		}
	}

	@Override
	public Execution<User> updateUserInfo(User user) {
		// TODO Auto-generated method stub
		try {
			//用户名、邮箱重复验证
			Execution<User> uExecution = userNERepeatInspect(user);
			if (uExecution != null)
				return uExecution;
			else {
				if (userMapper.updateByPrimaryKeySelective(user)>0){
					user = userDao.queryUserById(user.getId());
					if (user != null) {
						return new Execution<User>(UserStateEnum.SUCCESS, user);
					} else {
						return new Execution<User>(UserStateEnum.INNER_ERROR);
					}
				}else {
					return new Execution<User>(UserStateEnum.INNER_ERROR);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
			return new Execution<User>(UserStateEnum.INNER_ERROR);
		}
		
	}
	/***
	 * 用户名邮箱重复验证
	 * @param user
	 * @return
	 */
	private Execution<User> userNERepeatInspect(User user) {
		User oldUser = userDao.queryUserById(user.getId());
		if (oldUser != null
				&& !oldUser.getName().equals(user.getName())) {
			if (userDao.queryUserExistByName(user.getName()) == 1)
				return new Execution<User>(UserStateEnum.NAME_REPEAT);
		}
		if (oldUser != null
				&& !oldUser.getEmail().equals(user.getEmail())) {
			if (userDao.queryUserExistByEmail(user.getEmail()) == 1)
				return new Execution<User>(UserStateEnum.EMAIL_REPEAT);
		}
		return null;
	}
	@Override
	public Execution<List<User>> getUsersByName(String name, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delSoftCount(int uid, String ip) {
		// TODO Auto-generated method stub
		userDao.reduceSoftwareCount(uid, ip);
	}

	@Override
	public void addSoftCount(int uid, String ip) {
		// TODO Auto-generated method stub
		userDao.addSoftwareCount(uid, ip);
	}
	

}
