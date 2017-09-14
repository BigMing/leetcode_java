package leetcodeTest;

public class test79_WordSearch {

	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (exist(board, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean exist(char[][] board, int x, int y, String word, int index) {
		if (index == word.length()) { // 越界
			return true;
		}
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(index)) {
			return false;
		}
		board[x][y] ^= 128;
		// 由于英文字符范围是0~127，因此遍历某个字符后，进行c^=128操作，该字符在后续匹配中就不会再次匹配到，从而实现标记的效果
		boolean exist = exist(board, x - 1, y, word, index + 1)
				|| exist(board, x + 1, y, word, index + 1)
				|| exist(board, x, y - 1, word, index + 1)
				|| exist(board, x, y + 1, word, index + 1);
		board[x][y] ^= 128;
		return exist;
	}
}
