package domain;

/**
 * ����������Ŀ�����
 * 
 * @author ��ʫ��
 * @version 1.0 2020/7/4
 *
 */
public class Examination {
	private int number;// ���
	private String question;// ��Ŀ
	private String A;// Aѡ��
	private String B;// Bѡ��
	private String C;// Cѡ��
	private String D;// Dѡ��
	private String answer;// ��

	/**
	 * ��Ŀչ��췽��
	 */
	public Examination() {
	}

	/**
	 * ��Ĵ��ι��췽��
	 * 
	 * @param id
	 *            ���
	 * @param question
	 *            ��Ŀ
	 * @param A
	 *            Aѡ��
	 * @param B
	 *            Bѡ��
	 * @param C
	 *            Cѡ��
	 * @param D
	 *            Dѡ��
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
	 * ��Ĵ��ι��췽��
	 * 
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
