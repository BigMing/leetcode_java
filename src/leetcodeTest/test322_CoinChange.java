package leetcodeTest;

public class test322_CoinChange {
	/*
	 * You are given coins of different denominations and a total amount of
	 * money amount. Write a function to compute the fewest number of coins that
	 * you need to make up that amount. If that amount of money cannot be made
	 * up by any combination of the coins, return -1.
	 * 
	 * Example 1:
	 * 
	 * Input: coins = [1, 2, 5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 +
	 * 1 Example 2:
	 * 
	 * Input: coins = [2], amount = 3 Output: -1
	 */
	public static int maxValue = 10000000; // 设置非法值，题目要返回-1
	public static int[][] f = new int[100][1000];

	public int search(int idx, int amount, int[] coins) {
		if (amount == 0) {
			return 0;
		}
		if (amount < 0) {
			return maxValue;
		}
		if (idx >= coins.length) {
			return maxValue;
		}
		if (f[idx][amount] >= 0) {
			return f[idx][amount];
		}
		int a = search(idx, amount - coins[idx], coins);
		int b = search(idx + 1, amount, coins);
		f[idx][amount] = Math.min(a + 1, b);
		return f[idx][amount];
	}

	public int coinChange1(int[] coins, int amount) {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 10000; j++) {
				f[i][j] = -1;
			}
		}
		int res = search(0, amount, coins);
		if (res < maxValue) {
			return res;
		} else {
			return -1;
		}
	}

	/*
	 * dp[i] 表示凑齐钱数 i 需要的最少硬币数，那么凑齐钱数 amount 最少硬币数为：固定钱数为 coins[j] 一枚硬币，另外的钱数为
	 * amount - coins[j] 它的数量为dp[amount - coins[j]]，j 从0遍历到coins.length - 1
	 */
	public int coinChange3(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		for (int i = 1; i <= amount; i++) { // i容量1~amount
			dp[i] = 0x7fffffff;
			for (int j = 0; j < coins.length; j++)
				if (i >= coins[j] && dp[i - coins[j]] != 0x7fffffff)
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
		}
		return dp[amount] == 0x7fffffff ? -1 : dp[amount];
	}

	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		for (int i = 1; i <= amount; i++)
			dp[i] = 0x7fff_fffe;
		for (int coin : coins)
			for (int i = coin; i <= amount; i++)
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
		return dp[amount] == 0x7fff_fffe ? -1 : dp[amount];
	}
}
