package leetcodeTest;

public class test34_SearchforaRange {
	public int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
		int l = 0, len = nums.length, r = len - 1, mid = 0;
		while (l <= r) {
			mid = (l + r) >> 1; // 除以二
			if (nums[mid] == target)
				break;
			else if (nums[mid] > target)
				r = mid - 1;
			else
				l = mid + 1;
		} // 找打一个目标，可能是几个目标中间的那个
		if (l <= r) {
			l = mid - 1;
			while (l >= 0 && nums[l] == nums[mid])
				l--;
			r = mid + 1;
			while (r < len && nums[r] == nums[mid])
				r++;
			res[0] = l + 1;
			res[1] = r - 1;
		} else { // 没找到目标
			res[0] = -1;
			res[1] = -1;
		}
		return res;
	}
}
