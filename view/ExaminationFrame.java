package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Examination;
import domain.TestQuestion;
import domain.User;
import service.TestQuestionService;
import util.FrameCenterUtil;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * ���Խ���
 * 
 * @author ��ʫ��
 * @version 1.0 2020/7/4
 */
public class ExaminationFrame extends JFrame {

	private JPanel contentPane;
	private int currentPage = 1;// ��ǰҳ
	private int lastPage = 5;// ��ҳ
	private User user;// ��ǰ�û�
	private ArrayList<Examination> list;// ������ó�������Ŀ
	private ArrayList<TestQuestion> tq;// �Ծ�������Ŀ
	private String myAnswer = null;
	JLabel question;
	JRadioButton A, B, C, D;
	JLabel label;
	private List<TestQuestion> list1 = new ArrayList<TestQuestion>();// ���˵��Ծ�
	private TestQuestion testQuestion;// ��ǰ����Ŀ

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
	public ExaminationFrame(User user, ArrayList<Examination> list) {
		setTitle("\u8003\u8BD5");
		this.user = user;
		this.list = list;

		// ���ô������
		setSize(1162, 620);
		FrameCenterUtil fcu = new FrameCenterUtil(this);
		// ����ֻ�رյ�ǰ����
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false); // ���ڲ������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// ��������ɵ���Ŀ�������ݿ�
		for (int x = 0; x < list.size(); x++) {
			Examination e = list.get(x);
			TestQuestion tq = new TestQuestion(user.getUsername(), e.getQuestion(), e.getA(), e.getB(), e.getC(),
					e.getD(), e.getAnswer(), myAnswer);
			try {
				TestQuestionService.add(tq);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		try {
			tq = TestQuestionService.check();// ���Ծ�����ó�����
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		// �ѵ�ǰ�û����Ծ��ó���
		Integer count = 1;
		for (int x = 0; x < tq.size(); x++) {
			TestQuestion text = tq.get(x);
			if (text.getName().equals(user.getUsername())) {
				list1.add(text);
			}
		}

		TestQuestion t = list1.get(getCurrentPage() - 1);
		setTestQuestion(t);
		question = new JLabel(testQuestion.getQuestion());
		question.setFont(new Font("��Բ", Font.PLAIN, 28));

		ButtonGroup button = new ButtonGroup();
		A = new JRadioButton(getTestQuestion().getA());
		A.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myAnswer = "A";
				try {
					TestQuestionService.update(getTestQuestion().getId(), myAnswer);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		A.setFont(new Font("��Բ", Font.PLAIN, 28));
		button.add(A);

		B = new JRadioButton(getTestQuestion().getB());
		B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myAnswer = "B";
				try {
					TestQuestionService.update(getTestQuestion().getId(), myAnswer);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		B.setFont(new Font("��Բ", Font.PLAIN, 28));
		button.add(B);

		C = new JRadioButton(getTestQuestion().getC());
		C.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myAnswer = "C";
				try {
					TestQuestionService.update(getTestQuestion().getId(), myAnswer);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		C.setFont(new Font("��Բ", Font.PLAIN, 28));
		button.add(C);

		D = new JRadioButton(getTestQuestion().getD());
		D.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myAnswer = "D";
				try {
					TestQuestionService.update(getTestQuestion().getId(), myAnswer);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		D.setFont(new Font("��Բ", Font.PLAIN, 28));
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
				label.setText("��Ŀ" + getCurrentPage() + "/" + lastPage);
			}
		});
		up.setFont(new Font("��Բ", Font.PLAIN, 28));

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
				label.setText("��Ŀ" + getCurrentPage() + "/" + lastPage);
			}
		});
		next.setFont(new Font("��Բ", Font.PLAIN, 28));

		JButton submit = new JButton("\u4EA4\u5377");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryResultsFrame qrf = new QueryResultsFrame(user, list);
				qrf.setVisible(true);
			}
		});
		submit.setFont(new Font("��Բ", Font.PLAIN, 28));

		label = new JLabel("��Ŀ" + getCurrentPage() + "/" + lastPage);
		label.setFont(new Font("��Բ", Font.PLAIN, 28));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(515, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE).addGap(114)
						.addComponent(submit, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE).addGap(61))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(41).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addComponent(question, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
						.addGroup(
								gl_contentPane.createSequentialGroup().addComponent(up).addGap(215).addComponent(next))
						.addComponent(D, GroupLayout.PREFERRED_SIZE, 851, GroupLayout.PREFERRED_SIZE)
						.addComponent(C, GroupLayout.PREFERRED_SIZE, 851, GroupLayout.PREFERRED_SIZE)
						.addComponent(B, GroupLayout.PREFERRED_SIZE, 851, GroupLayout.PREFERRED_SIZE)
						.addComponent(A, GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)).addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(25)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(submit, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
				.addGap(78).addComponent(question).addGap(26).addComponent(A).addGap(27)
				.addComponent(B, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE).addGap(27)
				.addComponent(C, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE).addGap(27)
				.addComponent(D, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE).addGap(63)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(up).addComponent(next,
						GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(60, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

}
