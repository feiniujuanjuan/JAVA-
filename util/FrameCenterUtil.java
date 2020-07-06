package util;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * 让swing窗口居中的方法
 * 
 * @author 张诗羽
 * @version 1.0 2020/7/4
 *
 */
public class FrameCenterUtil extends JFrame {

	/**
	 * Create the frame.
	 */
	public FrameCenterUtil(Frame frame) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();

		double srceenWidth = d.getWidth();
		double srceenHeight = d.getHeight();

		double frameWidth = frame.getWidth();
		double frameHeight = frame.getHeight();

		int width = (int) (srceenWidth - frameWidth) / 2;
		int height = (int) (srceenHeight - frameHeight) / 2;
		frame.setLocation(width, height);
	}

}
