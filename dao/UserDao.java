package dao;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import domain.User;

/**
 * �����û�����ɾ���ʵ����
 * 
 * @author ��ʫ��
 * @version 1.0 2020/7/4
 *
 */
public class UserDao {

	/**
	 * ��ע���û������ļ��д洢�ķ���
	 * 
	 * @param user
	 *            ע����û�
	 * @return �Ƿ�ע��ɹ�
	 * @throws IOException
	 */
	public static boolean addUser(User user) throws IOException {
		// �����ҵ���־
		boolean found = false;

		// �����������������
		RandomAccessFile raf = new RandomAccessFile("contacts.txt", "rw");

		// ��ȡ�ļ�
		while (raf.getFilePointer() < raf.length()) {
			// ÿ�ζ�ȡһ�м�¼
			String record = raf.readLine();
			int index = record.indexOf("!");
			// ���û����ó���
			String username = record.substring(0, index);
			if (user.getUsername().equals(username)) {// ��ͬ���û����Ѿ����ڣ����ʧ��
				found = true;
				break;
			}
		}
		// ����û�����������ӳɹ�
		if (!found) {
			// �洢�û���Ϣ���ļ���
			raf.writeBytes(user.getUsername() + "!" + user.getPassWord());
			// ��ӻ���
			raf.writeBytes(System.lineSeparator());
		}
		raf.close();
		return !found;
	}

	/**
	 * ע���û��ķ���
	 * 
	 * @param user
	 *            Ҫע�����û�
	 * @throws IOException
	 */
	public static void deleteUser(User user) throws IOException {

		// ������ʱ�ļ�����
		File file = new File("temp.txt");
		// �����������������
		RandomAccessFile raf = new RandomAccessFile("contacts.txt", "rw");
		RandomAccessFile tempraf = new RandomAccessFile(file, "rw");

		// ���û�ɾ��
		while (raf.getFilePointer() < raf.length()) {
			// ÿ�ζ�ȡһ�м�¼
			String record = raf.readLine();
			int index = record.indexOf("!");
			// ���û������ó���
			String username = record.substring(0, index);
			if (user.getUsername().equals(username)) {// ��������
				continue;
			}
			// ���Ƶ���ʱ�ļ���
			tempraf.writeBytes(record);
			// ��ӻ���
			tempraf.writeBytes(System.lineSeparator());
		}
		// ָ�븴λ
		raf.seek(0);
		tempraf.seek(0);

		// ����ʱ�ļ����Ƶ��û���Ϣ�ļ�
		while (tempraf.getFilePointer() < tempraf.length()) {
			// �����û���Ϣ
			raf.writeBytes(tempraf.readLine());
			// ��ӻ���
			raf.writeBytes(System.lineSeparator());
		}
		raf.setLength(tempraf.length());

		tempraf.close();
		raf.close();
		// ɾ����ʱ�ļ�
		file.delete();
	}

	/**
	 * ��¼ʱ�鿴�����Ƿ�ƥ��ķ���
	 * 
	 * @param user
	 *            ��¼�û�
	 * @return ����
	 * @throws IOException
	 */
	public static String getUser(User user) throws IOException {
		// �����������������
		RandomAccessFile raf = new RandomAccessFile("contacts.txt", "rw");

		// ��ȡ�ļ�
		while (raf.getFilePointer() < raf.length()) {
			// ÿ�ζ�ȡһ�м�¼
			String record = raf.readLine();
			int index = record.indexOf("!");
			// ���û����������ó���
			String username = record.substring(0, index);
			String passWord = record.substring(index + 1);
			if (user.getUsername().equals(username) && user.getPassWord().equals(passWord)) {// �ҵ����û�
				// ��������
				return passWord;
			}
		}
		raf.close();
		return null;
	}

	/**
	 * �޸��û�����ķ���
	 * 
	 * @param user
	 *            Ҫ�޸ĵ��û�
	 * @param pwd
	 *            ���޸ĵ�����
	 * @throws IOException
	 */
	public static void updateUser(User user, String pwd) throws IOException {
		// ������ʱ�ļ�����
		File file = new File("temp.txt");
		// �����������������
		RandomAccessFile raf = new RandomAccessFile("contacts.txt", "rw");
		RandomAccessFile tempraf = new RandomAccessFile(file, "rw");

		while (raf.getFilePointer() < raf.length()) {
			// ÿ�ζ�ȡһ�м�¼
			String record = raf.readLine();
			int index = record.indexOf("!");
			// ���û������ó���
			String username = record.substring(0, index);
			if (user.getUsername().equals(username)) {// �޸�����
				record = user.getUsername() + "!" + pwd;
			}
			// ���Ƶ���ʱ�ļ���
			tempraf.writeBytes(record);
			// ��ӻ���
			tempraf.writeBytes(System.lineSeparator());
		}

		// ָ�븴λ
		raf.seek(0);
		tempraf.seek(0);

		// ����ʱ�ļ����Ƶ��û���Ϣ�ļ�
		while (tempraf.getFilePointer() < tempraf.length()) {
			// �����û���Ϣ
			raf.writeBytes(tempraf.readLine());
			// ��ӻ���
			raf.writeBytes(System.lineSeparator());
		}
		raf.setLength(tempraf.length());

		tempraf.close();
		raf.close();
		// ɾ����ʱ�ļ�
		file.delete();
	}
}
