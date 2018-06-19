package leetcodeTest;

import java.util.PriorityQueue;

public class test215_KthLargestElementinanArray {
	/*
	 * Example 1:
	 * 
	 * Input: [3,2,1,5,6,4] and k = 2 Output: 5 Example 2:
	 * 
	 * Input: [3,2,3,1,2,4,5,5,6] and k = 4 Output: 4
	 */
	int maxSize;

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(); // 优先队列无限制
		if (k <= 0)
			return 0;
		maxSize = k;
		for (int i = 0; i < nums.length; i++) {
			if (queue.size() < maxSize)
				queue.offer(nums[i]);
			else { // >=
				int top = queue.peek();
				if (top < nums[i]) {
					queue.poll();
					queue.offer(nums[i]);
				}
			}
		}
		return queue.peek();
	}

	public int findKthLargest1(int[] nums, int k) {
		return quickSort(0, nums.length - 1, nums, k);
	}

	public int quickSort(int low, int high, int[] temp, int k) {
		if (low >= high)
			return temp[low]; // 递归结束的约束条件
		int point = partition(low, high, temp); // 每一次分割后“轴”的下标

		if (temp.length - point == k) {
			return temp[point]; // 快排中间位置已确定
		} else if (temp.length - point > k) { // 二分
			return quickSort(point + 1, high, temp, k);
		} else {
			return quickSort(low, point - 1, temp, k);
		}
	}

	public int partition(int low, int high, int[] temp) { // 分治
		int cur = temp[low];
		while (low < high) {
			while (low < high && temp[high] >= cur)
				--high;
			temp[low] = temp[high];
			while (low < high && temp[low] <= cur)
				++low;
			temp[high] = temp[low];
		}
		temp[low] = cur;
		return low;
	}
}
