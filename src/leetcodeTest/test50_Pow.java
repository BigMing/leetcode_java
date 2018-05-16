package leetcodeTest;

public class test50_Pow {
	/*
	 * Example 1:Input: 2.00000, 10;Output: 1024.00000
	 * Example 2:Input: 2.10000, 3;Output: 9.26100
	 * Example 3:Input: 2.00000, -2;Output: 0.25000
	 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
	 */
	/*
	 * x^n = e^(nlnx) 减少乘法次数，加大精度
	 */
	public double myPow(double x, int n) {
		int flag = 1;
		if (x < 0 && n % 2 == 1) {
			flag = -1;
		}
		x = Math.abs(x);
		return flag * Math.exp(Math.log(x) * n);
	}
}
