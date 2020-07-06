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
 * 管理员登录界面
 * 
 * @author 张诗羽
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
		// 设置窗体居中
		setSize(1500, 752);
		FrameCenterUtil fcu = new FrameCenterUtil(this);
		// 设置只关闭当前窗口
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false); // 窗口不可最大化
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);// 取消默认布局
		setContentPane(contentPane);

		DefaultTableModel model = new DefaultTableModel(); // 设置数据模型
		try {
			model.setColumnIdentifiers(new Object[] { "题号", "题目", "A选项", "B选项", "C选项", "D选项", "答案" }); // 设置表头
			List<Examination> list = ExaminationService.check(); // 获取表数据
			for (Examination exam : list) {
				model.addRow(new Object[] { exam.getNumber(), exam.getQuestion(), exam.getA(), exam.getB(), exam.getC(),
						exam.getD(), exam.getAnswer() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JTable table = new JTable(model);
		// 获取选中表格中某行的信息
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 得到选中的行列的索引值
				int r = table.getSelectedRow();
				int c = table.getSelectedColumn();
				if (r == -1 && c == -1) {
					JOptionPane.showMessageDialog(null, "当前点击无效");
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

		// 修改按钮，打开修改对话框
		JButton Update = new JButton("修改");
		Update.setFont(new Font("幼圆", Font.BOLD, 28));
		Update.setBounds(460, 615, 138, 51);
		contentPane.add(Update);
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XG x = new XG(en);
				x.setVisible(true);
				dispose();
			}
		});

		table.setRowHeight(22);// 行高
		table.setFont(new Font("幼圆", Font.BOLD, 22));// 信息字体
		table.getTableHeader().setPreferredSize(new Dimension(1, 32)); // 设置表头高度
		table.setRowHeight(32);// 设置表格高度
		table.getTableHeader().setFont(new Font("幼圆", Font.BOLD, 22)); // 设置表头字体
		table.getTableHeader().setBackground(Color.LIGHT_GRAY); // 设置表头背景颜色

		// 设置单元格内容居中
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);

		// 滚动面板
		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(14, 64, 1466, 519);
		jsp.setViewportView(table); // 设置滚动面板的视图为表格
		contentPane.add(jsp);// 将表格添加进窗口中

		JButton add = new JButton("\u6DFB\u52A0");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTestFrame atf = new AddTestFrame();
				atf.setVisible(true);
				dispose();
			}
		});
		add.setFont(new Font("幼圆", Font.BOLD, 28));
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
		Update_1.setFont(new Font("幼圆", Font.BOLD, 28));
		Update_1.setBounds(787, 615, 138, 51);
		contentPane.add(Update_1);

		JButton Update_1_1 = new JButton("\u9000\u51FA");
		Update_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Update_1_1.setFont(new Font("幼圆", Font.BOLD, 28));
		Update_1_1.setBounds(1137, 615, 138, 51);
		contentPane.add(Update_1_1);
	}
}
