package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test78_Subsets {
	/*
	 * Input: nums = [1,2,3]
	 * Output:[[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		dfs(res, temp, nums, 0);
		return res;
	}

	// 基本深度优先递归方法
	private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int j) {
		res.add(new ArrayList<Integer>(temp)); // 先加入结果也是可以的
		for (int i = j; i < nums.length; i++) {
			temp.add(nums[i]); // ① 加入 nums[i]
			dfs(res, temp, nums, i + 1); // ② 递归
			temp.remove(temp.size() - 1); // ③ 移除 nums[i]
		}
	}
	
	// 组合
	public List<List<Integer>> subsets1(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		for (int num : nums) { // ①从数组中取出每个元素
			int size = res.size(); // 前面先加个了一个空的，所以是从1开始
			for (int i = 0; i < size; i++) {
				List<Integer> temp = new ArrayList<>(res.get(i)); // ②逐一取出中间结果集
				temp.add(num); // ③将 num 放入中间结果集
				res.add(temp); // ④加入到结果集中
			}
		}
		return res;
	}
	
	public static boolean v[] = new boolean[100];
	public static List<List<Integer>> ans = new ArrayList<List<Integer>>();
	public void robot(int idx, int[] nums) {
		if (idx >= nums.length) {
			List<Integer> r = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				if (v[i]) {
					r.add(nums[i]);
				}
			}
			ans.add(r);
			return;
		}
		v[idx] = true;
		robot(idx + 1, nums);
		v[idx] = false;
		robot(idx + 1, nums);
	}
	
	public List<List<Integer>> subsets2(int[] nums) {
		ans.clear();
		robot(0, nums);
		return ans;
	}
}
