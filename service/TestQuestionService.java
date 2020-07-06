package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.TestQuestionDao;
import domain.TestQuestion;

/**
 * ���Ƕ��Ծ�������ݿ������������
 * 
 * @author ��ʫ��
 * @version 1.0 2020/7/4
 */
public class TestQuestionService {
	/**
	 * ���ǻ���Ծ�ķ���
	 * 
	 * @return ArrayList<TestQuestion>���Ծ����Ŀ��������ArrayList������
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<TestQuestion> check() throws ClassNotFoundException, SQLException {
		return TestQuestionDao.check();
	}

	/**
	 * ���������Ծ����ӷ���
	 * 
	 * @param tq
	 *            Ҫ��ӵ���Ŀ�����
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void add(TestQuestion tq) throws ClassNotFoundException, SQLException {
		TestQuestionDao.addQuestion(tq);
	}

	/**
	 * ���Ǵ���û�ѡ��Ĵ𰸵ķ���
	 * 
	 * @param id
	 *            ��Ŀ����
	 * @param myAnswer
	 *            �û�ѡ��Ĵ�
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void update(int id, String myAnswer) throws ClassNotFoundException, SQLException {
		TestQuestionDao.updateQuestion(id, myAnswer);
	}

}
