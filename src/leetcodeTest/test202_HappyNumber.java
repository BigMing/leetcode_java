package leetcodeTest;

import java.util.HashSet;
import java.util.Set;

public class test202_HappyNumber {
	/*
	 * Input: 19 Output: true Explanation: 1^2 + 9^2 = 82; 8^2 + 2^2 = 68; 6^2 +
	 * 8^2 = 100; 1^2 + 0^2 + 0^2 = 1
	 */
	/*
	 * Ҫע����ѭ�����⣬���磺2 ��4��16��37��58��89��145��42��20��4��16��37����
	 */
	public static boolean isHappy(int n) {
		if (n <= 0)
			return false;
		long ln = n;
		Set<Long> set = new HashSet<Long>(); // ��set������ѭ��
		while (ln <= Integer.MAX_VALUE) {
			if (set.contains(ln))
				return false;
			else
				set.add(ln);
			ln = digitSquare(ln);
			if (ln == 1)
				return true;
		}
		return false;
	}

	// ����ÿλ���ֵ�ƽ����
	private static long digitSquare(long ln) {
		long sum = 0;
		while (ln != 0) {
			sum += Math.pow(ln % 10, 2); // ��Сһλƽ��
			ln /= 10; // ����10��ʮλ���Ƶ���λ��
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(isHappy(2));
	}
}
