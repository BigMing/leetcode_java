package leetcodeTest;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * 除了和边界有接触的’O'的区域，其他的‘O'的区域都会变成'X'。 所以扫描一遍边界，对于在边界上的’O', 通过BFS标记与它相邻的'O'。
 * 扫描完成后将未标记的‘O'替换为’X'
 */
public class test130_SurroundedRegions {
	/*
	 * Surrounded regions shouldn’t be on the border, which means that any 'O'
	 * on the border of the board are not flipped to 'X'. Any 'O' that is not on
	 * the border and it is not connected to an 'O' on the border will be
	 * flipped to 'X'. Two cells are connected if they are adjacent cells
	 * connected horizontally or vertically.
	 */
	int x;
	int y;

	public void solve1(char[][] board) {
		if (board.length <= 0) {
			return;
		}
		x = board.length;
		y = board[0].length;
		for (int i = 0; i < x; i++) { // 遍历边界
			if (board[i][0] == 'O') {
				DFS(i, 0, board);
			}
			if (board[i][y - 1] == 'O') {
				DFS(i, y - 1, board);
			}
		}
		for (int i = 0; i < y; i++) {
			if (board[0][i] == 'O') {
				DFS(0, i, board);
			}
			if (board[x - 1][i] == 'O') {
				DFS(x - 1, i, board);
			}
		}
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (board[i][j] == 'O') { // 未与边界O相连的O被换为X
					board[i][j] = 'X';
				}
				if (board[i][j] == 'm') {
					board[i][j] = 'O';
				}
			}
		}
		// 需要去掉冗余，可以通过
	}

	private void DFS(int i, int j, char[][] board) {
		if (i < 0 || i >= x || j < 0 || j >= y) { // 越界
			return;
		}
		if (board[i][j] == 'O') { // 与边界上的O相连的O标记为m
			board[i][j] = 'm';
		} else {
			return;
		} // 直接搜索有变态的测试用例会栈溢出
		DFS(i, j + 1, board);
		DFS(i, j - 1, board);
		DFS(i + 1, j, board);
		DFS(i - 1, j, board);
	}

	// 非递归实现BFS，不会栈溢出
	public void solve(char[][] board) {
		if (board == null || board.length <= 1 || board[0].length <= 1) {
			return;
		}
		int row = board.length;
		int colum = board[0].length;
		Queue<int[]> queue = new ArrayDeque<>(); // 用队列存边界上值为O的点
		for (int i = 0; i < colum - 1; i++) {
			if (board[0][i] == 'O') {
				int[] temp = new int[2];
				temp[0] = 0;
				temp[1] = i;
				queue.add(temp);
			}
		}
		for (int i = 0; i < row - 1; i++) {
			if (board[i][colum - 1] == 'O') {
				int[] temp = new int[2];
				temp[0] = i;
				temp[1] = colum - 1;
				queue.add(temp);
			}
		}
		for (int i = colum - 1; i >= 1; i--) {
			if (board[row - 1][i] == 'O') {
				int[] temp = new int[2];
				temp[0] = row - 1;
				temp[1] = i;
				queue.add(temp);
			}
		}
		for (int i = row - 1; i >= 1; i--) {
			if (board[i][0] == 'O') {
				int[] temp = new int[2];
				temp[0] = i;
				temp[1] = 0;
				queue.add(temp);
			}
		}

		while (!queue.isEmpty()) {
			int[] a = queue.poll();
			int x = a[0];
			int y = a[1];
			if (board[x][y] == 'X' || board[x][y] == 'i') {
				continue;
			}
			board[x][y] = 'i'; // 与边界的O有关的O设置为i，BFS
			if (x - 1 >= 0 && board[x - 1][y] == 'O') {
				int[] temp = new int[2];
				temp[0] = x - 1;
				temp[1] = y;
				queue.add(temp);
			}
			if (x + 1 < row && board[x + 1][y] == 'O') {
				int[] temp = new int[2];
				temp[0] = x + 1;
				temp[1] = y;
				queue.add(temp);
			}
			if (y - 1 >= 0 && board[x][y - 1] == 'O') {
				int[] temp = new int[2];
				temp[0] = x;
				temp[1] = y - 1;
				queue.add(temp);
			}
			if (y + 1 < colum && board[x][y + 1] == 'O') {
				int[] temp = new int[2];
				temp[0] = x;
				temp[1] = y + 1;
				queue.add(temp);
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < colum; j++) {
				if (board[i][j] == 'X') {
					continue;
				} else {
					if (board[i][j] == 'i') {
						board[i][j] = 'O';
					} else {
						board[i][j] = 'X';
					}
				}
			}
		}
	}
}
