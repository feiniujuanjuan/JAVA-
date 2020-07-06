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
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * ע�����
 * 
 * @author ��ʫ��
 * @version 1.0 2020/7/4
 */
public class RegistFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public RegistFrame() {
		// ���ô������
		setSize(1128, 756);
		FrameCenterUtil fcu = new FrameCenterUtil(this);
		setFont(new Font("����", Font.PLAIN, 36));
		setTitle("\u5728\u7EBF\u8003\u8BD5\u7CFB\u7EDF");
		// ����ֻ�رյ�ǰ����
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel userRegistLabel = new JLabel("\u7528\u6237\u6CE8\u518C");
		userRegistLabel.setForeground(new Color(0, 0, 0));
		userRegistLabel.setFont(new Font("����", Font.PLAIN, 88));

		JLabel userNamelabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		userNamelabel.setFont(new Font("����", Font.PLAIN, 42));

		JLabel passwordlabel1 = new JLabel("\u5BC6\u7801\uFF1A");
		passwordlabel1.setFont(new Font("����", Font.PLAIN, 42));

		JTextField userNameField = new JTextField();
		userNameField.setFont(new Font("����", Font.PLAIN, 42));
		userNameField.setColumns(10);

		JTextField passwordField = new JTextField();
		passwordField.setFont(new Font("����", Font.PLAIN, 42));
		passwordField.setColumns(16);

		JTextField passWordField1 = new JTextField();
		passWordField1.setFont(new Font("����", Font.PLAIN, 42));
		passWordField1.setColumns(16);

		JButton registButton = new JButton("\u63D0\u4EA4\u6CE8\u518C");
		registButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// �����ж�ע���Ƿ�ɹ�
				boolean flag = false;
				if (passwordField.getText().equals(passWordField1.getText())) {// �������������һ��
					try {
						// �û�����û��ע���
						flag = UserService.Regist(new User(userNameField.getText(), passwordField.getText()));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (flag) {
						// ����ע��ɹ�����
						RegistSuccessFrame rsf = new RegistSuccessFrame();
						rsf.setVisible(true);
						dispose();
					} else {
						// �����û����ظ�����
						RegistErrorFrame ref = new RegistErrorFrame();
						ref.setVisible(true);
						userNameField.setText("");
					}
				} else {
					// ���������������벻һ�½���
					PassWordNoSame pwns = new PassWordNoSame();
					pwns.setVisible(true);
					passwordField.setText("");
					passWordField1.setText("");
				}
			}
		});
		registButton.setFont(new Font("����", Font.PLAIN, 36));

		JLabel passwordlabel2 = new JLabel("\u786E\u5B9A\u5BC6\u7801\uFF1A");
		passwordlabel2.setFont(new Font("����", Font.PLAIN, 42));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(196, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(passwordlabel2)
								.addComponent(passwordlabel1, GroupLayout.PREFERRED_SIZE, 168,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(userNamelabel))
						.addGap(98)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(userNameField, GroupLayout.PREFERRED_SIZE, 418,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(
										gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(registButton)
												.addComponent(passWordField1, GroupLayout.PREFERRED_SIZE, 418,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 418,
														Short.MAX_VALUE)))
						.addContainerGap(220, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(344).addComponent(userRegistLabel)
						.addContainerGap(404, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(98)
				.addComponent(userRegistLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE).addGap(52)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(userNamelabel))
				.addGap(35)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordlabel1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
				.addGap(35)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passWordField1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordlabel2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE).addComponent(registButton)
				.addGap(134)));
		contentPane.setLayout(gl_contentPane);
	}
}
