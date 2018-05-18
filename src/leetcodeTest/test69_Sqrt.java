package leetcodeTest;

/*
 * ���ַ���𰸵Ĺ��̾��ǲ´𰸺ʹ�֮��Ĺ�ϵ��Ȼ�󲻶ϱƽ�
 * ����ŵķ�����ת������ƽ������ת���ɲ���ʽ����x^2 <= y
 */
public class test69_Sqrt {
	/*
	 * Example 1:Input: 4,Output: 2
	 * Example 2:Input: 8,Output: 2
	 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
	 */
	/*
	 * �ж�x��ƽ���Ƿ�С��y
	 */
	public static boolean guess(long x, long y) {
		return x * x <= y; // ����x��ƽ�����ܻ�Խ�磬����ת����long��
	}
	
	public static int mySqrt(int y) {
		long L = 0, R = (long) y + 1; // ��������޺��ҽ���
		long ans = 0;
		while (L < R) {
			long mid = (L + R) / 2;
			if (guess(mid, y)) {
				ans = mid; // ��¼�´𰸣���ֹ��ѭ��
				L = mid + 1; // ע�����ﲻ��1�Ļ����޷�����ѭ��
			} else {
				R = mid;
			}
		}
		return (int) ans;
	}
	
	public static void main(String[] args) {
		System.out.println(mySqrt(10));
	}
}
