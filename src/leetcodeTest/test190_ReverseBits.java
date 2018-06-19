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
	 * ֻ��Դ����������n����32������λ��ÿ����λ&1�Ľ��Ϊ1��˵����λΪ1��
	 * ��ʱ���������Ŀ������(Ĭ��ֵΪ0)���ƶ�һλ������1��ÿ����λ&1�Ľ��Ϊ0��
	 * ˵����λΪ0����ʱ���������Ŀ����������һλ���ɣ�ѭ��ֱ���ƶ���32�Σ�����Ŀ��������Ϊ����
	 */
	public static int reverseBits(int n) {
		int value = 0;
		// 32λ�޷�����
		for (int i = 0; i < 32; ++i) {
			if ((n & 1) == 1) {
				value = (value << 1) + 1; // ���ƶ�
				n >>= 1;
			} else {
				value = value << 1;
				n >>= 1; // ����
			}
		}
		// >>= ���Ƹ�ֵ
		// >>>= ���Ƹ�ֵ����߿ճ���λ��0���
		return value;
	}

	public static void main(String[] args) {
		System.out.println(reverseBits(8));
	}
}
