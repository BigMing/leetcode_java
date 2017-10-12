package leetcodeTest;

import java.awt.Checkbox;

public class test200_NumberofIslands {
	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') { // 走过的点就是0了，后面就不再走了
					search(grid, i, j);
					++count; // 所以这个直接++
				}
			}
		}
		return count;
	}

	// 每遇到'1'后, 开始向四个方向 递归搜索. 搜到后变为'0', 因为相邻的属于一个island. 然后开始继续找下一个'1'.
	private void search(char[][] grid, int x, int y) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length // 不越界
				|| grid[x][y] != '1') { // 不是1了
			return;
		}
		grid[x][y] = '0'; // 当前点设置为0，就是把走过的点设置为0，后续就不再走了
		search(grid, x - 1, y);
		search(grid, x + 1, y);
		search(grid, x, y - 1);
		search(grid, x, y + 1);
		// 四个方向都走一遍
	}
	
	
	public static int qx[] = new int[10000];
	public static int qy[] = new int[10000];
	public void floodfill(int x, int y, char[][] grid, int n, int m) {
		int h = 0;
		int r = 1; // [h, r) 队列指针
		qx[0] = x;
		qy[0] = y;
		grid[x][y] = '0';
		while (h < r) {
			r = check(qx[h] - 1, qy[h], grid, r, n, m);
			r = check(qx[h], qy[h] - 1, grid, r, n, m);
			r = check(qx[h] + 1, qy[h], grid, r, n, m);
			r = check(qx[h], qy[h] + 1, grid, r, n, m);
			++h; // 头指针右移，默认就是出队列了
		}
		
	} 
	public int check(int x, int y, char[][] grid, int r, int n, int m) {
		if (x >= 0 && x <= n && y >= 0 && y < m && grid[x][y] == '1') {
			qx[r] = x;
			qy[r] = y;
			grid[x][y] = '0';
			++r; // 入队
		}
		return r;
	}
	public int numIslands1(char[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					floodfill(0, 0, grid, n, m);
					ans++;
				}
			}
		}
		return ans;
	}
}
