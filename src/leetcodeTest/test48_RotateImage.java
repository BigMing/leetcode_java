package leetcodeTest;

public class test48_RotateImage {
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
