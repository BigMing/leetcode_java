package leetcodeTest;

import java.util.HashMap;

public class test454_4SumII {
	/*
	 * Given four lists A, B, C, D of integer values, compute how many tuples
	 * (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
	 * 
	 * To make problem a bit easier, all A, B, C, D have same length of N where
	 * 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the
	 * result is guaranteed to be at most 231 - 1.
	 * 
	 * Example:
	 * 
	 * Input: A = [ 1, 2] B = [-2,-1] C = [-1, 2] D = [ 0, 2]
	 * 
	 * Output: 2
	 * 
	 * Explanation: The two tuples are: 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] +
	 * D[1] = 1 + (-2) + (-1) + 2 = 0 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] +
	 * D[0] = 2 + (-1) + (-1) + 0 = 0
	 */
	/*
	 * 通过已知中元素个数最大为500，可知暴力法依次遍历4个数组的方式不可行。因此我们采用Map查找表的方式进行查找，
	 * 主要方式通过将ABCD四个数组分为AB，CD两个模块，首先将AB数组中每个元素和存放在Map查找表中，考虑到两个数之和可能相同的情况，
	 * 我们可以将Map中的value存储出现的次数，若再次出现，则+1；之后计算CD数组中每个元素和，在Map查找表中查找是否存在对应值，若存在，
	 * 则记录Map中相应的value值。
	 */
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
		int result = 0;

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int addAB = A[i] + B[j];
				if (record.containsKey(addAB))
					record.put(addAB, record.get(addAB) + 1);
				else
					record.put(addAB, 1);
			}
		}
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int addCD = C[i] + D[j];
				if (record.containsKey(-addCD))
					result += record.get(-addCD);
			}
		}
		return result;
	}
}
