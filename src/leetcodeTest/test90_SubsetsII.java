package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test90_SubsetsII {
	public static List<List<Integer>> ans = new ArrayList<>();
	public static boolean v[] = new boolean[100];
	
	// 重复的数要看成同样的，难度
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	ans.clear();
    	int n = nums.length;
    	// 排序，选择
    	for (int i = 0; i < n; i++) {
    		for (int j = i + 1; j < n; j++) {
    			if (nums[i] > nums[j]) {
    				int tmp = nums[i];
    				nums[i] = nums[j];
    				nums[j] = tmp;
    			}
    		}
    	}
    	robot(0, nums);
    	return ans;
    }
    
	private static void robot(int idx, int[] nums) {
		if (idx >= nums.length) {
			List<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				if (v[i]) {
					tmp.add(nums[i]);
				}
			}
			ans.add(tmp);
			return;
		}
		if (idx > 0 && nums[idx - 1] == nums[idx] && v[idx - 1] == false) {
			// 与前一个数相等，且前一个数不取
			v[idx] = false;
			robot(idx + 1, nums);
		} else {
			v[idx] = true; // v[idx]表示是否使用下标是idx的数
			robot(idx + 1, nums);
			v[idx] = false;
			robot(idx + 1, nums);
		}
	}
}
