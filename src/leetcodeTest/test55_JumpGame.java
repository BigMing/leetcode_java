package leetcodeTest;

public class test55_JumpGame {
	/*
	 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
	 * Each element in the array represents your maximum jump length at that position.
	 * Determine if you are able to reach the last index.
	 */
	/*
	 * Example 1:Input: [2,3,1,1,4],Output: true
	 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
	 * Example 2:Input: [3,2,1,0,4],Output: false
	 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
	 */
    public boolean canJump(int[] nums) {
        int size = nums.length;
        if (size <= 0) {
			return false;
		}
        int maxJump = -1;
        for (int i = 0; i < size; i++) {
        	if (nums[i] > maxJump) {
				maxJump = nums[i];
			}
        	if (maxJump >= size -i - 1) {
				return true;
			}
        	if (maxJump == 0) {
				return false;
			}
        	maxJump--;
        }
        return false;
    }
}
