package leetcodeTest;

public class test26_RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums == null)
			return 0;
		int res = 0;
		int[] p = nums;
		for (int i = 1; i < nums.length; i++) {
			if (p[i] == nums[res]) {
				// 0, 0; 1, 0; ...
			} else {
				nums[++res] = p[i];
			}
		}
		return res + 1;
	}
}
