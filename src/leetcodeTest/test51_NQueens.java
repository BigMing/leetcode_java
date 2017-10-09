package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test51_NQueens {
	public static List<List<String>> ans = new ArrayList<List<String>>();
	public static int path[] = new int[100]; // 记录皇后的位置在哪里，一列上最多只有一个皇后，记录某一列的皇后位置下标就可以了
	public static boolean zheng[] = new boolean[100]; // 斜线
	public static boolean fan[] = new boolean[100];
	public static boolean hang[] = new boolean[100];
	
	public void dfs(int idx ,int n) {
		if (idx >= n) { // 边界条件+记录
			List<String> chess = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				String tmp = "";
				for (int j = 0; j < n; j++) {
					if (j == path[i]) {
						tmp += "Q";
					} else {
						tmp += ".";
					}
				}
				chess.add(tmp);
			}
			ans.add(chess);
			return;
		}
		for (int i = 0; i < n; i++) { // 递归主要部分，一行一行回溯
			if (!hang[i] && 
					!zheng[idx + i] && // 正反斜线
					!fan[idx - i + n - 1]) { // 下标不能为负
				path[idx] = i;
				hang[i] = true;
				zheng[idx + i] = true;
				fan[idx - i + n - 1] = true;
				dfs(idx + 1, n);
				hang[i] = false;
				zheng[idx + i] = false;
				fan[idx - i + n - 1] = false;
			}
		}
	}
	
    public List<List<String>> solveNQueens(int n) {
    	ans.clear();
        dfs(0, n);
        return ans;
    }
}
