package leetcodeTest;

public class test41_FirstMissingPositive {
	/*
	 * Example 1:Input: [1,2,0],Output: 3 Example 2:Input: [3,4,-1,1],Output: 2
	 * Example 3:Input: [7,8,9,11,12],Output: 1
	 */
	/*
	 * 思路：交换数组元素，使得数组中第i位存放数值(i+1)。最后遍历数组，寻找第一个不符合此要求的元素，返回其下标。
	 * 整个过程需要遍历两次数组，复杂度为O(n)。
	 */
	public static int firstMissingPositive(int[] nums) {
		if (nums.length == 0)
			return 1;
		// 第i位存放i+1的数值
		// 3， 4， -1， 1
		// 1, 4, -1, 3
		// 1, 4, 3, -1
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) { // nums[i]为正数
				// 如果交换的数据还是大于0且<i+1，则放在合适的位置，且数据不相等，避免死循环
				// 这个while是关键，其他都是没有难度的，多次交换位置
				while (nums[i] > 0 && nums[i] < i + 1 && nums[i] != nums[nums[i] - 1]) { // 与将要交换的数不相等
//					System.out.println(nums[i] + ":" + i);
					int temp = nums[nums[i] - 1]; // 交换数据
					nums[nums[i] - 1] = nums[i];
					nums[i] = temp;
				}
			}
		}
		// 循环寻找不符合要求的数据，返回
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		// 如果都符合要求，则返回长度+1的值
		return nums.length + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, -1, 1 };
		System.out.println(firstMissingPositive(nums));
	}
}
