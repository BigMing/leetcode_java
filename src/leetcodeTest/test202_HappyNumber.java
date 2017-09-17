package leetcodeTest;

import java.util.HashSet;
import java.util.Set;

public class test202_HappyNumber {
	/**
	 * Ҫע����ѭ�����⣬���磺2 ��4��16��37��58��89��145��42��20��4��16��37������
	 * @param n
	 * @return
	 */
	public static boolean isHappy(int n) {
		if (n <= 0)
			return false;
		long ln = n;
		Set<Long> set = new HashSet<Long>();
		while (ln <= Integer.MAX_VALUE) {
			if (set.contains(ln))
				return false;
			else {
				set.add(ln);
			}
			ln = digitSquare(ln);
			if (ln == 1)
				return true;
		}
		return false;
	}
	/**
	 * ����ÿλ���ֵ�ƽ����
	 */
	private static long digitSquare(long ln) {
		long sum = 0;
		while (ln != 0) {
			sum += Math.pow(ln % 10, 2); // ��Сһλƽ��
			ln /= 10; //����10��ʮλ���Ƶ���λ��
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(isHappy(2));
	}
}
