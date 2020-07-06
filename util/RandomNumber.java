package util;

import java.util.ArrayList;
import java.util.Random;

/**
 * 产生随机不重复数的类
 * 
 * @author 张诗羽
 * @version 1.0 2020/7/4
 */
public class RandomNumber {
	/**
	 * 产生随机数以便生成随机试卷的方法
	 * 
	 * @return 返回ArrayList集合，存放随机数
	 */
	public static ArrayList random() {
		// 创建随机数对象
		Random r = new Random();
		// 创建一个Set集合
		ArrayList<Integer> array = new ArrayList<Integer>();
		int count = 0;
		// 判断集合的长度是否小于5
		while (count < 5) {
			int num = r.nextInt(10) + 1;
			// 判断是否重复
			if (!array.contains(num)) {
				array.add(num);
				count++;
			}
		}
		return array;
	}
}
