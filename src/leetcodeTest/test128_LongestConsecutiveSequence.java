package leetcodeTest;

import java.util.HashSet;

public class test128_LongestConsecutiveSequence {
	/*
	 * Given an unsorted array of integers, find the length of the longest
	 * consecutive elements sequence.Your algorithm should run in O(n)
	 * complexity. Example: Input: [100, 4, 200, 1, 3, 2] Output: 4 Explanation:
	 * The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its
	 * length is 4.
	 */
	public int longestConsecutive(int[] nums) {
		HashSet<Integer> sets = new HashSet<>();
		for (int i = 0; i < nums.length; i++)
			sets.add(nums[i]);
		int max = 0;
		int count;
		for (int i = 0; i < nums.length; i++) {
			count = 0;
			int val = nums[i];
			int valTmp = val;
			while (sets.contains(valTmp)) { // ÍùÓÒ
				count++;
				sets.remove(val);
				valTmp++;
			}
			while (sets.contains(val - 1)) { // Íù×ó
				count++;
				sets.remove(val - 1);
				val--;
			}
			if (count > max)
				max = count;
		}
		return max;
	}
}
