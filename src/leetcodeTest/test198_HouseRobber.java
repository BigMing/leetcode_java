package leetcodeTest;

public class test198_HouseRobber {
	public static int[] result;
	/**
	 * 自顶向下式的，
	 * 也可以自底向上，从idx=0开始
	 * @param idx 第几家店
	 */
	public int solve(int idx, int[] nums) {
		if (idx < 0) {
			return 0;
		}
		if (result[idx] >= 0) { // 如果计算过
			return result[idx];
		}
		result[idx] = Math.max(nums[idx] + solve(idx - 2, nums), solve(idx - 1, nums));
		return result[idx];
	}
	
    public int rob(int[] nums) {
    	if (nums.length == 0) {
    		return 0;
    	}
    	if (nums.length == 1) {
    		return nums[0];
    	}
    	result = new int[nums.length];
    	result[0] = nums[0];
    	result[1] = Math.max(nums[0], nums[1]);
//    	for (int i = 0; i < nums.length; i++) {
//    		result[i] = -1;
//    	}
    	for (int idx = 2; idx < nums.length; idx++) {
    		result[idx] = Math.max(nums[idx] + result[idx - 2], result[idx - 1]);
    	}
    	return result[nums.length - 1]; // 改成递推的方式
    }
}
