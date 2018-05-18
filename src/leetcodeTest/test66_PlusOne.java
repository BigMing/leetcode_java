package leetcodeTest;

public class test66_PlusOne {
	/*
	 * Example 1:Input: [1,2,3],Output: [1,2,4],Explanation: The array represents the integer 123.
	 * Example 2:Input: [4,3,2,1],Output: [4,3,2,2],Explanation: The array represents the integer 4321.
	 */
	public int[] plusOne(int[] digits) {
		int c = 1; // ��λ��ʶ
		for (int i = digits.length - 1; i >= 0; i--) { // ��������Ǹ�λ��
			// ���ϴ����λ
			int a = digits[i] + c;
			digits[i] = a % 10;
			c = a / 10;
		}
		if (c == 1) { // ����н�λ
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			for (int i = 0; i < digits.length; i++) {
				res[i + 1] = digits[i];
			}
			return res;
		}
		return digits;
	}
}
