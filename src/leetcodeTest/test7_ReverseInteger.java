package leetcodeTest;

public class test7_ReverseInteger {
	/*
	 * Example 1:Input: 123,Output: 321
	 * Example 2:Input: -123,Output: -321
	 * Example 3:,Input: 120,Output: 21
	 */
	public static int reverse(int x) {
		// ��������ȶ���������Сֵ
		final int MAX_VALUE = Integer.MAX_VALUE;
		final int MIN_VALUE = Integer.MIN_VALUE;
		long ans = 0;
		while (x != 0) {
			ans = ans * 10 + (x % 10); //ȡ��x�����һλ
			x /= 10;
		}
		if (ans > MAX_VALUE || ans < MIN_VALUE) {
			ans = 0;
		}
		return (int) ans;
	}
	
	public static void main(String[] args) {
		System.out.println(reverse(-123456));
	}
}
