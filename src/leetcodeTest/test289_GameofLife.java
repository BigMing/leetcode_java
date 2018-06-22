package leetcodeTest;

public class test289_GameofLife {
	/*
	 * Given a board with m by n cells, each cell has an initial state live (1)
	 * or dead (0). Each cell interacts with its eight neighbors (horizontal,
	 * vertical, diagonal) using the following four rules (taken from the above
	 * Wikipedia article):
	 * 
	 * Any live cell with fewer than two live neighbors dies, as if caused by
	 * under-population. Any live cell with two or three live neighbors lives on
	 * to the next generation. Any live cell with more than three live neighbors
	 * dies, as if by over-population.. Any dead cell with exactly three live
	 * neighbors becomes a live cell, as if by reproduction. Write a function to
	 * compute the next state (after one update) of the board given its current
	 * state. The next state is created by applying the above rules
	 * simultaneously to every cell in the current state, where births and
	 * deaths occur simultaneously.
	 */
	public void gameOfLife(int[][] board) {
		// check input
		if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
			return;

		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) { // 遍历board
				int x = getLiveNum(board, i, j);
				if (board[i][j] == 0) { // dead的
					if (x == 3) // 3个live的邻居
						board[i][j] += 10;
				} else { // 继续存活一代
					if (x == 2 || x == 3)
						board[i][j] += 10;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] /= 10; // 下一代
			}
		}
	}

	private int getLiveNum(int[][] board, int x, int y) { // 返回live的邻居个数
		int c = 0;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) { // 前后左右
				if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || (i == x && j == y))
					continue;
				if (board[i][j] % 10 == 1) // 不越界的邻居点，是live的，就c++
					c++;
			}
		}
		return c;
	}
}
