package service;

import java.io.IOException;

import dao.UserDao;
import domain.User;

/**
 * �û���ɾ��ĵ��м�������
 * 
 * @author ��ʫ��
 * @version 1.0 2020/7/4
 */
public class UserService {

	/**
	 * ��¼ʱ�鿴�����Ƿ�ƥ��ķ���
	 * 
	 * @param user
	 *            ��¼�û�
	 * @return ����
	 * @throws IOException
	 */
	public static String Login(User user) throws IOException {
		return UserDao.getUser(user);
	}

	/**
	 * ��ע���û������ļ��д洢�ķ���
	 * 
	 * @param user
	 *            ע����û�
	 * @return �Ƿ�ע��ɹ�
	 * @throws IOException
	 */
	public static boolean Regist(User user) throws IOException {
		boolean flag = UserDao.addUser(user);
		return flag;
	}

	/**
	 * �޸��û�����ķ���
	 * 
	 * @param user
	 *            Ҫ�޸ĵ��û�
	 * @param pwd
	 *            ���޸ĵ�����
	 * @throws IOException
	 */
	public static void update(User user, String pwd) throws IOException {
		UserDao.updateUser(user, pwd);
	}

	/**
	 * ע���û��ķ���
	 * 
	 * @param user
	 *            Ҫע�����û�
	 * @throws IOException
	 */
	public static void delete(User user) throws IOException {
		UserDao.deleteUser(user);
	}
}
