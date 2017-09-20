package leetcodeTest;

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
}
