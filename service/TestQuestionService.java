package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.TestQuestionDao;
import domain.TestQuestion;

/**
 * 这是对试卷进行数据库操作的桥梁类
 * 
 * @author 张诗羽
 * @version 1.0 2020/7/4
 */
public class TestQuestionService {
	/**
	 * 这是获得试卷的方法
	 * 
	 * @return ArrayList<TestQuestion>，试卷的题目类对象存在ArrayList集合中
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<TestQuestion> check() throws ClassNotFoundException, SQLException {
		return TestQuestionDao.check();
	}

	/**
	 * 这是生成试卷的添加方法
	 * 
	 * @param tq
	 *            要添加的题目类对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void add(TestQuestion tq) throws ClassNotFoundException, SQLException {
		TestQuestionDao.addQuestion(tq);
	}

	/**
	 * 这是存放用户选择的答案的方法
	 * 
	 * @param id
	 *            题目主键
	 * @param myAnswer
	 *            用户选择的答案
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void update(int id, String myAnswer) throws ClassNotFoundException, SQLException {
		TestQuestionDao.updateQuestion(id, myAnswer);
	}

}
