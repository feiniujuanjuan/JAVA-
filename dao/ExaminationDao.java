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
import util.RandomNumber;

/**
 * 这是对题库操作的集体实现类
 * 
 * @author 张诗羽
 * @version 1.0 2020/7/4
 *
 */
public class ExaminationDao {
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String dbURL = "jdbc:mysql://127.0.0.1:3306/demo?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=UTC";
	private static String userName = "root";
	private static String userPwd = "mysqladmin";
	private static PreparedStatement pst;// 用来执行SQL语句查询，对sql语句进行预编译处理
	private static Connection con = null;
	private static Statement statement = null;// 创建一个对象将SQL语句发送到SQL
	private static ResultSet rs = null;// ResultSet类，用来存放获取的结果集

	/**
	 * 这是题库增加方法
	 * 
	 * @param exam
	 *            题目
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void addQuestion(Examination exam) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO SingleChoiceQuestions(exercises,A,B,C,D,answer) VALUES(?,?,?,?,?,?)";// 数据库操作语句（插入）
		try {
			Class.forName(driverName);// 向DriverManager注册自己
			con = DriverManager.getConnection(dbURL, userName, userPwd);// 与数据库建立连接
			pst = con.prepareStatement(sql);
			pst.setString(1, exam.getQuestion());
			pst.setString(2, exam.getA());
			pst.setString(3, exam.getB());
			pst.setString(4, exam.getC());
			pst.setString(5, exam.getD());
			pst.setString(6, exam.getAnswer());

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
	 * 这是查找题库所有题的方法
	 * 
	 * @return ArrayList<Examination>返回一个集合，把题存入集合中
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Examination> check() throws SQLException, ClassNotFoundException {
		ArrayList<Examination> list = new ArrayList<Examination>();

		Class.forName(driverName);
		con = DriverManager.getConnection(dbURL, userName, userPwd);
		// 创建一个对象将SQL语句发送到SQL
		statement = con.createStatement();
		// sql语句
		String sql = "select id,exercises,A,B,C,D,answer from SingleChoiceQuestions ";
		// ResultSet类，用来存放获取的结果集
		rs = statement.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt(1);
			String question = rs.getString(2);
			String answer1 = rs.getString(3);
			String answer2 = rs.getString(4);
			String answer3 = rs.getString(5);
			String answer4 = rs.getString(6);
			String RightAnswer = rs.getString(7);
			Examination exam = new Examination(id, question, answer1, answer2, answer3, answer4, RightAnswer);
			list.add(exam);
		}

		rs.close();
		con.close();
		return list;
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
		Examination exam = null;

		// 数据库操作语句（查询）
		String sql = "select id,exercises,A,B,C,D,answer from SingleChoiceQuestions where id=" + i;

		Class.forName(driverName);// 向DriverManager注册自己

		con = DriverManager.getConnection(dbURL, userName, userPwd);// 与数据库建立连接

		statement = con.createStatement();

		// ResultSet类，用来存放获取的结果集
		rs = statement.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt(1);
			String question = rs.getString(2);
			String answer1 = rs.getString(3);
			String answer2 = rs.getString(4);
			String answer3 = rs.getString(5);
			String answer4 = rs.getString(6);
			String RightAnswer = rs.getString(7);
			exam = new Examination(id, question, answer1, answer2, answer3, answer4, RightAnswer);
		}

		rs.close();
		statement.close();
		con.close();
		return exam;
	}

	/**
	 * 这是修改题库题目的方法
	 * 
	 * @param exam
	 *            要修改的题目类对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void updateQuestion(Examination exam) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE SingleChoiceQuestions set id=?,exercises=?,A=?,B=?,C=?,D=?,answer=? where id="
				+ exam.getNumber();
		try {
			Class.forName(driverName);// 向DriverManager注册自己
			con = DriverManager.getConnection(dbURL, userName, userPwd);// 与数据库建立连接
			pst = con.prepareStatement(sql);// 用来执行SQL语句查询，对sql语句进行预编译处理

			pst.setInt(1, exam.getNumber());
			pst.setString(2, exam.getQuestion());
			pst.setString(3, exam.getA());
			pst.setString(4, exam.getB());
			pst.setString(5, exam.getC());
			pst.setString(6, exam.getD());
			pst.setString(7, exam.getAnswer());

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
	 * 这是删除题库题目的方法
	 * 
	 * @param exam
	 *            要删除的题目类对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void deleteQuestion(Examination exam) throws ClassNotFoundException, SQLException {
		String sql = "DELETE from SingleChoiceQuestions where id=" + exam.getNumber();
		try {
			Class.forName(driverName);// 向DriverManager注册自己
			con = DriverManager.getConnection(dbURL, userName, userPwd);// 与数据库建立连接
			pst = con.prepareStatement(sql);// 用来执行SQL语句查询，对sql语句进行预编译处理

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
