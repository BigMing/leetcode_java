package leetcodeTest;

public class test48_RotateImage {
	/*
	 * 按照主对角线，将对称元素交换
	 * 按照列，将对称列元素全部交换
	 */
    public void rotate(int[][] matrix) {
        if (matrix.length == 0) {
			return;
		}
        int n = matrix.length;
        // 对角线交换
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j <= i; j++) {
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = temp;
        	}
        }
        // 按列对折
        for (int i = 0, j = n - 1; i < j; i++, j--) {
			for (int k = 0; k < n; k++) {
				int temp = matrix[k][i];
				matrix[k][i] = matrix[k][j];
				matrix[k][j] = temp;
			}
		}
    }
}
