package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test51_NQueens {
	public static List<List<String>> ans = new ArrayList<List<String>>();
	public static int path[] = new int[100]; // ��¼�ʺ��λ�������һ�������ֻ��һ���ʺ󣬼�¼ĳһ�еĻʺ�λ���±�Ϳ�����
	public static boolean zheng[] = new boolean[100]; // б��
	public static boolean fan[] = new boolean[100];
	public static boolean hang[] = new boolean[100];
	
	public void dfs(int idx ,int n) {
		if (idx >= n) { // �߽�����+��¼
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
		for (int i = 0; i < n; i++) { // �ݹ���Ҫ���֣�һ��һ�л���
			if (!hang[i] && 
					!zheng[idx + i] && // ����б��
					!fan[idx - i + n - 1]) { // �±겻��Ϊ��
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
