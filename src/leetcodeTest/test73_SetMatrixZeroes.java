package leetcodeTest;

public class test73_SetMatrixZeroes {
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
