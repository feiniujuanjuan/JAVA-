package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Examination;
import domain.User;
import service.UserService;
import util.FrameCenterUtil;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Color;

/**
 * ÐÞ¸ÄÃÜÂë½çÃæ
 * 
 * @author ÕÅÊ«Óð
 * @version 1.0 2020/7/4
 */
public class ChangePasswordFrame extends JFrame {

	private JPanel contentPane;
	private JTextField passwordtextField;
	private JTextField newPasswordtextField1;
	private JTextField newPasswordtextField2;
	private User user;
	private ArrayList<Examination> list;

	/**
	 * Create the frame.
	 */
	public ChangePasswordFrame(User user, ArrayList<Examination> list) {
		this.user = user;
		this.list = list;
		// ÉèÖÃ´°Ìå¾ÓÖÐ
		setSize(1128, 756);
		FrameCenterUtil fcu = new FrameCenterUtil(this);
		setTitle("\u5728\u7EBF\u8003\u8BD5\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"D:\\\u5E94\u7528\\java\\Java\u7A0B\u5E8F\\\u5728\u7EBF\u8003\u8BD5\u7CFB\u7EDF\\\u56FE\u7247\\\u56FE\u6807.jpeg"));
		// ÉèÖÃÖ»¹Ø±Õµ±Ç°´°¿Ú
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton testbutton = new JButton("\u8FDB\u5165\u8003\u8BD5");
		testbutton.setBackground(SystemColor.inactiveCaptionBorder);
		testbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ExaminationFrame ef = ef = new ExaminationFrame(user, list);
				ef.setVisible(true);
				dispose();
			}
		});
		testbutton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28));

		JButton textGradebutton = new JButton("\u8003\u8BD5\u6210\u7EE9\u67E5\u8BE2");
		textGradebutton.setBackground(SystemColor.inactiveCaptionBorder);
		textGradebutton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28));

		JButton wrongQuestionsbutton = new JButton("\u9519\u9898\u96C6");
		wrongQuestionsbutton.setBackground(SystemColor.inactiveCaptionBorder);
		wrongQuestionsbutton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28));

		JButton updatePasswordbutton = new JButton("\u4FEE\u6539\u5BC6\u7801");
		updatePasswordbutton.setBackground(SystemColor.inactiveCaption);
		updatePasswordbutton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28));

		JButton signOutbutton = new JButton("\u9000\u51FA");
		signOutbutton.setBackground(SystemColor.inactiveCaptionBorder);
		signOutbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		signOutbutton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28));

		JButton Firstbutton = new JButton("\u9996\u9875");
		Firstbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame mf = new MainFrame(user);
				mf.setVisible(true);
				dispose();
			}
		});
		Firstbutton.setBackground(SystemColor.inactiveCaptionBorder);
		Firstbutton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28));

		JLabel lblNewLabel = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		lblNewLabel.setFont(new Font("Ó×Ô²", Font.PLAIN, 32));

		JLabel lblNewLabel_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("Ó×Ô²", Font.PLAIN, 32));

		JLabel lblNewLabel_1_1 = new JLabel("\u786E\u8BA4\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_1_1.setFont(new Font("Ó×Ô²", Font.PLAIN, 32));

		passwordtextField = new JTextField();
		passwordtextField.setFont(new Font("ËÎÌå", Font.PLAIN, 32));
		passwordtextField.setColumns(10);

		newPasswordtextField1 = new JTextField();
		newPasswordtextField1.setFont(new Font("ËÎÌå", Font.PLAIN, 32));
		newPasswordtextField1.setColumns(10);

		newPasswordtextField2 = new JTextField();
		newPasswordtextField2.setFont(new Font("ËÎÌå", Font.PLAIN, 32));
		newPasswordtextField2.setColumns(10);

		JButton btnNewButton = new JButton("\u786E\u5B9A\u4FEE\u6539");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (newPasswordtextField1.getText().equals(newPasswordtextField2.getText())) {// Á½´ÎÃÜÂëÏàÍ¬
					try {
						UserService.update(user, newPasswordtextField1.getText());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					LoginFrame lf = new LoginFrame();
					lf.setVisible(true);
					ChangePasswordSuccess cps = new ChangePasswordSuccess();
					cps.setVisible(true);
					dispose();
				} else {
					PassWordNoSame pwns = new PassWordNoSame();
					pwns.setVisible(true);
					newPasswordtextField1.setText("");
					newPasswordtextField2.setText("");
				}
			}
		});
		btnNewButton.setFont(new Font("Ó×Ô²", Font.PLAIN, 32));

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
				// ¼ÓÔØ×¢Ïú³É¹¦½çÃæ
				CancellationSuccess cs = new CancellationSuccess();
				cs.setVisible(true);
				LoginFrame lf = new LoginFrame();
				lf.setVisible(true);
				dispose();
			}
		});
		deleteUserbutton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28));
		deleteUserbutton.setBackground(SystemColor.inactiveCaptionBorder);

		JLabel label = new JLabel("»¶Ó­" + user.getUsername() + "ÓÃ»§½øÈëÏµÍ³£¡");
		label.setFont(new Font("Ó×Ô²", Font.PLAIN, 52));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(39)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(deleteUserbutton, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
								.addComponent(updatePasswordbutton, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
								.addComponent(Firstbutton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 201,
										Short.MAX_VALUE)
								.addComponent(testbutton, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
								.addComponent(textGradebutton, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
								.addComponent(wrongQuestionsbutton, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
						.addGap(151)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel).addComponent(lblNewLabel_1,
														GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
										.addGap(70)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(newPasswordtextField1, GroupLayout.PREFERRED_SIZE, 366,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(passwordtextField, GroupLayout.PREFERRED_SIZE, 366,
														GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 192,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnNewButton).addComponent(newPasswordtextField2,
														GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE))))
						.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(93).addComponent(label)
								.addPreferredGap(ComponentPlacement.RELATED)))
				.addComponent(signOutbutton).addGap(38)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(35)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addComponent(label).addGap(64)
						.addComponent(Firstbutton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(30)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNewLabel).addComponent(passwordtextField,
														GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(34).addComponent(testbutton,
										GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(33).addComponent(
										textGradebutton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(58)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 36,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(newPasswordtextField1, GroupLayout.PREFERRED_SIZE, 38,
														GroupLayout.PREFERRED_SIZE))))
						.addGap(21)
						.addComponent(wrongQuestionsbutton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
								.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 36,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(newPasswordtextField2, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(29).addComponent(
										updatePasswordbutton, GroupLayout.PREFERRED_SIZE, 52,
										GroupLayout.PREFERRED_SIZE)))
						.addGap(11)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(16).addComponent(
										deleteUserbutton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnNewButton)))
						.addComponent(signOutbutton))
				.addContainerGap(74, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
