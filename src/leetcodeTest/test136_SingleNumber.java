package leetcodeTest;

public class test136_SingleNumber {
	/*
	 * Given a non-empty array of integers, every element appears twice except
	 * for one. Find that single one.
	 */
	public int singleNumber(int[] nums) { // 使用异或运算。
		if (nums == null || nums.length < 1) {
			throw new IllegalArgumentException("nums");
		}
		for (int i = 1; i < nums.length; i++) {
			nums[0] ^= nums[i];
		}
		return nums[0];
	}
}
