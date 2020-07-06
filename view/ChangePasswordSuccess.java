package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.FrameCenterUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 修改密码成功界面
 * 
 * @author 张诗羽
 * @version 1.0 2020/7/4
 */
public class ChangePasswordSuccess extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ChangePasswordSuccess() {
		// 设置窗体居中
		setSize(450, 300);
		FrameCenterUtil fcu = new FrameCenterUtil(this);
		setTitle("\u4FEE\u6539\u6210\u529F");
		// 设置只关闭当前窗口
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u6210\u529F,\u8BF7\u91CD\u65B0\u767B\u5F55\uFF01\uFF01\uFF01");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));

		JButton button = new JButton("\u786E\u5B9A");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 18));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(160).addComponent(button))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(70).addComponent(lblNewLabel)))
						.addContainerGap(77, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(71, Short.MAX_VALUE)
						.addComponent(lblNewLabel).addGap(67).addComponent(button).addGap(50)));
		contentPane.setLayout(gl_contentPane);
	}
}
