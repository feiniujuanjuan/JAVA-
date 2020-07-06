package service;

import java.io.IOException;

import dao.UserDao;
import domain.User;

/**
 * 用户增删查改的中间桥梁类
 * 
 * @author 张诗羽
 * @version 1.0 2020/7/4
 */
public class UserService {

	/**
	 * 登录时查看密码是否匹配的方法
	 * 
	 * @param user
	 *            登录用户
	 * @return 密码
	 * @throws IOException
	 */
	public static String Login(User user) throws IOException {
		return UserDao.getUser(user);
	}

	/**
	 * 把注册用户放入文件中存储的方法
	 * 
	 * @param user
	 *            注册的用户
	 * @return 是否注册成功
	 * @throws IOException
	 */
	public static boolean Regist(User user) throws IOException {
		boolean flag = UserDao.addUser(user);
		return flag;
	}

	/**
	 * 修改用户密码的方法
	 * 
	 * @param user
	 *            要修改的用户
	 * @param pwd
	 *            想修改的密码
	 * @throws IOException
	 */
	public static void update(User user, String pwd) throws IOException {
		UserDao.updateUser(user, pwd);
	}

	/**
	 * 注销用户的方法
	 * 
	 * @param user
	 *            要注销的用户
	 * @throws IOException
	 */
	public static void delete(User user) throws IOException {
		UserDao.deleteUser(user);
	}
}
