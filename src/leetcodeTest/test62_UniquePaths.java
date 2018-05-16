package leetcodeTest;

public class test62_UniquePaths {
	/*
	 * Example 1:Input: m = 3, n = 2,Output: 3
	 * Explanation:From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
	 * 1. Right -> Right -> Down
	 * 2. Right -> Down -> Right
	 * 3. Down -> Right -> Right
	 * Example 2:Input: m = 7, n = 3,Output: 28
	 */
	public int uniquePaths(int m, int n) {
		if (m ==0 || n == 0) {
			return 0;
		}
		int path[][] = new int[100][100];
		for (int i = 0; i < m; i++) {
			path[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			path[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				path[i][j] = path[i - 1][j] + path[i][j - 1]; // DP
			}
		}
		return path[m - 1][n - 1];
	}
}
