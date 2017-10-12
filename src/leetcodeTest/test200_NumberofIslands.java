package leetcodeTest;

import java.awt.Checkbox;

public class test200_NumberofIslands {
	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') { // �߹��ĵ����0�ˣ�����Ͳ�������
					search(grid, i, j);
					++count; // �������ֱ��++
				}
			}
		}
		return count;
	}

	// ÿ����'1'��, ��ʼ���ĸ����� �ݹ�����. �ѵ����Ϊ'0', ��Ϊ���ڵ�����һ��island. Ȼ��ʼ��������һ��'1'.
	private void search(char[][] grid, int x, int y) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length // ��Խ��
				|| grid[x][y] != '1') { // ����1��
			return;
		}
		grid[x][y] = '0'; // ��ǰ������Ϊ0�����ǰ��߹��ĵ�����Ϊ0�������Ͳ�������
		search(grid, x - 1, y);
		search(grid, x + 1, y);
		search(grid, x, y - 1);
		search(grid, x, y + 1);
		// �ĸ�������һ��
	}
	
	
	public static int qx[] = new int[10000];
	public static int qy[] = new int[10000];
	public void floodfill(int x, int y, char[][] grid, int n, int m) {
		int h = 0;
		int r = 1; // [h, r) ����ָ��
		qx[0] = x;
		qy[0] = y;
		grid[x][y] = '0';
		while (h < r) {
			r = check(qx[h] - 1, qy[h], grid, r, n, m);
			r = check(qx[h], qy[h] - 1, grid, r, n, m);
			r = check(qx[h] + 1, qy[h], grid, r, n, m);
			r = check(qx[h], qy[h] + 1, grid, r, n, m);
			++h; // ͷָ�����ƣ�Ĭ�Ͼ��ǳ�������
		}
		
	} 
	public int check(int x, int y, char[][] grid, int r, int n, int m) {
		if (x >= 0 && x <= n && y >= 0 && y < m && grid[x][y] == '1') {
			qx[r] = x;
			qy[r] = y;
			grid[x][y] = '0';
			++r; // ���
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
