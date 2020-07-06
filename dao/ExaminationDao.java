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
 * ���Ƕ��������ļ���ʵ����
 * 
 * @author ��ʫ��
 * @version 1.0 2020/7/4
 *
 */
public class ExaminationDao {
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String dbURL = "jdbc:mysql://127.0.0.1:3306/demo?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=UTC";
	private static String userName = "root";
	private static String userPwd = "mysqladmin";
	private static PreparedStatement pst;// ����ִ��SQL����ѯ����sql������Ԥ���봦��
	private static Connection con = null;
	private static Statement statement = null;// ����һ������SQL��䷢�͵�SQL
	private static ResultSet rs = null;// ResultSet�࣬������Ż�ȡ�Ľ����

	/**
	 * ����������ӷ���
	 * 
	 * @param exam
	 *            ��Ŀ
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void addQuestion(Examination exam) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO SingleChoiceQuestions(exercises,A,B,C,D,answer) VALUES(?,?,?,?,?,?)";// ���ݿ������䣨���룩
		try {
			Class.forName(driverName);// ��DriverManagerע���Լ�
			con = DriverManager.getConnection(dbURL, userName, userPwd);// �����ݿ⽨������
			pst = con.prepareStatement(sql);
			pst.setString(1, exam.getQuestion());
			pst.setString(2, exam.getA());
			pst.setString(3, exam.getB());
			pst.setString(4, exam.getC());
			pst.setString(5, exam.getD());
			pst.setString(6, exam.getAnswer());

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
	 * ���ǲ������������ķ���
	 * 
	 * @return ArrayList<Examination>����һ�����ϣ�������뼯����
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Examination> check() throws SQLException, ClassNotFoundException {
		ArrayList<Examination> list = new ArrayList<Examination>();

		Class.forName(driverName);
		con = DriverManager.getConnection(dbURL, userName, userPwd);
		// ����һ������SQL��䷢�͵�SQL
		statement = con.createStatement();
		// sql���
		String sql = "select id,exercises,A,B,C,D,answer from SingleChoiceQuestions ";
		// ResultSet�࣬������Ż�ȡ�Ľ����
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
	 * ���ǲ�ѯĳ������=i����Ŀ�ķ���
	 * 
	 * @param i
	 *            ���ݿ�����
	 * @return ����һ����Ŀ�����
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Examination check1(int i) throws ClassNotFoundException, SQLException {
		Examination exam = null;

		// ���ݿ������䣨��ѯ��
		String sql = "select id,exercises,A,B,C,D,answer from SingleChoiceQuestions where id=" + i;

		Class.forName(driverName);// ��DriverManagerע���Լ�

		con = DriverManager.getConnection(dbURL, userName, userPwd);// �����ݿ⽨������

		statement = con.createStatement();

		// ResultSet�࣬������Ż�ȡ�Ľ����
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
	 * �����޸������Ŀ�ķ���
	 * 
	 * @param exam
	 *            Ҫ�޸ĵ���Ŀ�����
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void updateQuestion(Examination exam) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE SingleChoiceQuestions set id=?,exercises=?,A=?,B=?,C=?,D=?,answer=? where id="
				+ exam.getNumber();
		try {
			Class.forName(driverName);// ��DriverManagerע���Լ�
			con = DriverManager.getConnection(dbURL, userName, userPwd);// �����ݿ⽨������
			pst = con.prepareStatement(sql);// ����ִ��SQL����ѯ����sql������Ԥ���봦��

			pst.setInt(1, exam.getNumber());
			pst.setString(2, exam.getQuestion());
			pst.setString(3, exam.getA());
			pst.setString(4, exam.getB());
			pst.setString(5, exam.getC());
			pst.setString(6, exam.getD());
			pst.setString(7, exam.getAnswer());

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
	 * ����ɾ�������Ŀ�ķ���
	 * 
	 * @param exam
	 *            Ҫɾ������Ŀ�����
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void deleteQuestion(Examination exam) throws ClassNotFoundException, SQLException {
		String sql = "DELETE from SingleChoiceQuestions where id=" + exam.getNumber();
		try {
			Class.forName(driverName);// ��DriverManagerע���Լ�
			con = DriverManager.getConnection(dbURL, userName, userPwd);// �����ݿ⽨������
			pst = con.prepareStatement(sql);// ����ִ��SQL����ѯ����sql������Ԥ���봦��

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
