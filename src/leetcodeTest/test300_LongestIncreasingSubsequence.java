package leetcodeTest;

public class test300_LongestIncreasingSubsequence {
	/*
	 * Given an unsorted array of integers, find the length of longest
	 * increasing subsequence.
	 * 
	 * Example:
	 * 
	 * Input: [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest
	 * increasing subsequence is [2,3,7,101], therefore the length is 4.
	 */
	public int lengthOfLIS(int[] nums) {
		// [10, 2, 5, 3, 7],
		if (nums == null || nums.length < 1)
			return 0;

		int[] d = new int[nums.length];
		d[0] = 1;
		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) { // i大于前面的j
					d[i] = Math.max(d[i], d[j] + 1); // d[i] 为 subset 0...i
														// 的最大Longest increasing
														// sub.
				}
			}
			max = Math.max(max, d[i]);
		}
		return max;
	}

	// O(NlgN)
	public int lengthOfLIS1(int[] nums) {
		int len = 0;
		int[] a = new int[nums.length];
		for (int val : nums) { // 遍历每个数
			int index = binary(a, 0, len - 1, val); // 每个数的顺序位置，排序
			a[index] = val;
			if (len == index) // 说明这个数字是新加进去这个数组的
				len++;
		}
		return len;
	}

	// 相当于在left-right的区间内找到val的插入位置。保证升序；
	public int binary(int[] a, int left, int right, int val) {
		while (left <= right) {
			int mid = getMid(left, right);
			if (a[mid] >= val) {
				right = mid - 1;
			} // 相等也要替换这个值;
			else {
				left = mid + 1;
			}
		}
		return left;
	}

	public int getMid(int left, int right) {
		return left + (right - left) / 2;
	}

}
