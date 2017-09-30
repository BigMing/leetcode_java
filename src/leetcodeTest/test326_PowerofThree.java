package leetcodeTest;

public class test326_PowerofThree {
	public static boolean isPowerOfThree(int n) {
		if (n <= 0) {
			return false;
		}
		while (n > 1) {
			if (n % 3 == 0)
				n = n / 3;
			else
				return false;
		}
		return true;
	}
	/**
	 * µ›πÈ µœ÷
	 */
	public static boolean isPowerOfThree1(int n) {
		if (n <= 0)
			return false;
		if (n == 1)
			return true;
		else if (n % 3 == 0)
			return isPowerOfThree(n / 3);
		else
			return false;
	}

	public static void main(String[] args) {
		System.out.println(isPowerOfThree1(26));
	}

}
