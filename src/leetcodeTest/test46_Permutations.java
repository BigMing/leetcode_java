package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test46_Permutations {
	public static List<List<Integer>> ans = new ArrayList<>();
	
	public static int[] path = new int[100]; // 暂存小答案
	
	public static boolean[] v = new boolean[100];
	
	public static void robot(int idx, int nums[]) {
		if (idx >= nums.length) { // 递归第一步是边界条件判断
			// 某一个排序完成后加入答案
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				temp.add(nums[path[i]]);
			}
			ans.add(temp);
			return; // 跳出递归，进行下一个数作为开头的深度优先
		}
		// 依次用每个数作为排序的开头，递归
		for (int i = 0; i < nums.length; i++) {
			if (v[i] == false) { // 某个数还未使用时
				path[idx] = i; // path[0];
				v[i] = true; // 下标的已使用过
				robot(idx + 1, nums); // path[1]; path[2]; ...
				v[i] = false; // 跳出递归后， 深度优先
			}
		}
	}
	
    public List<List<Integer>> permute(int[] nums) {
    	ans.clear();
    	robot(0, nums);
        return ans;
    }
}
