package leetcodeTest;

public class test239_SlidingWindowMaximum {
	/*
	 * Example:
	 * 
	 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3 Output: [3,3,5,5,6,7]
	 * Explanation:
	 * 
	 * Window position Max
	 * 
	 * [1 3 -1] -3 5 3 6 7 3
	 * 
	 * 1 [3 -1 -3] 5 3 6 7 3
	 * 
	 * 1 3 [-1 -3 5] 3 6 7 5
	 * 
	 * 1 3 -1 [-3 5 3] 6 7 5
	 * 
	 * 1 3 -1 -3 [5 3 6] 7 6
	 * 
	 * 1 3 -1 -3 5 [3 6 7] 7
	 */
	/*
	 * 首先判断数组的长度len与k的大小，如果len<=k，则，只要找出数组nums中最大的那个值，直接返回就可以了。如果len>k的话，
	 * 则定义一个数组data，其长度为len-k+1。然后对于原数组nums从下标0开始扫描，扫描到第len-k+1个元素停止。指针每次指向一个元素时，
	 * 设该元素下标为begin，它的窗口的最后一个元素的下标设置为end。然后在[begin,end]中找到最大的元素，把该元素放在data[]里面，
	 * 每次移动都按照上述操作，最后返回data。
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[0]; // 直接返回0；
		}
		int len = nums.length;
		int temp = Integer.MIN_VALUE;
		if (len <= k) { // 如果数组的长度小于等于k，只要返回数组中最大值就好
			int[] data = new int[1];
			for (int i = 0; i < len; i++) {
				if (temp < nums[i]) {
					temp = nums[i];
				}
			}
			data[0] = temp;
			return data;
		} else { // 当len的值大于k时
			int[] data = new int[len - k + 1];
			for (int i = 0; i <= len - k + 1; i++) {
				temp = Integer.MIN_VALUE;
				int begin = i;
				int end = i + k;
				if (end <= len) {
					for (int j = begin; j < end; j++) {
						if (temp < nums[j]) {
							temp = nums[j];
						}
					}
					data[i] = temp;
				} else { // end > len
					i = len; // 跳出
				}

			}
			return data;
		}
	}
}
