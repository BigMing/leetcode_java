package leetcodeTest;

public class test73_SetMatrixZeroes {
	/*
	 * Given a m x n matrix, if an element is 0, set its entire row and column
	 * to 0. Do it in-place. Example 1:Input: [ [1,1,1], [1,0,1], [1,1,1]]
	 * Output: [ [1,0,1], [0,0,0], [1,0,1]]
	 */
	public void setZeroes1(int[][] matrix) {
		int col0 = 1, rows = matrix.length, cols = matrix[0].length;

		for (int i = 0; i < rows; i++) {
			if (matrix[i][0] == 0)
				col0 = 0;
			for (int j = 1; j < cols; j++)
				if (matrix[i][j] == 0)
					matrix[i][0] = matrix[0][j] = 0;
		}

		for (int i = rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 1; j--)
				if (matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			if (col0 == 0)
				matrix[i][0] = 0;
		}
	}

	public void setZeroes(int[][] matrix) {
		if (matrix.length == 0)
			return;

		int len1 = matrix.length, len2 = matrix[0].length;
		boolean row0 = false, col0 = false;

		for (int i = 0; i < len1; i++) {
			if (matrix[i][0] == 0) {
				col0 = true;
				break;
			}
		}
		for (int i = 0; i < len2; i++) {
			if (matrix[0][i] == 0) {
				row0 = true;
				break;
			}
		}
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < len1; i++) {
			if (matrix[i][0] == 0)
				for (int j = 1; j < len2; j++)
					matrix[i][j] = 0;
		}
		for (int i = 1; i < len2; i++) {
			if (matrix[0][i] == 0)
				for (int j = 1; j < len1; j++)
					matrix[j][i] = 0;
		}
		if (row0)
			for (int i = 0; i < len2; i++)
				matrix[0][i] = 0;
		if (col0)
			for (int i = 0; i < len1; i++)
				matrix[i][0] = 0;
		return;
	}
}
