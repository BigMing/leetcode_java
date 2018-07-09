package leetcodeTest;

import java.util.HashMap;

public class test1_TwoSum {
	/*
	 * Example:
	 * 
	 * Given nums = [2, 7, 11, 15], target = 9,
	 * 
	 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int size = nums.length;
		for (int i = 0; i < size; i++) { // Ò»´Î±éÀú
			int curr = nums[i];
			if (!map.containsKey(curr)) {
				map.put(target - curr, i);
			} else {
				result[0] = map.get(curr);
				result[1] = i;
				break;
			}
		}
		return result;
	}
}
