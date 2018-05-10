package leetcodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test15_3Sum {
	/*
	 * Given array nums = [-1, 0, 1, 2, -1, -4],
	 * A solution set is: [[-1, 0, 1],[-1, -1, 2]]
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Set<Integer> set = new HashSet<Integer>();
		Arrays.sort(nums); // 先排序，升序
		for (int i = 0; i < nums.length - 2; i++) {
			if (!set.add(nums[i])) // 加入set，如果有重复就跳过
				continue; // 这一步使得遍历的每个nums[i]都是不同的
			if (nums[i] > 0) // 如果nums[i]大于0，就没有再判断的必要了
				break; // 因为已经升序排序了，后面的数会更大，不可能再出现和为0
			int head = i + 1;
			int tail = nums.length - 1;
			int last = nums[head]; // 记录last避免重复
			while (head < tail) {
				if (head != i + 1 && nums[head] == last) {
					head++;
					continue;
				}
				int sum = nums[i] + nums[head] + nums[tail]; // 取i,head,tail三个数
				if (sum > 0)
					tail--;
				else if (sum < 0) {
					last = nums[head];
					head++;
				} else { // sum == 0时
					List<Integer> arrayList = new ArrayList<Integer>();
					arrayList.add(nums[i]);
					arrayList.add(nums[head]);
					arrayList.add(nums[tail]);
					ans.add(arrayList);
					last = nums[head];
					head++;
					tail--;
				}
			}
		}
		return ans;
	}
}
