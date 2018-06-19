package leetcodeTest;

public class test191_Numberof1Bits {
	/*
	 * Example 1:
	 * 
	 * Input: 11 Output: 3 Explanation: Integer 11 has binary representation
	 * 00000000000000000000000000001011 Example 2:
	 * 
	 * Input: 128 Output: 1 Explanation: Integer 128 has binary representation
	 * 00000000000000000000000010000000
	 */
	public static int hammingWeight(int n) {
		int count = 0;
		String ns = Integer.toBinaryString(n);
		for (char i : ns.toCharArray()) {
			if (i == '1')
				count++;
		}
		return count;
	}

	/*
	 * �����λ��λ�룬��������Ӽ���
	 */
	public int hammingWeight1(int n) {
		int count = 0;
		while (n != 0) {
			count += n & 1;
			n >>>= 1; // >> ���� 
			// >>> ���ƣ���߿ճ���λ��0�� ��
		}
		return count;
	}
}
