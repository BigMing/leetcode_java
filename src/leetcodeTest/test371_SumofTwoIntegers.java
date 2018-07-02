package leetcodeTest;

public class test371_SumofTwoIntegers {
	/*
	 * Calculate the sum of two integers a and b, but you are not allowed to use
	 * the operator + and -.
	 * 
	 * Example: Given a = 1 and b = 2, return 3.
	 */
	public int getSum(int a, int b) {
		int result = a ^ b; // ��λ��
		int carray = (a & b) << 1; // �����λ
		if (carray != 0)
			return getSum(result, carray); // �жϽ�λ�봦��
		return result;
	}

	public int getSum1(int a, int b) {
		while (b != 0) {
			int c = a & b;
			a = a ^ b;
			b = c << 1;
		}
		return a;
	}

}
