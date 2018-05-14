package leetcodeTest;

public class test26_RemoveDuplicatesfromSortedArray {
	/*
	 * Given nums = [0,0,1,1,1,2,2,3,3,4],
	 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
	 * It doesn't matter what values are set beyond the returned length.
	 */
	public int removeDuplicates(int[] nums) {
		if (nums == null)
			return 0;
		int res = 0;
		int[] p = nums;
		for (int i = 1; i < nums.length; i++) { // 从第二个开始
			if (p[i] == nums[res]) {
				
			} else {
				nums[++res] = p[i];
			}
		}
		return res + 1;
	}
}
