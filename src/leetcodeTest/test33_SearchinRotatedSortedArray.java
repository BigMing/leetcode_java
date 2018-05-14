package leetcodeTest;

public class test33_SearchinRotatedSortedArray {
	/*
	 * Example 1:Input: nums = [4,5,6,7,0,1,2], target = 0,Output: 4
	 * Example 2:Input: nums = [4,5,6,7,0,1,2], target = 3,Output: -1
	 */
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int mid;
        while (start <= end) {
			mid = (start + end) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] >= nums[start]) { // 中间元素大于最左边元素则左部分为有序数组
				if (target >= nums[start] && target <= nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else { // 中间元素小于最左边元素则右部分为有序数组
				if (target <= nums[end] && target >= nums[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
        return -1;
    }
}
