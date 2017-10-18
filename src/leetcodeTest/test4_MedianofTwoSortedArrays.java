package leetcodeTest;

public class test4_MedianofTwoSortedArrays {
	 // 归并排序
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        if (m == 0) { // 如果num1是空数组
			if (n % 2 != 0) { // num2的长度为奇数
				return 1.0 * nums2[n / 2]; // 返回double，这时直接就是num2的中间那个数
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
        int index = 0; // 用于辅助ans增加，相当与ans此时的长度
        
        while (i < m & j < n) { // 依次把两个数组中的数从小到大放入ans
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
        if (index % 2 != 0) { // ans的长度是基数
			return 1.0 * ans[index / 2];
		}
        return (ans[index / 2] + ans[index / 2 - 1]) / 2.0;
    }
    /*
     * 二分查找
     * 如果数组a的中位数小于数组b的中位数，那么整体的中位数只可能出现在a的右区间加上b的左区间之中； 
     * 如果数组a的中位数大于等于数组b的中位数，那么整体的中位数只可能出现在a的左区间加上b的右区间之中。 
     * 关键就是利用分治的思想逐渐缩小a的区间和b的区间来找到中位数。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int m = nums1.length;
        int n = nums2.length;
        if (m == 0) { // 如果num1是空数组
			if (n % 2 != 0) { // num2的长度为奇数
				return 1.0 * nums2[n / 2]; // 返回double，这时直接就是num2的中间那个数
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
