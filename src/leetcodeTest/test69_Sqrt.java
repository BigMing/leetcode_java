package leetcodeTest;

/*
 * 二分法求答案的过程就是猜答案和答案之间的关系，然后不断逼近
 * 求根号的反函数转换成求平方，再转换成不等式问题x^2 <= y
 */
public class test69_Sqrt {
	/*
	 * Example 1:Input: 4,Output: 2
	 * Example 2:Input: 8,Output: 2
	 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
	 */
	/*
	 * 判断x的平方是否小于y
	 */
	public static boolean guess(long x, long y) {
		return x * x <= y; // 这里x的平方可能会越界，所以转换成long型
	}
	
	public static int mySqrt(int y) {
		long L = 0, R = (long) y + 1; // 定义左界限和右界限
		long ans = 0;
		while (L < R) {
			long mid = (L + R) / 2;
			if (guess(mid, y)) {
				ans = mid; // 记录下答案，防止死循环
				L = mid + 1; // 注意这里不加1的话，无法跳出循环
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
