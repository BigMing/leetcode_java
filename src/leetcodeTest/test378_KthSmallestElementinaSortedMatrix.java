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
	 * 要找出传入的g的大小范围，矩阵中可能会有多个g
	 * 
	 * @param g
	 *            传入的要猜测的结果
	 * @param martix
	 * @param k
	 *            第k小的
	 * @param n
	 *            矩阵的阶数
	 * @return
	 */
	public static boolean guess(int g, int[][] matrix, int k, int n) {
		int sum1 = 0; // 求下界，用二分法
		for (int i = 0; i < n; i++) {
			int L = 0;
			int R = n - 1;
			int ans = -1; // 注意
			while (L <= R) { // 闭区间
				int mid = (L + R) / 2;
				if (matrix[i][mid] < g) {
					ans = mid; // ans = 5，说明[0, 5]都是小于g的
					L = mid + 1;
				} else {
					R = mid - 1; // 右闭区间要-1
				}
			}
			sum1 += (ans + 1); // 脚标+1，从0开始的，小于等于g的个数是sum1个
		}
		return k > sum1; // 猜的g还可以更大
	}

	/*
	 * 当k越大，输出越大，给出k求结果很麻烦，但是给出结果求k很容易
	 */
	public static int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int R = matrix[n - 1][n - 1]; // 答案区间的上界，[L, R]区间
		int L = matrix[0][0];
		int ans = 0;
		while (L <= R) { // 闭区间
			int mid = (int) (((long) L + R) / 2); // L + R可能越界
			if (guess(mid, matrix, k, n)) {
				ans = mid;
				L = mid + 1;
			} else {
				R = mid - 1; // 闭区间要-1
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
		});// 最大堆
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
