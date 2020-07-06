package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import domain.Examination;
import domain.TestQuestion;
import domain.User;
import domain.WrongQuestion;
import service.TestQuestionService;
import service.WrongQuestionService;
import util.FrameCenterUtil;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * 查询成绩界面
 * 
 * @author 张诗羽
 * @version 1.0 2020/7/4
 */
public class QueryResultsFrame extends JFrame {

	private JPanel contentPane;
	private int currentPage = 1;// 当前页
	private int lastPage = 5;// 总页
	private User user;// 当前用户
	private ArrayList<Examination> list;// 题库里拿出来的题目
	private ArrayList<TestQuestion> tq;// 试卷表里的题目
	private String myAnswer = null;
	JLabel question;
	JRadioButton A, B, C, D;
	JLabel label;
	private List<TestQuestion> list1 = new ArrayList<TestQuestion>();// 个人的试卷
	private TestQuestion testQuestion;// 当前的题目
	private JLabel r1;
	private JLabel r2;
	private JLabel m1;
	private JLabel m2;

	public TestQuestion getTestQuestion() {
		return testQuestion;
	}

	public void setTestQuestion(TestQuestion testQuestion) {
		this.testQuestion = testQuestion;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * Create the frame.
	 */
	public QueryResultsFrame(User user, ArrayList<Examination> list) {
		setTitle("\u67E5\u8BE2\u6210\u7EE9");
		this.user = user;
		this.list = list;

		try {
			tq = TestQuestionService.check();// 从试卷表里拿出试题
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		// 把当前用户的试卷拿出来
		Integer count = 1;
		for (int x = 0; x < tq.size(); x++) {
			TestQuestion text = tq.get(x);
			if (text.getName().equals(user.getUsername())) {
				if (text.getRightAnswer().equals(text.getMyAnswer())) {
					user.achievement += 20;
				} else {
					WrongQuestion wq = new WrongQuestion(text.getName(), text.getQuestion(), text.getA(), text.getB(),
							text.getC(), text.getD(), text.getRightAnswer(), text.getMyAnswer());
					try {
						WrongQuestionService.add(wq);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				list1.add(text);
			}
		}

		// 设置窗体居中
		setSize(1162, 620);
		FrameCenterUtil fcu = new FrameCenterUtil(this);
		// 设置只关闭当前窗口
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false); // 窗口不可最大化
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		TestQuestion t = list1.get(getCurrentPage() - 1);
		setTestQuestion(t);
		question = new JLabel(testQuestion.getQuestion());
		question.setFont(new Font("幼圆", Font.PLAIN, 28));

		JLabel lblNewLabel = new JLabel("\u5F97\u5206\uFF1A");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 28));

		JLabel lblNewLabel_1 = new JLabel(String.valueOf(user.achievement));
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 28));

		r1 = new JLabel("\u6B63\u786E\u7B54\u6848\uFF1A");
		r1.setFont(new Font("幼圆", Font.PLAIN, 28));

		r2 = new JLabel(testQuestion.getRightAnswer());
		r2.setFont(new Font("幼圆", Font.PLAIN, 28));

		m1 = new JLabel("\u6211\u7684\u7B54\u6848\uFF1A");
		m1.setFont(new Font("幼圆", Font.PLAIN, 28));

		m2 = new JLabel(testQuestion.getMyAnswer());
		m2.setFont(new Font("幼圆", Font.PLAIN, 28));

		ButtonGroup button = new ButtonGroup();
		A = new JRadioButton(getTestQuestion().getA());
		A.setFont(new Font("幼圆", Font.PLAIN, 28));
		button.add(A);

		B = new JRadioButton(getTestQuestion().getB());
		B.setFont(new Font("幼圆", Font.PLAIN, 28));
		button.add(B);

		C = new JRadioButton(getTestQuestion().getC());
		C.setFont(new Font("幼圆", Font.PLAIN, 28));
		button.add(C);

		D = new JRadioButton(getTestQuestion().getD());
		D.setFont(new Font("幼圆", Font.PLAIN, 28));
		button.add(D);

		JButton up = new JButton("\u4E0A\u4E00\u9898");
		up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getCurrentPage() == 1) {
					setCurrentPage(2);
				}
				button.clearSelection();
				myAnswer = null;
				setCurrentPage(getCurrentPage() - 1);
				TestQuestion t = list1.get(getCurrentPage() - 1);
				setTestQuestion(t);
				question.setText(getTestQuestion().getQuestion());
				A.setText(getTestQuestion().getA());
				B.setText(getTestQuestion().getB());
				C.setText(getTestQuestion().getC());
				D.setText(getTestQuestion().getD());
				r2.setText(getTestQuestion().getRightAnswer());
				m2.setText(getTestQuestion().getMyAnswer());
				label.setText("题目" + getCurrentPage() + "/" + lastPage);
			}
		});
		up.setFont(new Font("幼圆", Font.PLAIN, 28));

		JButton next = new JButton("\u4E0B\u4E00\u9898 ");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getCurrentPage() == lastPage) {
					setCurrentPage(lastPage - 1);
				}
				button.clearSelection();
				myAnswer = null;
				setCurrentPage(getCurrentPage() + 1);
				TestQuestion t = list1.get(getCurrentPage() - 1);
				setTestQuestion(t);
				question.setText(getTestQuestion().getQuestion());
				A.setText(getTestQuestion().getA());
				B.setText(getTestQuestion().getB());
				C.setText(getTestQuestion().getC());
				D.setText(getTestQuestion().getD());
				r2.setText(getTestQuestion().getRightAnswer());
				m2.setText(getTestQuestion().getMyAnswer());
				label.setText("题目" + getCurrentPage() + "/" + lastPage);
			}
		});
		next.setFont(new Font("幼圆", Font.PLAIN, 28));

		label = new JLabel("题目" + getCurrentPage() + "/" + lastPage);
		label.setFont(new Font("幼圆", Font.PLAIN, 28));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(41)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addComponent(r1).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(r2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(m1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(m2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE).addGap(521))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(up).addGap(212)
										.addComponent(next).addGap(645))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel)
												.addGap(18).addComponent(lblNewLabel_1)
												.addPreferredGap(ComponentPlacement.RELATED, 470, Short.MAX_VALUE)
												.addComponent(label, GroupLayout.PREFERRED_SIZE, 132,
														GroupLayout.PREFERRED_SIZE)
												.addGap(275))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(question, Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE, 1091, Short.MAX_VALUE)
														.addComponent(D, GroupLayout.PREFERRED_SIZE, 851,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(C, GroupLayout.PREFERRED_SIZE, 851,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(B, GroupLayout.PREFERRED_SIZE, 851,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(A, GroupLayout.DEFAULT_SIZE, 1091,
																Short.MAX_VALUE))
												.addContainerGap()))))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(25)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(label)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)))
				.addGap(78).addComponent(question).addGap(26).addComponent(A).addGap(27)
				.addComponent(B, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE).addGap(27)
				.addComponent(C, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE).addGap(27)
				.addComponent(D, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE).addGap(36)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(r1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(m1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(m2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(up)
								.addComponent(next, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
						.addComponent(r2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
