package leetcodeTest;

public class test4_MedianofTwoSortedArrays {
	 // �鲢����
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        if (m == 0) { // ���num1�ǿ�����
			if (n % 2 != 0) { // num2�ĳ���Ϊ����
				return 1.0 * nums2[n / 2]; // ����double����ʱֱ�Ӿ���num2���м��Ǹ���
			}
		}
        if (n == 0) {
        	if (m % 2 != 0) {
				return 1.0 * nums1[m / 2];
			}
		}
        
        int i = 0;
        int j = 0;
        int[] ans = new int[10000];
        int index = 0; // ���ڸ���ans���ӣ��൱��ans��ʱ�ĳ���
        
        while (i < m & j < n) { // ���ΰ����������е�����С�������ans
			if (nums1[i] <= nums2[j]) {
				ans[index] = nums1[i];
				index++;
				i++;
			} else {
				ans[index] = nums2[j];
				index++;
				j++;
			}
		}
        if (i < m) {
			for ( ; i < m; i++) {
				ans[index] = nums1[i];
				index++;
			}
		} else if (j < n) {
			for ( ; j < n; j++) {
				ans[index] = nums2[j];
				index++;
			}
		}
        if (index % 2 != 0) { // ans�ĳ����ǻ���
			return 1.0 * ans[index / 2];
		}
        return (ans[index / 2] + ans[index / 2 - 1]) / 2.0;
    }
    /*
     * ���ֲ���
     * �������a����λ��С������b����λ������ô�������λ��ֻ���ܳ�����a�����������b��������֮�У� 
     * �������a����λ�����ڵ�������b����λ������ô�������λ��ֻ���ܳ�����a�����������b��������֮�С� 
     * �ؼ��������÷��ε�˼������Сa�������b���������ҵ���λ����
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int m = nums1.length;
        int n = nums2.length;
        if (m == 0) { // ���num1�ǿ�����
			if (n % 2 != 0) { // num2�ĳ���Ϊ����
				return 1.0 * nums2[n / 2]; // ����double����ʱֱ�Ӿ���num2���м��Ǹ���
			}
		}
        if (n == 0) {
        	if (m % 2 != 0) {
				return 1.0 * nums1[m / 2];
			}
		}
        
        int total = (m + n + 1) / 2;
        int total2 = (m + n + 2) / 2;
        
        return (find_kth(nums1, 0, nums2, 0, total) + find_kth(nums1, 0, nums2, 0, total2)) / 2.0;
    }

	private double find_kth(int[] a, int a_begin, int[] b, int b_begin, int k) {
		if (a_begin > a.length - 1) {
			return b[b_begin + k - 1];
		}
		if (b_begin > b.length - 1) {
			return a[a_begin + k - 1];
		}
		if (k == 1) {
			return Math.min(a[a_begin], b[b_begin]);
		}
		int mid_a = Integer.MAX_VALUE;
		int mid_b = Integer.MAX_VALUE;
		if (a_begin + k / 2 - 1 < a.length) {
			mid_a = a[a_begin + k / 2 - 1];
		}
		if (b_begin + k / 2 - 1 < b.length) {
			mid_b = b[b_begin + k / 2 - 1];
		}
		if (mid_a < mid_b) {
			return find_kth(a, a_begin + k / 2, b, b_begin, k - k / 2);
		}
		return find_kth(a, a_begin, b, b_begin + k / 2, k - k / 2);
	}
}
