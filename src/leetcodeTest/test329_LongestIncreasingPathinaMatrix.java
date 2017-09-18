package leetcodeTest;

public class test329_LongestIncreasingPathinaMatrix {
	public int n, m;
	// 从[x][y]出发，最远可以走多少步
	public int robot(int x, int y, int[][] mat, int[][] cache) {
		if (cache[x][y] != 0) { // 之前遍历过[x][y]这个点，节省后续计算
			return cache[x][y];
		}
		int max = 0;
		for (int dx = -1; dx <= 1; dx++) {
			for (int dy = -1; dy <= 1; dy++) {
				if (Math.abs(dx + dy) == 1) { // 产生四个方向
					if (x + dx < n && x + dx >= 0 && y + dy < m && y + dy >= 0) { // 不越界
						if (mat[x][y] > mat[x + dx][y + dy]) { // 下一个数大于（小于）当前数
							// 从下一个数出发继续找最远能走多远
							max = Math.max(max, robot(dx + x, dy + y, mat, cache));
						}
					}
				}
			}
		}
		cache[x][y] = max + 1;
		return cache[x][y]; // 这个数四个方向都未满足条件（走到头），返回1
	}
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        if (n == 0) {
        	return 0;
        }
        m = matrix[0].length;
        int[][] cache = new int[n][m]; // 记录下已经计算过的点最远能走多远，后面就可以减少计算量
        int ans = 0;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		ans = Math.max(ans, robot(i, j, matrix, cache));
        	}
        }
        return ans;
    }
}
