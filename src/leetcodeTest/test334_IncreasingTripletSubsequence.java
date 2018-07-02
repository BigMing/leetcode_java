package leetcodeTest;

public class test334_IncreasingTripletSubsequence {
	/*
	 * Given an unsorted array return whether an increasing subsequence of
	 * length 3 exists or not in the array.
	 * 
	 * Formally the function should: Return true if there exists i, j, k such
	 * that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return
	 * false. Your algorithm should run in O(n) time complexity and O(1) space
	 * complexity.
	 * 
	 * Examples: Given [1, 2, 3, 4, 5], return true.
	 * 
	 * Given [5, 4, 3, 2, 1], return false.
	 */
	public boolean increasingTriplet(int[] nums) {
		// 记录目前为止最小的数字
		int min = Integer.MAX_VALUE;
		// 记录目前为止第二小的数字
		int min2 = Integer.MAX_VALUE;
		for (int n : nums) {
			// min最小的数字
			if (n <= min)
				min = n;
			// n>min,但是比min2小，更新
			else if (n <= min2)
				min2 = n;
			else
				// n>min2>min返回true
				return true;
		}
		return false;
	}
}
