package leetcodeTest;

public class test172_FactorialTrailingZeroes {
	/*
	 * a * 10^k Çók
	 */
	public static int trailingZeroes(int n) {
		if (n < 1)
			return 0;
		int k = 0;
		while (n / 5 != 0) {
			n /= 5;
			k += n;
		} // 5 * 5 * 5 ...
		return k;
	}

	public static void main(String[] args) {
		System.out.println(trailingZeroes(4));
	}
}