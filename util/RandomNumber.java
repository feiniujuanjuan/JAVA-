package util;

import java.util.ArrayList;
import java.util.Random;

/**
 * ����������ظ�������
 * 
 * @author ��ʫ��
 * @version 1.0 2020/7/4
 */
public class RandomNumber {
	/**
	 * ����������Ա���������Ծ�ķ���
	 * 
	 * @return ����ArrayList���ϣ���������
	 */
	public static ArrayList random() {
		// �������������
		Random r = new Random();
		// ����һ��Set����
		ArrayList<Integer> array = new ArrayList<Integer>();
		int count = 0;
		// �жϼ��ϵĳ����Ƿ�С��5
		while (count < 5) {
			int num = r.nextInt(10) + 1;
			// �ж��Ƿ��ظ�
			if (!array.contains(num)) {
				array.add(num);
				count++;
			}
		}
		return array;
	}
}
