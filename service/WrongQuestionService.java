package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.WrongQuestionDao;
import domain.WrongQuestion;

/**
 * ���ǶԴ��⼯���ݿ������������
 * 
 * @author ��ʫ��
 * @version 1.0 2020/7/4
 */
public class WrongQuestionService {
	/**
	 * ���Ҵ���ķ���
	 * 
	 * @return ���������
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<WrongQuestion> check() throws ClassNotFoundException, SQLException {
		return WrongQuestionDao.check();
	}

	/**
	 * �Ѵ���д�����ݿ�ķ���
	 * 
	 * @param wq
	 *            ���������
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void add(WrongQuestion wq) throws ClassNotFoundException, SQLException {
		WrongQuestionDao.addQuestion(wq);
	}

}
