package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.WrongQuestionDao;
import domain.WrongQuestion;

/**
 * 这是对错题集数据库操作的桥梁类
 * 
 * @author 张诗羽
 * @version 1.0 2020/7/4
 */
public class WrongQuestionService {
	/**
	 * 查找错题的方法
	 * 
	 * @return 错题类对象
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<WrongQuestion> check() throws ClassNotFoundException, SQLException {
		return WrongQuestionDao.check();
	}

	/**
	 * 把错题写入数据库的方法
	 * 
	 * @param wq
	 *            错题类对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void add(WrongQuestion wq) throws ClassNotFoundException, SQLException {
		WrongQuestionDao.addQuestion(wq);
	}

}
