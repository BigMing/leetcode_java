package leetcodeTest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class test378_KthSmallestElementinaSortedMatrix {
	/*
	 * Given a n x n matrix where each of the rows and columns are sorted in
	 * ascending order, find the kth smallest element in the matrix.
	 * 
	 * Note that it is the kth smallest element in the sorted order, not the kth
	 * distinct element.
	 */
	/**
	 * Ҫ�ҳ������g�Ĵ�С��Χ�������п��ܻ��ж��g
	 * 
	 * @param g
	 *            �����Ҫ�²�Ľ��
	 * @param martix
	 * @param k
	 *            ��kС��
	 * @param n
	 *            ����Ľ���
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

	/*
	 * ��kԽ�����Խ�󣬸���k�������鷳�����Ǹ��������k������
	 */
	public static int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int R = matrix[n - 1][n - 1]; // ��������Ͻ磬[L, R]����
		int L = matrix[0][0];
		int ans = 0;
		while (L <= R) { // ������
			int mid = (int) (((long) L + R) / 2); // L + R����Խ��
			if (guess(mid, matrix, k, n)) {
				ans = mid;
				L = mid + 1;
			} else {
				R = mid - 1; // ������Ҫ-1
			}
		}
		return ans;
	}

	public int kthSmallest1(int[][] matrix, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer a0, Integer a1) {
				if (a0 > a1) {
					return -1;
				} else if (a0 < a1) {
					return 1;
				}
				return 0;
			}
		});// ����
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if ((i + 1) * (j + 1) > k) {
					break;
				}
				maxHeap.offer(matrix[i][j]);
				if (maxHeap.size() > k) {
					maxHeap.poll();
				}
			}
		}
		return maxHeap.peek();
	}

}
