package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test39_CombinationSum {
	public static List<List<Integer>> ans = new ArrayList<>();
	public static int path[] = new int[100];
	public static int len = 0; // path的长度
	
	public void robot(int idx, int[] c, int target) {
		if (target == 0) { // 符合条件的情况，记录答案
			List<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < len; i++) {
				tmp.add(path[i]);
			}
			ans.add(tmp);
			return;
		}
		if (target < 0 || idx >= c.length) {
			return;
		}
		path[len] = c[idx];
		len++;
		robot(idx, c, target - c[idx]); // 使用当前idx的数，后面还可以用这个数
		len--; // 跳出该递归后还原一个
		robot(idx + 1, c, target); // 不使用这个数，后面也就不用了，还是深度优先
	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans.clear();
        robot(0, candidates, target);
        return ans;
    }
}
