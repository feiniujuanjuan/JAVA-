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

import dao.WrongQuestionDao;
import domain.Examination;
import domain.User;
import domain.WrongQuestion;
import util.FrameCenterUtil;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * 错题界面
 * 
 * @author 张诗羽
 * @version 1.0 2020/7/4
 */
public class WrongQuestionsFrame extends JFrame {

	private JPanel contentPane;
	private int currentPage = 1;// 当前页
	private int lastPage;// 总页
	private User user;// 当前用户
	private ArrayList<Examination> list;// 题库里拿出来的题目
	private ArrayList<WrongQuestion> wq;// 试卷表里的题目
	private String myAnswer = null;
	JLabel question;
	JRadioButton A, B, C, D;
	JLabel label;
	private List<WrongQuestion> list1 = new ArrayList<WrongQuestion>();// 个人的试卷
	private WrongQuestion wrong;// 当前的题目
	private JLabel r1;
	private JLabel r2;
	private JLabel m1;
	private JLabel m2;

	public WrongQuestion getWrong() {
		return wrong;
	}

	public void setWrong(WrongQuestion wrong) {
		this.wrong = wrong;
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
	public WrongQuestionsFrame(User user) {
		setTitle("\u9519\u9898\u96C6");
		this.user = user;

		try {
			wq = WrongQuestionDao.check();// 从错题表里拿出试题
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		lastPage = wq.size();

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

		WrongQuestion w = wq.get(getCurrentPage() - 1);
		setWrong(w);
		question = new JLabel(w.getQuestion());
		question.setFont(new Font("幼圆", Font.PLAIN, 28));

		r1 = new JLabel("\u6B63\u786E\u7B54\u6848\uFF1A");
		r1.setFont(new Font("幼圆", Font.PLAIN, 28));

		r2 = new JLabel(w.getRightAnswer());
		r2.setFont(new Font("幼圆", Font.PLAIN, 28));

		m1 = new JLabel("\u6211\u7684\u7B54\u6848\uFF1A");
		m1.setFont(new Font("幼圆", Font.PLAIN, 28));

		m2 = new JLabel(w.getMyAnswer());
		m2.setFont(new Font("幼圆", Font.PLAIN, 28));

		ButtonGroup button = new ButtonGroup();
		A = new JRadioButton(getWrong().getA());
		A.setFont(new Font("幼圆", Font.PLAIN, 28));
		button.add(A);

		B = new JRadioButton(getWrong().getB());
		B.setFont(new Font("幼圆", Font.PLAIN, 28));
		button.add(B);

		C = new JRadioButton(getWrong().getC());
		C.setFont(new Font("幼圆", Font.PLAIN, 28));
		button.add(C);

		D = new JRadioButton(getWrong().getD());
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
				WrongQuestion w = wq.get(getCurrentPage() - 1);
				setWrong(w);
				question.setText(getWrong().getQuestion());
				A.setText(getWrong().getA());
				B.setText(getWrong().getB());
				C.setText(getWrong().getC());
				D.setText(getWrong().getD());
				r2.setText(getWrong().getRightAnswer());
				m2.setText(getWrong().getMyAnswer());
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
				WrongQuestion w = wq.get(getCurrentPage() - 1);
				setWrong(w);
				question.setText(getWrong().getQuestion());
				A.setText(getWrong().getA());
				B.setText(getWrong().getB());
				C.setText(getWrong().getC());
				D.setText(getWrong().getD());
				r2.setText(getWrong().getRightAnswer());
				m2.setText(getWrong().getMyAnswer());
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
										.addGroup(Alignment.TRAILING,
												gl_contentPane.createSequentialGroup()
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
				.createSequentialGroup().addGap(25).addComponent(label).addGap(78).addComponent(question).addGap(26)
				.addComponent(A).addGap(27).addComponent(B, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
				.addGap(27).addComponent(C, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE).addGap(27)
				.addComponent(D, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE).addGap(36)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(r1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(m1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(m2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(up)
								.addComponent(next, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
						.addComponent(r2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
