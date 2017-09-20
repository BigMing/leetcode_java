package leetcodeTest;

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
}
