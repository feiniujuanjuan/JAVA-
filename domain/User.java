package domain;

/**
 * 用户类
 * 
 * @author 张诗羽
 * @version 1.0 2020/7/4
 */
public class User {

	private String username;// 用户名
	private String passWord;// 密码
	public static int achievement;

	/**
	 * 空构造方法
	 */
	public User() {
	}

	/**
	 * 带参构造方法
	 * 
	 * @param username
	 *            用户名
	 * @param passWord
	 *            密码
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
