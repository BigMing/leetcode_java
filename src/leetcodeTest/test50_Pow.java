package leetcodeTest;

public class test50_Pow {
	/**
	 * x^n=e^(nlnx)减少乘法次数，加大精度
	 * @param x
	 * @param n
	 * @return
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
