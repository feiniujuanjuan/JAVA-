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
 * ���Ƕ��Ծ�����ļ���ʵ����
 * 
 * @author ��ʫ��
 * @version 1.0 2020/7/4
 *
 */
public class TestQuestionDao {
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String dbURL = "jdbc:mysql://127.0.0.1:3306/demo?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=UTC";
	private static String userName = "root";
	private static String userPwd = "mysqladmin";
	private static PreparedStatement pst;// ����ִ��SQL����ѯ����sql������Ԥ���봦��
	private static Connection con = null;
	private static Statement statement = null;// ����һ������SQL��䷢�͵�SQL
	private static ResultSet rs = null;// ResultSet�࣬������Ż�ȡ�Ľ����

	/**
	 * ���������Ծ����ӷ���
	 * 
	 * @param tq
	 *            Ҫ��ӵ���Ŀ�����
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void addQuestion(TestQuestion tq) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO testquestions(user,exercises,A,B,C,D,rightAnswer,myAnswer) VALUES(?,?,?,?,?,?,?,?)";// ���ݿ������䣨���룩
		try {
			Class.forName(driverName);// ��DriverManagerע���Լ�
			con = DriverManager.getConnection(dbURL, userName, userPwd);// �����ݿ⽨������
			pst = con.prepareStatement(sql);
			pst.setString(1, tq.getName());
			pst.setString(2, tq.getQuestion());
			pst.setString(3, tq.getA());
			pst.setString(4, tq.getB());
			pst.setString(5, tq.getC());
			pst.setString(6, tq.getD());
			pst.setString(7, tq.getRightAnswer());
			pst.setString(8, tq.getMyAnswer());

			pst.executeUpdate();// ��������
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {// ִ�������ݿ⽨��������Ҫ�׳�SQL�쳣
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con.close();
	}

	/**
	 * ���ǻ���Ծ�ķ���
	 * 
	 * @return ArrayList<TestQuestion>���Ծ����Ŀ��������ArrayList������
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<TestQuestion> check() throws SQLException, ClassNotFoundException {
		ArrayList<TestQuestion> list = new ArrayList<TestQuestion>();

		Class.forName(driverName);
		con = DriverManager.getConnection(dbURL, userName, userPwd);
		// ����һ������SQL��䷢�͵�SQL
		statement = con.createStatement();
		// sql���
		String sql = "select id,user,exercises,A,B,C,D,rightAnswer,myAnswer from testquestions ";
		// ResultSet�࣬������Ż�ȡ�Ľ����
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
	 * ���Ǵ���û�ѡ��Ĵ𰸵ķ���
	 * 
	 * @param id
	 *            ��Ŀ����
	 * @param myAnswer
	 *            �û�ѡ��Ĵ�
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void updateQuestion(int id, String myAnswer) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE testquestions set myAnswer=? where id=" + id;
		try {
			Class.forName(driverName);// ��DriverManagerע���Լ�
			con = DriverManager.getConnection(dbURL, userName, userPwd);// �����ݿ⽨������
			pst = con.prepareStatement(sql);// ����ִ��SQL����ѯ����sql������Ԥ���봦��

			pst.setString(1, myAnswer);

			pst.executeUpdate();// ��������
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {// ִ�������ݿ⽨��������Ҫ�׳�SQL�쳣
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con.close();
	}

}
