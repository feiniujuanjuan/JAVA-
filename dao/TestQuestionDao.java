package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import domain.Examination;
import domain.TestQuestion;
import util.RandomNumber;

/**
 * 这是对试卷操作的集体实现类
 * 
 * @author 张诗羽
 * @version 1.0 2020/7/4
 *
 */
public class TestQuestionDao {
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String dbURL = "jdbc:mysql://127.0.0.1:3306/demo?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=UTC";
	private static String userName = "root";
	private static String userPwd = "mysqladmin";
	private static PreparedStatement pst;// 用来执行SQL语句查询，对sql语句进行预编译处理
	private static Connection con = null;
	private static Statement statement = null;// 创建一个对象将SQL语句发送到SQL
	private static ResultSet rs = null;// ResultSet类，用来存放获取的结果集

	/**
	 * 这是生成试卷的添加方法
	 * 
	 * @param tq
	 *            要添加的题目类对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void addQuestion(TestQuestion tq) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO testquestions(user,exercises,A,B,C,D,rightAnswer,myAnswer) VALUES(?,?,?,?,?,?,?,?)";// 数据库操作语句（插入）
		try {
			Class.forName(driverName);// 向DriverManager注册自己
			con = DriverManager.getConnection(dbURL, userName, userPwd);// 与数据库建立连接
			pst = con.prepareStatement(sql);
			pst.setString(1, tq.getName());
			pst.setString(2, tq.getQuestion());
			pst.setString(3, tq.getA());
			pst.setString(4, tq.getB());
			pst.setString(5, tq.getC());
			pst.setString(6, tq.getD());
			pst.setString(7, tq.getRightAnswer());
			pst.setString(8, tq.getMyAnswer());

			pst.executeUpdate();// 解释在下
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {// 执行与数据库建立连接需要抛出SQL异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con.close();
	}

	/**
	 * 这是获得试卷的方法
	 * 
	 * @return ArrayList<TestQuestion>，试卷的题目类对象存在ArrayList集合中
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<TestQuestion> check() throws SQLException, ClassNotFoundException {
		ArrayList<TestQuestion> list = new ArrayList<TestQuestion>();

		Class.forName(driverName);
		con = DriverManager.getConnection(dbURL, userName, userPwd);
		// 创建一个对象将SQL语句发送到SQL
		statement = con.createStatement();
		// sql语句
		String sql = "select id,user,exercises,A,B,C,D,rightAnswer,myAnswer from testquestions ";
		// ResultSet类，用来存放获取的结果集
		rs = statement.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String question = rs.getString(3);
			String answer1 = rs.getString(4);
			String answer2 = rs.getString(5);
			String answer3 = rs.getString(6);
			String answer4 = rs.getString(7);
			String RightAnswer = rs.getString(8);
			String myAnswer = rs.getString(9);
			TestQuestion tq = new TestQuestion(id, name, question, answer1, answer2, answer3, answer4, RightAnswer,
					myAnswer);
			list.add(tq);
		}

		rs.close();
		con.close();
		return list;
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
	public static void updateQuestion(int id, String myAnswer) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE testquestions set myAnswer=? where id=" + id;
		try {
			Class.forName(driverName);// 向DriverManager注册自己
			con = DriverManager.getConnection(dbURL, userName, userPwd);// 与数据库建立连接
			pst = con.prepareStatement(sql);// 用来执行SQL语句查询，对sql语句进行预编译处理

			pst.setString(1, myAnswer);

			pst.executeUpdate();// 解释在下
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {// 执行与数据库建立连接需要抛出SQL异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con.close();
	}

}
