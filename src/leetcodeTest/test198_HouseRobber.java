package leetcodeTest;

public class test198_HouseRobber {
	/*
	 * Example 1:
	 * 
	 * Input: [1,2,3,1] Output: 4 Explanation: Rob house 1 (money = 1) and then
	 * rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4. Example 2:
	 * 
	 * Input: [2,7,9,3,1] Output: 12 Explanation: Rob house 1 (money = 2), rob
	 * house 3 (money = 9) and rob house 5 (money = 1). Total amount you can rob
	 * = 2 + 9 + 1 = 12.
	 */
	public int rob1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length > 2) { // 如果数组中的元素个个数大于2个，对于【A】式，i=2，dp[2-3]不存在
			nums[2] += nums[0];
		}
		int i = 3; // 从第四个元素开始处理
		for (; i < nums.length; i++) { // 求出第i个元素的最大值
			nums[i] += Math.max(nums[i - 2], nums[i - 3]);
		}
		if (nums.length == 1) { // 如果只有一个元素，返回这个元素值
			return nums[0];
		} else if (nums.length == 2) { // 有两个元素返回其中较大的值
			return Math.max(nums[0], nums[1]);
		} else { // 多于两个元素，最大值在末尾两个之间，找最大的返回
			return Math.max(nums[i - 1], nums[i - 2]);
		}
	}

	public static int[] result;

	/**
	 * 自顶向下式的， 也可以自底向上，从idx=0开始
	 * 
	 * @param idx
	 *            第几家店
	 */
	public int solve(int idx, int[] nums) {
		if (idx < 0) {
			return 0;
		}
		if (result[idx] >= 0) { // 如果计算过
			return result[idx];
		}
		result[idx] = Math.max(nums[idx] + solve(idx - 2, nums), solve(idx - 1, nums));
		return result[idx];
	}

	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		result = new int[nums.length];
		result[0] = nums[0];
		result[1] = Math.max(nums[0], nums[1]);
		// for (int i = 0; i < nums.length; i++) {
		// result[i] = -1;
		// }
		for (int idx = 2; idx < nums.length; idx++) {
			result[idx] = Math.max(nums[idx] + result[idx - 2], result[idx - 1]);
		}
		return result[nums.length - 1]; // 改成递推的方式
	}
}
