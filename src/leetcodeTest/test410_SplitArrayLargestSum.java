package leetcodeTest;

public class test410_SplitArrayLargestSum {
	/**
	 * 把数组分成m个部分，使得每个部分最大的和最小
	 * @param nums
	 * @param m
	 * @return
	 */
	public static int splitArray(int[] nums, int m) {
		// 第一步，设置左右界限
		long R = 1; // 上界是全部的和，右边是开区间
		for (int i = 0; i < nums.length; i++) {
			R += nums[i];
		}
		long L = 0; // 下界是0
		long ans = 0;
		// 第二步
		while (L < R) {
			long mid = (L + R) / 2;
			if (guess(mid, nums, m)) {
				ans = mid;
//				L = mid + 1;
				R = mid;
			} else {
//				R = mid;
				L = mid + 1;
			}
		}
		return (int) ans;
	}

	/**
	 * @param mid 数组的部分和
	 * @param nums 数组
	 * @param m 需要分成m个部分
	 * @return 当和最大值为mid的时候，此时是否合格
	 */
	private static boolean guess(long mid, int[] nums, int m) {
		long sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (sum + nums[i] > mid) {
				m--; // 一个部分的和超过mid了
				sum = nums[i]; // 新开辟一个部分，nums[i]是第一个值
				if (nums[i] > mid) {
					return false;
				}
			} else {
				sum += nums[i];
			}
		}
		return m >= 1; // 留一组给sum用
	}
}
