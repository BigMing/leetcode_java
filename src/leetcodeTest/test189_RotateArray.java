package leetcodeTest;

import java.util.Arrays;

public class test189_RotateArray {
	/*
	 * Example 1:
	 * 
	 * Input: [1,2,3,4,5,6,7] and k = 3 Output: [5,6,7,1,2,3,4] Explanation:
	 * rotate 1 steps to the right: [7,1,2,3,4,5,6] rotate 2 steps to the right:
	 * [6,7,1,2,3,4,5] rotate 3 steps to the right: [5,6,7,1,2,3,4] Example 2:
	 * 
	 * Input: [-1,-100,3,99] and k = 2 Output: [3,99,-1,-100] Explanation:
	 * rotate 1 steps to the right: [99,-1,-100,3] rotate 2 steps to the right:
	 * [3,99,-1,-100]
	 */
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length <= 1)
			return;
		k %= nums.length;
		if (k == 0)
			return;
		helper(nums, 0, nums.length - 1);
		helper(nums, 0, k - 1);
		helper(nums, k, nums.length - 1);
	}

	public void helper(int[] nums, int start, int end) {
		for (int i = start; i <= (end + start) / 2; i++) {
			int temp = nums[end + start - i];
			nums[end + start - i] = nums[i];
			nums[i] = temp;
		}
	}

	public void rotate1(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		int[] temp = Arrays.copyOfRange(nums, 0, n - k);
		System.arraycopy(nums, n - k, nums, 0, k);
		System.arraycopy(temp, 0, nums, k, n - k);
	}

}
