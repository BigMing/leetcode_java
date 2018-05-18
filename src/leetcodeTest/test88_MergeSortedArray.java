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

		int i = m - 1; // num1����±�
		int j = n - 1; // num2����±�
		int k = m + n - 1; // ��Ϻ������±�

		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) { // �ֱ��num1��num2����Ԫ�ؿ�ʼ��ǰ�Ƚ�
				nums1[k] = nums1[i]; // ���num1[i]�ϴ󣬽�num1[i]ֵ����num1��num2��Ϻ�����λ��
				i--; // i����1λ
			} else {
				nums1[k] = nums2[j];
				j--;
			}
			k--;
		}
		
		while (i >= 0) { // ˵������num1���ȴ�������num2���轫��ʣ��Ԫ��׷����
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
