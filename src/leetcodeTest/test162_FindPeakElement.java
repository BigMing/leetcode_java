package leetcodeTest;

public class test162_FindPeakElement {
	/*
	 * Example 1:
	 * 
	 * Input: nums = [1,2,3,1] Output: 2 Explanation: 3 is a peak element and
	 * your function should return the index number 2. Example 2:
	 * 
	 * Input: nums = [1,2,1,3,5,6,4] Output: 1 or 5 Explanation: Your function
	 * can return either index number 1 where the peak element is 2, or index
	 * number 5 where the peak element is 6.
	 */
	public int findPeakElement(int[] nums) {
		int len = nums.length, left = 0, right = len - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
}
