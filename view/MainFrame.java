package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Examination;
import domain.User;
import service.ExaminationService;
import service.UserService;
import util.FrameCenterUtil;
import util.RandomNumber;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * �û�ʹ����ҳ
 * 
 * @author ��ʫ��
 * @version 1.0 2020/7/4
 */
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private User user;
	private ArrayList<Examination> list = null;

	/**
	 * Create the frame.
	 */
	public MainFrame(User user) {
		this.user = user;
		// �������ظ��������
		ArrayList<Integer> array = RandomNumber.random();
		list = new ArrayList<Examination>();
		// ��������Ծ�
		for (Integer i : array) {
			try {
				Examination exam = ExaminationService.check1(i);
				list.add(exam);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		// ���ô������
		setSize(1128, 756);
		FrameCenterUtil fcu = new FrameCenterUtil(this);
		setTitle("\u5728\u7EBF\u8003\u8BD5\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"D:\\\u5E94\u7528\\java\\Java\u7A0B\u5E8F\\\u5728\u7EBF\u8003\u8BD5\u7CFB\u7EDF\\\u56FE\u7247\\\u56FE\u6807.jpeg"));
		// ����ֻ�رյ�ǰ����
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton testbutton = new JButton("\u8FDB\u5165\u8003\u8BD5");
		testbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ExaminationFrame ef = new ExaminationFrame(user, list);
				ef.setVisible(true);
			}
		});
		testbutton.setBackground(SystemColor.inactiveCaptionBorder);
		testbutton.setFont(new Font("΢���ź�", Font.PLAIN, 28));

		JButton textGradebutton = new JButton("\u8003\u8BD5\u6210\u7EE9\u67E5\u8BE2");
		textGradebutton.setBackground(SystemColor.inactiveCaptionBorder);
		textGradebutton.setFont(new Font("΢���ź�", Font.PLAIN, 28));

		JButton wrongQuestionsbutton = new JButton("\u9519\u9898\u96C6");
		wrongQuestionsbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WrongQuestionsFrame wf = new WrongQuestionsFrame(user);
				wf.setVisible(true);
			}
		});
		wrongQuestionsbutton.setBackground(SystemColor.inactiveCaptionBorder);
		wrongQuestionsbutton.setFont(new Font("΢���ź�", Font.PLAIN, 28));

		JButton updatePasswordbutton = new JButton("\u4FEE\u6539\u5BC6\u7801");
		updatePasswordbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePasswordFrame cpf = new ChangePasswordFrame(user, list);
				cpf.setVisible(true);
				dispose();
			}
		});
		updatePasswordbutton.setBackground(SystemColor.inactiveCaptionBorder);
		updatePasswordbutton.setFont(new Font("΢���ź�", Font.PLAIN, 28));

		JButton signOutbutton = new JButton("\u9000\u51FA");
		signOutbutton.setBackground(SystemColor.inactiveCaptionBorder);
		signOutbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		signOutbutton.setFont(new Font("΢���ź�", Font.PLAIN, 28));

		JButton Firstbutton = new JButton("\u9996\u9875");
		Firstbutton.setBackground(SystemColor.inactiveCaption);
		Firstbutton.setFont(new Font("΢���ź�", Font.PLAIN, 28));

		JLabel lblNewLabel = new JLabel(
				"\u5B66\u4E60\u6700\u597D\u7684\u65F6\u95F4\u662F\u4E00\u5E74\u524D\uFF0C\u5176\u6B21\u662F\u73B0\u5728\u3002");
		lblNewLabel.setBackground(SystemColor.info);
		lblNewLabel.setFont(new Font("��Բ", Font.PLAIN, 32));

		JButton deleteUserbutton = new JButton("\u6CE8\u9500\u7528\u6237");
		deleteUserbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					UserService.delete(user);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// ����ע���ɹ�����
				dispose();
				LoginFrame lf = new LoginFrame();
				lf.setVisible(true);
				CancellationSuccess cs = new CancellationSuccess();
				cs.setVisible(true);
			}
		});
		deleteUserbutton.setFont(new Font("΢���ź�", Font.PLAIN, 28));
		deleteUserbutton.setBackground(SystemColor.inactiveCaptionBorder);

		JLabel lblNewLabel_1 = new JLabel("��ӭ" + user.getUsername() + "�û�����ϵͳ��");
		lblNewLabel_1.setFont(new Font("��Բ", Font.PLAIN, 52));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(39)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING,
								gl_contentPane.createSequentialGroup().addGap(45).addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
										.addComponent(signOutbutton))
						.addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(updatePasswordbutton, GroupLayout.PREFERRED_SIZE,
																201, GroupLayout.PREFERRED_SIZE)
														.addComponent(deleteUserbutton, GroupLayout.PREFERRED_SIZE, 201,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(wrongQuestionsbutton, GroupLayout.PREFERRED_SIZE,
																201, GroupLayout.PREFERRED_SIZE)
														.addComponent(textGradebutton, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(testbutton, Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
												.addGap(151))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(Firstbutton, GroupLayout.PREFERRED_SIZE, 201,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)))
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 643,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(66)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(34)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_1).addComponent(signOutbutton))
				.addGap(40)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addComponent(Firstbutton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addGap(34).addComponent(testbutton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addGap(36)
						.addComponent(textGradebutton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addGap(36)
						.addComponent(wrongQuestionsbutton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addGap(38)
						.addComponent(updatePasswordbutton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addGap(33)
						.addComponent(deleteUserbutton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
				.addGap(42)));
		contentPane.setLayout(gl_contentPane);
	}
}
