package leetcodeTest;

public class test190_ReverseBits {
	/*
	 * Example:
	 * 
	 * Input: 43261596 Output: 964176192 Explanation: 43261596 represented in
	 * binary as 00000010100101000001111010011100, return 964176192 represented
	 * in binary as 00111001011110000010100101000000.
	 */
	/*
	 * 只需对待处理的整数n进行32次右移位，每当低位&1的结果为1，说明低位为1，
	 * 此时将待输出的目标整数(默认值为0)左移动一位并加上1；每当低位&1的结果为0，
	 * 说明低位为0，此时将待输出的目标整数左移一位即可；循环直到移动完32次，所得目标整数即为所求。
	 */
	public static int reverseBits(int n) {
		int value = 0;
		// 32位无符号数
		for (int i = 0; i < 32; ++i) {
			if ((n & 1) == 1) {
				value = (value << 1) + 1; // 左移动
				n >>= 1;
			} else {
				value = value << 1;
				n >>= 1; // 右移
			}
		}
		// >>= 右移赋值
		// >>>= 右移赋值，左边空出的位以0填充
		return value;
	}

	public static void main(String[] args) {
		System.out.println(reverseBits(8));
	}
}
