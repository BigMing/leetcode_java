package leetcodeTest;

public class test55_JumpGame {
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
