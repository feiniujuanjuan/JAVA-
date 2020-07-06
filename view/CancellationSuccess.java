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
 * 注销用户成功窗口
 * 
 * @author 张诗羽
 * @version 1.0 2020/7/4
 */
public class CancellationSuccess extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CancellationSuccess() {
		// 设置窗体居中
		setSize(450, 300);
		FrameCenterUtil fcu = new FrameCenterUtil(this);
		setTitle("\u6CE8\u9500\u6210\u529F");
		// 设置只关闭当前窗口
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u6CE8\u9500\u6210\u529F\uFF01\uFF01\uFF01");
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
								.addGroup(gl_contentPane.createSequentialGroup().addGap(116).addComponent(lblNewLabel)))
						.addContainerGap(152, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(80, Short.MAX_VALUE)
						.addComponent(lblNewLabel).addGap(58).addComponent(button).addGap(50)));
		contentPane.setLayout(gl_contentPane);
	}
}
