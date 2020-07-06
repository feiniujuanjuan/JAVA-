package domain;

/**
 * 这是题库的题目类对象
 * 
 * @author 张诗羽
 * @version 1.0 2020/7/4
 *
 */
public class Examination {
	private int number;// 题号
	private String question;// 题目
	private String A;// A选项
	private String B;// B选项
	private String C;// C选项
	private String D;// D选项
	private String answer;// 答案

	/**
	 * 类的空构造方法
	 */
	public Examination() {
	}

	/**
	 * 类的带参构造方法
	 * 
	 * @param id
	 *            题号
	 * @param question
	 *            题目
	 * @param A
	 *            A选项
	 * @param B
	 *            B选项
	 * @param C
	 *            C选项
	 * @param D
	 *            D选项
	 * @param answer
	 */
	public Examination(int id, String question, String A, String B, String C, String D, String answer) {
		this.number = id;
		this.question = question;
		this.A = A;
		this.B = B;
		this.C = C;
		this.D = D;
		this.answer = answer;
	}

	/**
	 * 类的带参构造方法
	 * 
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
	 * @param answer
	 */
	public Examination(String question, String a, String b, String c, String d, String answer) {
		super();
		this.question = question;
		A = a;
		B = b;
		C = c;
		D = d;
		this.answer = answer;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
