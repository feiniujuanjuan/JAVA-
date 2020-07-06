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
import domain.WrongQuestion;
import util.RandomNumber;

/**
 * 数据库存放错题集的实现类
 * 
 * @author 张诗羽
 * @version 1.0 2020/7/4
 *
 */
public class WrongQuestionDao {
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String dbURL = "jdbc:mysql://127.0.0.1:3306/demo?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=UTC";
	private static String userName = "root";
	private static String userPwd = "mysqladmin";
	private static PreparedStatement pst;// 用来执行SQL语句查询，对sql语句进行预编译处理
	private static Connection con = null;
	private static Statement statement = null;// 创建一个对象将SQL语句发送到SQL
	private static ResultSet rs = null;// ResultSet类，用来存放获取的结果集

	/**
	 * 把错题写入数据库的方法
	 * 
	 * @param wq
	 *            错题类对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void addQuestion(WrongQuestion wq) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO wrongquestions(user,exercises,A,B,C,D,rightAnswer,myAnswer) VALUES(?,?,?,?,?,?,?,?)";// 数据库操作语句（插入）
		try {
			Class.forName(driverName);// 向DriverManager注册自己
			con = DriverManager.getConnection(dbURL, userName, userPwd);// 与数据库建立连接
			pst = con.prepareStatement(sql);
			pst.setString(1, wq.getName());
			pst.setString(2, wq.getQuestion());
			pst.setString(3, wq.getA());
			pst.setString(4, wq.getB());
			pst.setString(5, wq.getC());
			pst.setString(6, wq.getD());
			pst.setString(7, wq.getRightAnswer());
			pst.setString(8, wq.getMyAnswer());

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
	 * 查找错题的方法
	 * 
	 * @return 错题类对象
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<WrongQuestion> check() throws SQLException, ClassNotFoundException {
		ArrayList<WrongQuestion> list = new ArrayList<WrongQuestion>();

		Class.forName(driverName);
		con = DriverManager.getConnection(dbURL, userName, userPwd);
		// 创建一个对象将SQL语句发送到SQL
		statement = con.createStatement();
		// sql语句
		String sql = "select id,user,exercises,A,B,C,D,rightAnswer,myAnswer from wrongquestions ";
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
			WrongQuestion wq = new WrongQuestion(id, name, question, answer1, answer2, answer3, answer4, RightAnswer,
					myAnswer);
			list.add(wq);
		}

		rs.close();
		con.close();
		return list;
	}

}
