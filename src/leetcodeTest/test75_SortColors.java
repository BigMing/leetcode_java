package leetcodeTest;

public class test75_SortColors {
	/*
	 * Example:Input: [2,0,2,1,1,0],Output: [0,0,1,1,2,2]
	 */
	public void sortColors(int[] nums) {
		int i = 0;
		int j = 0;
		int k = 0;
		for (int p = 0; p < nums.length; p++) {
			if (nums[p] == 0) {
				i++;
			} else if (nums[p] == 1) {
				j++;
			} else
				k++;
		}

		for (int p = 0; p < nums.length; p++) {
			if (p < i)
				nums[p] = 0;
			else if (p >= i && p < i + j)
				nums[p] = 1;
			else
				nums[p] = 2;
		}
	}
}
