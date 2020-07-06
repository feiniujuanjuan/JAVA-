package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import domain.Examination;
import service.ExaminationService;
import util.FrameCenterUtil;

/**
 * ����Ա��¼����
 * 
 * @author ��ʫ��
 * @version 1.0 2020/7/4
 */
public class AdminFrame extends JFrame {

	private JPanel contentPane;
	static Examination en = new Examination();

	/**
	 * Create the frame.
	 */
	public AdminFrame() {
		setTitle("\u9898\u5E93");
		// ���ô������
		setSize(1500, 752);
		FrameCenterUtil fcu = new FrameCenterUtil(this);
		// ����ֻ�رյ�ǰ����
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false); // ���ڲ������
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);// ȡ��Ĭ�ϲ���
		setContentPane(contentPane);

		DefaultTableModel model = new DefaultTableModel(); // ��������ģ��
		try {
			model.setColumnIdentifiers(new Object[] { "���", "��Ŀ", "Aѡ��", "Bѡ��", "Cѡ��", "Dѡ��", "��" }); // ���ñ�ͷ
			List<Examination> list = ExaminationService.check(); // ��ȡ������
			for (Examination exam : list) {
				model.addRow(new Object[] { exam.getNumber(), exam.getQuestion(), exam.getA(), exam.getB(), exam.getC(),
						exam.getD(), exam.getAnswer() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JTable table = new JTable(model);
		// ��ȡѡ�б����ĳ�е���Ϣ
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// �õ�ѡ�е����е�����ֵ
				int r = table.getSelectedRow();
				int c = table.getSelectedColumn();
				if (r == -1 && c == -1) {
					JOptionPane.showMessageDialog(null, "��ǰ�����Ч");
				} else {
					Object[][] value = new Object[r + 1][7];
					for (int i = r; i < r + 1; i++) {
						for (int j = 0; j < 7; j++) {
							value[i][j] = table.getValueAt(i, j);
						}
					}
					for (int i = r; i < r + 1; i++) {
						en.setNumber((int) value[i][0]);
						en.setQuestion(value[i][1].toString());
						en.setA(value[i][2].toString());
						en.setB(value[i][3].toString());
						en.setC(value[i][4].toString());
						en.setD(value[i][5].toString());
						en.setAnswer(value[i][6].toString());
					}
				}
			}
		});

		// �޸İ�ť�����޸ĶԻ���
		JButton Update = new JButton("�޸�");
		Update.setFont(new Font("��Բ", Font.BOLD, 28));
		Update.setBounds(460, 615, 138, 51);
		contentPane.add(Update);
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XG x = new XG(en);
				x.setVisible(true);
				dispose();
			}
		});

		table.setRowHeight(22);// �и�
		table.setFont(new Font("��Բ", Font.BOLD, 22));// ��Ϣ����
		table.getTableHeader().setPreferredSize(new Dimension(1, 32)); // ���ñ�ͷ�߶�
		table.setRowHeight(32);// ���ñ��߶�
		table.getTableHeader().setFont(new Font("��Բ", Font.BOLD, 22)); // ���ñ�ͷ����
		table.getTableHeader().setBackground(Color.LIGHT_GRAY); // ���ñ�ͷ������ɫ

		// ���õ�Ԫ�����ݾ���
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);

		// �������
		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(14, 64, 1466, 519);
		jsp.setViewportView(table); // ���ù���������ͼΪ���
		contentPane.add(jsp);// �������ӽ�������

		JButton add = new JButton("\u6DFB\u52A0");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTestFrame atf = new AddTestFrame();
				atf.setVisible(true);
				dispose();
			}
		});
		add.setFont(new Font("��Բ", Font.BOLD, 28));
		add.setBounds(112, 615, 138, 51);
		contentPane.add(add);

		JButton Update_1 = new JButton("\u5220\u9664");
		Update_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ExaminationService.delete(en);
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
		Update_1.setFont(new Font("��Բ", Font.BOLD, 28));
		Update_1.setBounds(787, 615, 138, 51);
		contentPane.add(Update_1);

		JButton Update_1_1 = new JButton("\u9000\u51FA");
		Update_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Update_1_1.setFont(new Font("��Բ", Font.BOLD, 28));
		Update_1_1.setBounds(1137, 615, 138, 51);
		contentPane.add(Update_1_1);
	}
}
