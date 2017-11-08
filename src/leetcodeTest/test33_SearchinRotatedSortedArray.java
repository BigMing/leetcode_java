package leetcodeTest;

public class test33_SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int mid;
        while (start <= end) {
			mid = (start + end) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] >= nums[start]) { // �м�Ԫ�ش��������Ԫ�����󲿷�Ϊ��������
				if (target >= nums[start] && target <= nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else { // �м�Ԫ��С�������Ԫ�����Ҳ���Ϊ��������
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
