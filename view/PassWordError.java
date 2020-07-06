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
 * �û���������������
 * 
 * @author ��ʫ��
 * @version 1.0 2020/7/4
 */
public class PassWordError extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PassWordError() {
		// ���ô������
		setSize(450, 300);
		FrameCenterUtil fcu = new FrameCenterUtil(this);
		setTitle("\u7528\u6237\u540D\u6216\u5BC6\u7801\u9519\u8BEF");
		// ����ֻ�رյ�ǰ����
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u8D26\u6237\u5BC6\u7801\u4E0D\u5339\u914D\uFF01\uFF01\uFF01");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 22));

		JButton button = new JButton("\u786E\u5B9A");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 18));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(160).addComponent(button))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(109).addComponent(lblNewLabel)))
						.addContainerGap(159, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING, gl_contentPane.createSequentialGroup().addContainerGap(71, Short.MAX_VALUE)
						.addComponent(lblNewLabel).addGap(67).addComponent(button).addGap(50)));
		contentPane.setLayout(gl_contentPane);
	}
}
