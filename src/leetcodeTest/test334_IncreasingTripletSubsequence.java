package leetcodeTest;

public class test334_IncreasingTripletSubsequence {
	/*
	 * Given an unsorted array return whether an increasing subsequence of
	 * length 3 exists or not in the array.
	 * 
	 * Formally the function should: Return true if there exists i, j, k such
	 * that arr[i] < arr[j] < arr[k] given 0 �� i < j < k �� n-1 else return
	 * false. Your algorithm should run in O(n) time complexity and O(1) space
	 * complexity.
	 * 
	 * Examples: Given [1, 2, 3, 4, 5], return true.
	 * 
	 * Given [5, 4, 3, 2, 1], return false.
	 */
	public boolean increasingTriplet(int[] nums) {
		// ��¼ĿǰΪֹ��С������
		int min = Integer.MAX_VALUE;
		// ��¼ĿǰΪֹ�ڶ�С������
		int min2 = Integer.MAX_VALUE;
		for (int n : nums) {
			// min��С������
			if (n <= min)
				min = n;
			// n>min,���Ǳ�min2С������
			else if (n <= min2)
				min2 = n;
			else
				// n>min2>min����true
				return true;
		}
		return false;
	}
}
