package leetcodeTest;

public class test66_PlusOne {
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
