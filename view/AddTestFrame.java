package view;

import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Examination;
import service.ExaminationService;
import util.FrameCenterUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

/**
 * ¹ÜÀíÔ±Ìí¼ÓÊÔÌâµÄ´°¿Ú
 * 
 * @author ÕÅÊ«Óð
 * @version 1.0 2020/7/4
 */
public class AddTestFrame extends JFrame {

	private JPanel contentPane;
	private JTextField question;
	private JTextField A;
	private JTextField B;
	private JTextField C;
	private JTextField D;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1_1_1_2;
	private JTextField answer;

	/**
	 * Create the frame.
	 */
	public AddTestFrame() { 
		//ÉèÖÃ´°Ìå¾ÓÖÐ
		setSize(630, 752);
		FrameCenterUtil fcu=new FrameCenterUtil(this);
		//ÉèÖÃÖ»¹Ø±Õµ±Ç°´°¿Ú
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false); // ´°¿Ú²»¿É×î´ó»¯
		setTitle("\u6DFB\u52A0\u8BD5\u9898");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u9898\u76EE\uFF1A");
		lblNewLabel.setFont(new Font("Ó×Ô²", Font.PLAIN, 28));
		
		JLabel lblA = new JLabel("A\u9009\u9879\uFF1A");
		lblA.setFont(new Font("Ó×Ô²", Font.PLAIN, 28));
		
		JLabel lblNewLabel_1_1 = new JLabel("B\u9009\u9879\uFF1A");
		lblNewLabel_1_1.setFont(new Font("Ó×Ô²", Font.PLAIN, 28));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("C\u9009\u9879\uFF1A");
		lblNewLabel_1_1_1.setFont(new Font("Ó×Ô²", Font.PLAIN, 28));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("D\u9009\u9879\uFF1A");
		lblNewLabel_1_1_1_1.setFont(new Font("Ó×Ô²", Font.PLAIN, 28));
		
		question = new JTextField();
		question.setFont(new Font("Ó×Ô²", Font.PLAIN, 28));
		question.setColumns(50);
		
		A = new JTextField();
		A.setFont(new Font("Ó×Ô²", Font.PLAIN, 28));
		A.setColumns(50);
		
		B = new JTextField();
		B.setFont(new Font("Ó×Ô²", Font.PLAIN, 28));
		B.setColumns(50);
		
		C = new JTextField();
		C.setFont(new Font("Ó×Ô²", Font.PLAIN, 28));
		C.setColumns(50);
		
		D = new JTextField(); 
		D.setFont(new Font("Ó×Ô²", Font.PLAIN, 28));
		D.setColumns(50);
		
		lblNewLabel_1_1_1_2 = new JLabel("\u7B54\u6848\uFF1A");
		lblNewLabel_1_1_1_2.setFont(new Font("Ó×Ô²", Font.PLAIN, 28));
		
		answer = new JTextField();
		answer.setFont(new Font("Ó×Ô²", Font.PLAIN, 28));
		answer.setColumns(50);
		
		btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Examination exam=new Examination(0,question.getText(),A.getText(),B.getText(),C.getText(),D.getText(),answer.getText());
				try {
					ExaminationService.add(exam); 
				} catch (ClassNotFoundException e1) {
			 		// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block 
					e1.printStackTrace();
				} 
				dispose(); 
				AdminFrame af = new AdminFrame();
				af.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Ó×Ô²", Font.PLAIN, 32));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(192)
					.addComponent(btnNewButton)
					.addContainerGap(313, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1_2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(answer, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_1_1_1)
										.addGap(18))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_1_1_1_1, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblA, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(A, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
										.addComponent(question, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)))
								.addComponent(B, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
								.addComponent(C, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
								.addComponent(D, 0, 0, Short.MAX_VALUE))))
					.addGap(29))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(142)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(question, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblA, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(A, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(B, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(C, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(D, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1_1_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(answer, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(40))
		);
		contentPane.setLayout(gl_contentPane);	
		}
}
