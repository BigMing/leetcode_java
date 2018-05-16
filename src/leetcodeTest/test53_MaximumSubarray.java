package leetcodeTest;

public class test53_MaximumSubarray {
	/*
	 * Example:Input: [-2,1,-3,4,-1,2,1,-5,4],Output: 6
	 * Explanation: [4,-1,2,1] has the largest sum = 6.
	 */
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE; // 设置最小值
		int sum = 0; // 每一个分组的和
		int i = 0;
		while (i < nums.length) {
			sum += nums[i]; // 每一个分组的前n项和
			if (max < sum) {
				max = sum; // 记录最大和
			}
			if (sum < 0) { // 如果之前的和小于0，加上会更小就不用加了
				sum = 0;
			}
			i++;
		}
		return max;
	}
}
