package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test216_CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (k < 1 || n < 1)
			return res;
		List<Integer> cur = new ArrayList<Integer>();
		rec(res, cur, 0, k, n, 1);
		return res;
	}

	private void rec(List<List<Integer>> res, List<Integer> cur, int sum, int k, int n, int level) {
		if (sum == n && k == 0) {
			// 注意要新建一个list 放入结果中, 否则放入的reference会指向原来的不断变化的list,
			res.add(new ArrayList<Integer>(cur));
			return;
		} else if (sum > n || k <= 0)
			return;
		for (int i = level; i <= 9; i++) {
			cur.add(i);
			rec(res, cur, sum + i, k - 1, n, i + 1);
			cur.remove(cur.size() - 1); // 深度优先
		}
	}
}
