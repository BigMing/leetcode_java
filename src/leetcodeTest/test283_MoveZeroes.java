package leetcodeTest;

public class test283_MoveZeroes {
	/*
	 * Given an array nums, write a function to move all 0's to the end of it
	 * while maintaining the relative order of the non-zero elements.
	 * 
	 * Example:
	 * 
	 * Input: [0,1,0,3,12] Output: [1,3,12,0,0]
	 */
	/*
	 * 维护两个指针，i j，i指向nums的第一个0，j指向第一个非零数
	 */
	public void moveZeroes(int[] nums) {
		int i = 0;
		int j = 0;
		while (j < nums.length) {
			if (nums[j] != 0) {
				if (i != j) { // i指向0
					nums[i++] = nums[j];
					nums[j] = 0;
				} else {
					++i;
				}
			}
			++j; // 跳过0
		}
	}

	// 用一个值保存当前遍历到的非零元素数量，并将第i个元素赋值给数组下标为i－1的元素。这样后面剩下的位置，都赋值为0即可满足题目的要求。
	public void moveZeroes1(int[] nums) {
		if (nums != null && nums.length == 0)
			return;
		int insertPost = 0;
		for (int num : nums) {
			if (num != 0) {
				nums[insertPost++] = num;
			}
		}
		while (insertPost < nums.length) {
			nums[insertPost++] = 0;
		}
	}
}
