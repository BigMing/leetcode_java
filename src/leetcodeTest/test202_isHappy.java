package leetcodeTest;

import java.util.HashSet;
import java.util.Set;

public class test202_isHappy {
	
	/**
	 * 要注意死循环问题，比如：2 、4、16、37、58、89、145、42、20、4、16、37。。。
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
//				System.out.println(ln);
				set.add(ln);
			}
			ln = digitSquare(ln);
			if (ln == 1)
				return true;
		}
		return false;
	}

	/**
	 * 计算每位数字的平方和
	 * @param ln
	 * @return
	 */
	private static long digitSquare(long ln) {
		long sum = 0;
		while (ln != 0) {
			sum += Math.pow(ln % 10, 2);
			ln /= 10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(isHappy(2));
	}
}
