package domain;

/**
 * 错题集题目类
 * 
 * @author 张诗羽
 * @version 1.0 2020/7/4
 */
public class WrongQuestion {
	private int id;// 主键
	private String name;// 用户名
	private String question;// 题目
	private String A;// A选项
	private String B;// B选项
	private String C;// C选项
	private String D;// D选项
	private String rightAnswer;// 正确答案
	private String myAnswer;// 我的答案

	/**
	 * 空构造方法
	 */
	public WrongQuestion() {
	}

	/**
	 * 带参构造方法
	 * 
	 * @param name
	 *            用户名
	 * @param question
	 *            题目
	 * @param a
	 *            A选项
	 * @param b
	 *            B选项
	 * @param c
	 *            C选项
	 * @param d
	 *            D选项
	 * @param rightAnswer
	 *            正确答案
	 * @param myAnswer
	 *            我的答案
	 */
	public WrongQuestion(String name, String question, String a, String b, String c, String d, String rightAnswer,
			String myAnswer) {
		this.name = name;
		this.question = question;
		A = a;
		B = b;
		C = c;
		D = d;
		this.rightAnswer = rightAnswer;
		this.myAnswer = myAnswer;
	}

	/**
	 * 带参构造方法
	 * 
	 * @param id
	 *            主键
	 * @param name
	 *            用户名
	 * @param question
	 *            题目
	 * @param a
	 *            A选项
	 * @param b
	 *            B选项
	 * @param c
	 *            C选项
	 * @param d
	 *            D选项
	 * @param rightAnswer
	 *            正确答案
	 * @param myAnswer
	 *            我的答案
	 */
	public WrongQuestion(int id, String name, String question, String a, String b, String c, String d,
			String rightAnswer, String myAnswer) {
		this.id = id;
		this.name = name;
		this.question = question;
		A = a;
		B = b;
		C = c;
		D = d;
		this.rightAnswer = rightAnswer;
		this.myAnswer = myAnswer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getA() {
		return A;
	}

	public void setA(String a) {
		A = a;
	}

	public String getB() {
		return B;
	}

	public void setB(String b) {
		B = b;
	}

	public String getC() {
		return C;
	}

	public void setC(String c) {
		C = c;
	}

	public String getD() {
		return D;
	}

	public void setD(String d) {
		D = d;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public String getMyAnswer() {
		return myAnswer;
	}

	public void setMyAnswer(String myAnswer) {
		this.myAnswer = myAnswer;
	}

}
