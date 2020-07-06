package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.User;
import service.UserService;
import util.FrameCenterUtil;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

/**
 * 用户登录界面
 * 
 * @author 张诗羽
 * @version 1.0 2020/7/4
 */
public class LoginFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		// 设置窗体居中
		setSize(1128, 756);
		FrameCenterUtil fcu = new FrameCenterUtil(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"D:\\\u5E94\u7528\\java\\Java\u7A0B\u5E8F\\\u5728\u7EBF\u8003\u8BD5\u7CFB\u7EDF\\\u56FE\u7247\\\u56FE\u6807.jpeg"));
		setFont(new Font("宋体", Font.PLAIN, 36));
		setTitle("\u5728\u7EBF\u8003\u8BD5\u7CFB\u7EDF");
		// 设置只关闭当前窗口
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel userLabel = new JLabel("\u7528\u6237\u767B\u5F55");
		userLabel.setForeground(new Color(0, 0, 0));
		userLabel.setFont(new Font("宋体", Font.PLAIN, 88));

		JLabel namelabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		namelabel.setFont(new Font("宋体", Font.PLAIN, 42));

		JLabel passwordlabel = new JLabel("\u5BC6\u7801\uFF1A");
		passwordlabel.setFont(new Font("宋体", Font.PLAIN, 42));

		JTextField nameField = new JTextField();
		nameField.setFont(new Font("宋体", Font.PLAIN, 42));
		nameField.setColumns(10);

		JTextField passwordField = new JTextField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 42));
		passwordField.setColumns(16);

		JButton registerButton = new JButton("\u6CE8\u518C");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistFrame rf = new RegistFrame();
				rf.setVisible(true);
			}
		});
		registerButton.setFont(new Font("宋体", Font.PLAIN, 36));

		JButton clearButton = new JButton("\u91CD\u7F6E");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameField.setText("");
				passwordField.setText("");
			}
		});
		clearButton.setFont(new Font("宋体", Font.PLAIN, 36));

		JButton loginButton = new JButton("");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 判断是不是管理员身份
				if (nameField.getText().equals("admin") && passwordField.getText().equals("admin")) {
					AdminFrame af = new AdminFrame();
					af.setVisible(true);
					dispose();
				} else {
					// 存放用户名所对应的密码
					String password = null;
					try {
						// 拿到用户名所对应的密码
						password = UserService.Login(new User(nameField.getText(), passwordField.getText()));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (password != null) {
						// 加载用户界面
						MainFrame mf = new MainFrame(new User(nameField.getText(), passwordField.getText()));
						mf.setVisible(true);
						dispose();
					} else {
						// 加载账户密码不匹配界面
						PassWordError pwe = new PassWordError();
						pwe.setVisible(true);
						passwordField.setText("");
					}
				}
			}
		});
		loginButton.setIcon(new ImageIcon(
				"D:\\\u5E94\u7528\\java\\Java\u7A0B\u5E8F\\OnlineExaminationSystem\\src\\img\\\u767B\u5F55.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addContainerGap(130, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(passwordlabel, GroupLayout.PREFERRED_SIZE, 168,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(namelabel))
						.addGap(141)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
								.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 418,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 418,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(registerButton).addGap(88)
										.addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 115,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(106))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(348).addComponent(userLabel)))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(112)
				.addComponent(userLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE).addGap(64)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(namelabel).addComponent(
						nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(48)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(loginButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 54, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(passwordlabel, GroupLayout.PREFERRED_SIZE, 48,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)))
				.addGap(103)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(registerButton))
				.addGap(128)));
		contentPane.setLayout(gl_contentPane);
	}
}