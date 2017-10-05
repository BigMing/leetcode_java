package leetcodeTest;

public class test378_KthSmallestElementinaSortedMatrix {
	/**
	 * Ҫ�ҳ������g�Ĵ�С��Χ�������п��ܻ��ж��g
	 * @param g �����Ҫ�²�Ľ��
	 * @param martix 
	 * @param k ��kС��
	 * @param n ����Ľ���
	 * @return
	 */
	public static boolean guess(int g, int[][] matrix, int k, int n) {
		int sum1 = 0; // ���½磬�ö��ַ�
		for (int i = 0; i < n; i++) {
			int L = 0;
			int R = n - 1;
			int ans = -1; // ע��
			while (L <= R) { // ������
				int mid = (L + R) / 2;
				if (matrix[i][mid] < g) {
					ans = mid; // ans = 5��˵��[0, 5]����С��g��
					L = mid + 1;
				} else {
					R = mid - 1; // �ұ�����Ҫ-1
				}
			}
			sum1 += (ans + 1); // �ű�+1����0��ʼ�ģ�С�ڵ���g�ĸ�����sum1��
		}
		return k > sum1; // �µ�g�����Ը���
	}
	/**
	 * ��kԽ�����Խ�󣬸���k�������鷳�����Ǹ��������k������
	 * @param matrix n*n����
	 * @param k ���kС����
	 * @return
	 */
	public static int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int R = matrix[n - 1][n - 1]; // ��������Ͻ磬[L, R]����
		int L = matrix[0][0];
		int ans = 0;
		while (L <= R) { // ������
			int mid = (int) (((long)L + R) / 2); // L + R����Խ��
			if (guess(mid, matrix, k, n)) {
				ans = mid;
				L = mid + 1;
			} else {
				R = mid - 1; // ������Ҫ-1
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int [][] matrix = {{ 1,  5,  9}, {10, 11, 13}, {12, 13, 15}};
		int k = 8;
		System.out.println(kthSmallest(matrix, k));
	}
}
