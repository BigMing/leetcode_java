package leetcodeTest;

public class test48_RotateImage {
	/*
	 * Given input matrix =
	 * [[1,2,3],
	 * [4,5,6],
	 * [7,8,9]],
	 * rotate the input matrix in-place such that it becomes:
	 * [[7,4,1],
	 * [8,5,2],
	 * [9,6,3]]
	 */
	/*
	 * �������Խ��ߣ����Գ�Ԫ�ؽ���
	 * �����У����Գ���Ԫ��ȫ������
	 */
    public void rotate(int[][] matrix) {
        if (matrix.length == 0) {
			return;
		}
        int n = matrix.length;
        // �Խ��߽���
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j <= i; j++) {
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = temp;
        	}
        }
        // ���ж���
        for (int i = 0, j = n - 1; i < j; i++, j--) {
			for (int k = 0; k < n; k++) {
				int temp = matrix[k][i];
				matrix[k][i] = matrix[k][j];
				matrix[k][j] = temp;
			}
		}
    }
}
