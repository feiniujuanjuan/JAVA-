package domain;

/**
 * �û���
 * 
 * @author ��ʫ��
 * @version 1.0 2020/7/4
 */
public class User {

	private String username;// �û���
	private String passWord;// ����
	public static int achievement;

	/**
	 * �չ��췽��
	 */
	public User() {
	}

	/**
	 * ���ι��췽��
	 * 
	 * @param username
	 *            �û���
	 * @param passWord
	 *            ����
	 */
	public User(String username, String passWord) {
		this.username = username;
		this.passWord = passWord;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
