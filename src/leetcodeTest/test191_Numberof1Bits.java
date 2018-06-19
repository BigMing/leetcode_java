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
	 * 从最低位按位与，计数器相加即可
	 */
	public int hammingWeight1(int n) {
		int count = 0;
		while (n != 0) {
			count += n & 1;
			n >>>= 1; // >> 右移 
			// >>> 右移，左边空出的位以0填 充
		}
		return count;
	}
}
