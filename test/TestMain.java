package test;

import view.LoginFrame;

/**
 * 程序起点类
 * 
 * @author 张诗羽 
 * @version 1.0 2020/7/4
 *
 */
public class TestMain {
	/** 
	 * mian方法，程序的起点
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 加载系统登录界面
		LoginFrame login = new LoginFrame();
		login.setVisible(true);
	} 
}
