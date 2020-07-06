package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.ExaminationDao;
import domain.Examination;

/**
 * ���Ƕ�������ݿ�������м�������
 * 
 * @author ��ʫ��
 * @version 1.0 2020/7/4
 */
public class ExaminationService {

	/**
	 * ���ǲ������������ķ���
	 * 
	 * @return ArrayList<Examination>����һ�����ϣ�������뼯����
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Examination> check() throws ClassNotFoundException, SQLException {
		return ExaminationDao.check();
	}

	/**
	 * ���ǲ�ѯĳ������=i����Ŀ�ķ���
	 * 
	 * @param i
	 *            ���ݿ�����
	 * @return ����һ����Ŀ�����
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Examination check1(int i) throws ClassNotFoundException, SQLException {
		return ExaminationDao.check1(i);
	}

	/**
	 * ����������ӷ���
	 * 
	 * @param exam
	 *            ��Ŀ
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void add(Examination exam) throws ClassNotFoundException, SQLException {
		ExaminationDao.addQuestion(exam);
	}

	/**
	 * �����޸������Ŀ�ķ���
	 * 
	 * @param exam
	 *            Ҫ�޸ĵ���Ŀ�����
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void update(Examination exam) throws ClassNotFoundException, SQLException {
		ExaminationDao.updateQuestion(exam);
	}

	/**
	 * ����ɾ�������Ŀ�ķ���
	 * 
	 * @param exam
	 *            Ҫɾ������Ŀ�����
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void delete(Examination exam) throws ClassNotFoundException, SQLException {
		ExaminationDao.deleteQuestion(exam);
	}
}
