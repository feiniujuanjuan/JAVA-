package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.ExaminationDao;
import domain.Examination;

/**
 * 这是对题库数据库操作的中间桥梁类
 * 
 * @author 张诗羽
 * @version 1.0 2020/7/4
 */
public class ExaminationService {

	/**
	 * 这是查找题库所有题的方法
	 * 
	 * @return ArrayList<Examination>返回一个集合，把题存入集合中
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Examination> check() throws ClassNotFoundException, SQLException {
		return ExaminationDao.check();
	}

	/**
	 * 这是查询某个主键=i的题目的方法
	 * 
	 * @param i
	 *            数据库主键
	 * @return 返回一个题目类对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Examination check1(int i) throws ClassNotFoundException, SQLException {
		return ExaminationDao.check1(i);
	}

	/**
	 * 这是题库增加方法
	 * 
	 * @param exam
	 *            题目
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void add(Examination exam) throws ClassNotFoundException, SQLException {
		ExaminationDao.addQuestion(exam);
	}

	/**
	 * 这是修改题库题目的方法
	 * 
	 * @param exam
	 *            要修改的题目类对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void update(Examination exam) throws ClassNotFoundException, SQLException {
		ExaminationDao.updateQuestion(exam);
	}

	/**
	 * 这是删除题库题目的方法
	 * 
	 * @param exam
	 *            要删除的题目类对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void delete(Examination exam) throws ClassNotFoundException, SQLException {
		ExaminationDao.deleteQuestion(exam);
	}
}
