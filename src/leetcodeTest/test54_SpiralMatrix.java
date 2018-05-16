package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test54_SpiralMatrix {
	/*
	 * Input:
	 * [[ 1, 2, 3 ],
	 * [ 4, 5, 6 ],
	 * [ 7, 8, 9 ]]
	 * Output: [1,2,3,6,9,8,7,4,5]
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		int m = matrix.length; // rows
		if (m == 0) {
			return result;
		}
		int n = matrix[0].length; // columns
		// topOffset、rightOffset、bottomOffset、leftOffset 分别表示 →、 ↓、 ←、 ↑四个方向遍历的次数
		int topOffset = 0;
		int rightOffset = 0;
		int bottomOffset = 0;
		int leftOffset = 0;
		
		while (true) {
			// top
			for (int i = leftOffset; i < n - rightOffset; i++) {
				result.add(matrix[topOffset][i]);
			}
			topOffset++;
			if (topOffset + bottomOffset == m) {
				break;
			}
			// right
			for (int i = topOffset; i < m - bottomOffset; i++) {
				result.add(matrix[i][n - 1 - rightOffset]);
			}
			rightOffset++;
			if (leftOffset + rightOffset == n) {
				break;
			}
			// bottom
			for (int i = n - 1 - rightOffset; i >= leftOffset; i--) {
				result.add(matrix[m - 1 - bottomOffset][i]);
			}
			bottomOffset++;
			if (topOffset + bottomOffset == m) {
				break;
			}
			// left
			for (int i = m - 1 - bottomOffset; i >= topOffset; i--) {
				result.add(matrix[i][leftOffset]);
			}
			leftOffset++;
			if (leftOffset + rightOffset == n) {
				break;
			}
		}
		return result;
	}
}
