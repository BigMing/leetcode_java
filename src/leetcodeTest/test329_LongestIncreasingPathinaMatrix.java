package leetcodeTest;

public class test329_LongestIncreasingPathinaMatrix {
	/*
	 * Given an integer matrix, find the length of the longest increasing path.
	 * 
	 * From each cell, you can either move to four directions: left, right, up
	 * or down. You may NOT move diagonally or move outside of the boundary
	 * (i.e. wrap-around is not allowed).
	 */
	public int n, m;

	// ��[x][y]��������Զ�����߶��ٲ�
	public int robot(int x, int y, int[][] mat, int[][] cache) {
		if (cache[x][y] != 0) { // ֮ǰ������[x][y]����㣬��ʡ��������
			return cache[x][y];
		}
		int max = 0;
		for (int dx = -1; dx <= 1; dx++) {
			for (int dy = -1; dy <= 1; dy++) {
				if (Math.abs(dx + dy) == 1) { // �����ĸ�����
					if (x + dx < n && x + dx >= 0 && y + dy < m && y + dy >= 0) { // ��Խ��
						if (mat[x][y] > mat[x + dx][y + dy]) { // ��һ�������ڣ�С�ڣ���ǰ��
							// ����һ����������������Զ���߶�Զ
							max = Math.max(max, robot(dx + x, dy + y, mat, cache));
						}
					}
				}
			}
		}
		cache[x][y] = max + 1;
		return cache[x][y]; // ������ĸ�����δ�����������ߵ�ͷ��������1
	}

	public int longestIncreasingPath(int[][] matrix) {
		n = matrix.length;
		if (n == 0) {
			return 0;
		}
		m = matrix[0].length;
		int[][] cache = new int[n][m]; // ��¼���Ѿ�������ĵ���Զ���߶�Զ������Ϳ��Լ��ټ�����
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ans = Math.max(ans, robot(i, j, matrix, cache));
			}
		}
		return ans;
	}
}
