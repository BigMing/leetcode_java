package leetcodeTest;

public class test279_PerfectSquares {
	/*
	 * Given a positive integer n, find the least number of perfect square
	 * numbers (for example, 1, 4, 9, 16, ...) which sum to n.
	 * 
	 * Example 1:
	 * 
	 * Input: n = 12 Output: 3 Explanation: 12 = 4 + 4 + 4. Example 2:
	 * 
	 * Input: n = 13 Output: 2 Explanation: 13 = 4 + 9.
	 */
	/*
	 * dp[0] = 0 dp[1] = dp[0]+1 = 1 dp[2] = dp[1]+1 = 2 dp[3] = dp[2]+1 = 3
	 * dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 } = Min{ dp[3]+1, dp[0]+1 } = 1
	 * dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 } = Min{ dp[4]+1, dp[1]+1 } = 2
	 * dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 } = Min{ dp[12]+1,
	 * dp[9]+1, dp[4]+1 } = 2 dp[n] = Min{ dp[n - i*i] + 1 }, n - i*i >=0 && i
	 * >= 1
	 */
	public int numSquares(int n) {
		int dp[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = i; // 最多都由1组成
			for (int j = 1; j * j <= i; j++)
				// 0-1背包
				dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
		}
		return dp[n];
	}
}
