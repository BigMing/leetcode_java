package leetcodeTest;

public class test172_trailingZeroes {
	/**
	 * a * 10^k Çók
	 * @param n
	 * @return
	 */
	public static int trailingZeroes(int n) {
		if (n < 1)
			return 0;
		int k = 0;
		while (n / 5 != 0) {
			n /= 5;
			k += n;
		}
		return k;
	}

	public static void main(String[] args) {
		System.out.println(trailingZeroes(4));
	}
}