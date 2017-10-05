package leetcodeTest;

public class test378_KthSmallestElementinaSortedMatrix {
	/**
	 * 要找出传入的g的大小范围，矩阵中可能会有多个g
	 * @param g 传入的要猜测的结果
	 * @param martix 
	 * @param k 第k小的
	 * @param n 矩阵的阶数
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
	/**
	 * 当k越大，输出越大，给出k求结果很麻烦，但是给出结果求k很容易
	 * @param matrix n*n矩阵
	 * @param k 求第k小的数
	 * @return
	 */
	public static int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int R = matrix[n - 1][n - 1]; // 答案区间的上界，[L, R]区间
		int L = matrix[0][0];
		int ans = 0;
		while (L <= R) { // 闭区间
			int mid = (int) (((long)L + R) / 2); // L + R可能越界
			if (guess(mid, matrix, k, n)) {
				ans = mid;
				L = mid + 1;
			} else {
				R = mid - 1; // 闭区间要-1
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
