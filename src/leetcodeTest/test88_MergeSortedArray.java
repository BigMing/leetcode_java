package leetcodeTest;

public class test88_MergeSortedArray {
	/*
	 * Example:Input:nums1 = [1,2,3,0,0,0],m = 3,nums2 = [2,5,6],n = 3
	 * Output: [1,2,2,3,5,6]
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (n == 0)
			return;

		if (m == 0 && n != 0) {
			for (int i = 0; i < n; i++) {
				nums1[i] = nums2[i];
			}
		}

		int i = m - 1; // num1最大下标
		int j = n - 1; // num2最大下标
		int k = m + n - 1; // 组合后的最大下标

		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) { // 分别从num1和num2最后的元素开始向前比较
				nums1[k] = nums1[i]; // 如果num1[i]较大，将num1[i]值放在num1和num2组合后的最后位置
				i--; // i左移1位
			} else {
				nums1[k] = nums2[j];
				j--;
			}
			k--;
		}
		
		while (i >= 0) { // 说明数组num1长度大于数组num2，需将其剩余元素追加上
			nums1[k] = nums1[i];
			i--;
			k--;
		}

		while (j >= 0) {
			nums1[k] = nums2[j];
			j--;
			k--;
		}
	}
}
