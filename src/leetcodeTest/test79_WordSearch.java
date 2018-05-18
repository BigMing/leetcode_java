package leetcodeTest;

public class test79_WordSearch {
	/*
	 * Given a 2D board and a word, find if the word exists in the grid.
	 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
	 * The same letter cell may not be used more than once.
	 * Example:board =
		[ ['A','B','C','E'],
		  ['S','F','C','S'],
		  ['A','D','E','E']]
		  Given word = "ABCCED", return true.
		  Given word = "SEE", return true.
		  Given word = "ABCB", return false.
	 */
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
		if (index == word.length()) {
			return true;
		}
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(index)) {
			return false;
		}
		board[x][y] ^= 128;
		// ����Ӣ���ַ���Χ��0~127����˱���ĳ���ַ��󣬽���c^=128���������ַ��ں���ƥ���оͲ����ٴ�ƥ�䵽���Ӷ�ʵ�ֱ�ǵ�Ч��
		boolean exist = exist(board, x - 1, y, word, index + 1)
				|| exist(board, x + 1, y, word, index + 1)
				|| exist(board, x, y - 1, word, index + 1)
				|| exist(board, x, y + 1, word, index + 1);
		board[x][y] ^= 128;
		return exist;
	}
}
