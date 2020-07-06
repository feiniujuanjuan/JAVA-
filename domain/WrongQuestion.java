package domain;

/**
 * ���⼯��Ŀ��
 * 
 * @author ��ʫ��
 * @version 1.0 2020/7/4
 */
public class WrongQuestion {
	private int id;// ����
	private String name;// �û���
	private String question;// ��Ŀ
	private String A;// Aѡ��
	private String B;// Bѡ��
	private String C;// Cѡ��
	private String D;// Dѡ��
	private String rightAnswer;// ��ȷ��
	private String myAnswer;// �ҵĴ�

	/**
	 * �չ��췽��
	 */
	public WrongQuestion() {
	}

	/**
	 * ���ι��췽��
	 * 
	 * @param name
	 *            �û���
	 * @param question
	 *            ��Ŀ
	 * @param a
	 *            Aѡ��
	 * @param b
	 *            Bѡ��
	 * @param c
	 *            Cѡ��
	 * @param d
	 *            Dѡ��
	 * @param rightAnswer
	 *            ��ȷ��
	 * @param myAnswer
	 *            �ҵĴ�
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
	 * ���ι��췽��
	 * 
	 * @param id
	 *            ����
	 * @param name
	 *            �û���
	 * @param question
	 *            ��Ŀ
	 * @param a
	 *            Aѡ��
	 * @param b
	 *            Bѡ��
	 * @param c
	 *            Cѡ��
	 * @param d
	 *            Dѡ��
	 * @param rightAnswer
	 *            ��ȷ��
	 * @param myAnswer
	 *            �ҵĴ�
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
