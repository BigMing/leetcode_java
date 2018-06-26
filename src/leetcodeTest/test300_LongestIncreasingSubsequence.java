package leetcodeTest;

public class test300_LongestIncreasingSubsequence {
	/*
	 * Given an unsorted array of integers, find the length of longest
	 * increasing subsequence.
	 * 
	 * Example:
	 * 
	 * Input: [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest
	 * increasing subsequence is [2,3,7,101], therefore the length is 4.
	 */
	public int lengthOfLIS(int[] nums) {
		// [10, 2, 5, 3, 7],
		if (nums == null || nums.length < 1)
			return 0;

		int[] d = new int[nums.length];
		d[0] = 1;
		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) { // i����ǰ���j
					d[i] = Math.max(d[i], d[j] + 1); // d[i] Ϊ subset 0...i
														// �����Longest increasing
														// sub.
				}
			}
			max = Math.max(max, d[i]);
		}
		return max;
	}

	// O(NlgN)
	public int lengthOfLIS1(int[] nums) {
		int len = 0;
		int[] a = new int[nums.length];
		for (int val : nums) { // ����ÿ����
			int index = binary(a, 0, len - 1, val); // ÿ������˳��λ�ã�����
			a[index] = val;
			if (len == index) // ˵������������¼ӽ�ȥ��������
				len++;
		}
		return len;
	}

	// �൱����left-right���������ҵ�val�Ĳ���λ�á���֤����
	public int binary(int[] a, int left, int right, int val) {
		while (left <= right) {
			int mid = getMid(left, right);
			if (a[mid] >= val) {
				right = mid - 1;
			} // ���ҲҪ�滻���ֵ;
			else {
				left = mid + 1;
			}
		}
		return left;
	}

	public int getMid(int left, int right) {
		return left + (right - left) / 2;
	}

}
