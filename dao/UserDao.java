package dao;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import domain.User;

/**
 * 这是用户的增删查改实现类
 * 
 * @author 张诗羽
 * @version 1.0 2020/7/4
 *
 */
public class UserDao {

	/**
	 * 把注册用户放入文件中存储的方法
	 * 
	 * @param user
	 *            注册的用户
	 * @return 是否注册成功
	 * @throws IOException
	 */
	public static boolean addUser(User user) throws IOException {
		// 定义找到标志
		boolean found = false;

		// 创建随机访问流对象
		RandomAccessFile raf = new RandomAccessFile("contacts.txt", "rw");

		// 读取文件
		while (raf.getFilePointer() < raf.length()) {
			// 每次读取一行记录
			String record = raf.readLine();
			int index = record.indexOf("!");
			// 把用户名拿出来
			String username = record.substring(0, index);
			if (user.getUsername().equals(username)) {// 相同则用户名已经存在，添加失败
				found = true;
				break;
			}
		}
		// 这个用户不存在则添加成功
		if (!found) {
			// 存储用户信息到文件中
			raf.writeBytes(user.getUsername() + "!" + user.getPassWord());
			// 添加换行
			raf.writeBytes(System.lineSeparator());
		}
		raf.close();
		return !found;
	}

	/**
	 * 注销用户的方法
	 * 
	 * @param user
	 *            要注销的用户
	 * @throws IOException
	 */
	public static void deleteUser(User user) throws IOException {

		// 创建临时文件对象
		File file = new File("temp.txt");
		// 创建随机访问流对象
		RandomAccessFile raf = new RandomAccessFile("contacts.txt", "rw");
		RandomAccessFile tempraf = new RandomAccessFile(file, "rw");

		// 把用户删除
		while (raf.getFilePointer() < raf.length()) {
			// 每次读取一行记录
			String record = raf.readLine();
			int index = record.indexOf("!");
			// 把用户名和拿出来
			String username = record.substring(0, index);
			if (user.getUsername().equals(username)) {// 跳过复制
				continue;
			}
			// 复制到临时文件中
			tempraf.writeBytes(record);
			// 添加换行
			tempraf.writeBytes(System.lineSeparator());
		}
		// 指针复位
		raf.seek(0);
		tempraf.seek(0);

		// 把临时文件复制到用户信息文件
		while (tempraf.getFilePointer() < tempraf.length()) {
			// 复制用户信息
			raf.writeBytes(tempraf.readLine());
			// 添加换行
			raf.writeBytes(System.lineSeparator());
		}
		raf.setLength(tempraf.length());

		tempraf.close();
		raf.close();
		// 删除临时文件
		file.delete();
	}

	/**
	 * 登录时查看密码是否匹配的方法
	 * 
	 * @param user
	 *            登录用户
	 * @return 密码
	 * @throws IOException
	 */
	public static String getUser(User user) throws IOException {
		// 创建随机访问流对象
		RandomAccessFile raf = new RandomAccessFile("contacts.txt", "rw");

		// 读取文件
		while (raf.getFilePointer() < raf.length()) {
			// 每次读取一行记录
			String record = raf.readLine();
			int index = record.indexOf("!");
			// 把用户名和密码拿出来
			String username = record.substring(0, index);
			String passWord = record.substring(index + 1);
			if (user.getUsername().equals(username) && user.getPassWord().equals(passWord)) {// 找到该用户
				// 返回密码
				return passWord;
			}
		}
		raf.close();
		return null;
	}

	/**
	 * 修改用户密码的方法
	 * 
	 * @param user
	 *            要修改的用户
	 * @param pwd
	 *            想修改的密码
	 * @throws IOException
	 */
	public static void updateUser(User user, String pwd) throws IOException {
		// 创建临时文件对象
		File file = new File("temp.txt");
		// 创建随机访问流对象
		RandomAccessFile raf = new RandomAccessFile("contacts.txt", "rw");
		RandomAccessFile tempraf = new RandomAccessFile(file, "rw");

		while (raf.getFilePointer() < raf.length()) {
			// 每次读取一行记录
			String record = raf.readLine();
			int index = record.indexOf("!");
			// 把用户名和拿出来
			String username = record.substring(0, index);
			if (user.getUsername().equals(username)) {// 修改密码
				record = user.getUsername() + "!" + pwd;
			}
			// 复制到临时文件中
			tempraf.writeBytes(record);
			// 添加换行
			tempraf.writeBytes(System.lineSeparator());
		}

		// 指针复位
		raf.seek(0);
		tempraf.seek(0);

		// 把临时文件复制到用户信息文件
		while (tempraf.getFilePointer() < tempraf.length()) {
			// 复制用户信息
			raf.writeBytes(tempraf.readLine());
			// 添加换行
			raf.writeBytes(System.lineSeparator());
		}
		raf.setLength(tempraf.length());

		tempraf.close();
		raf.close();
		// 删除临时文件
		file.delete();
	}
}
