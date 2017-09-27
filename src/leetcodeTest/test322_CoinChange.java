package leetcodeTest;

public class test322_CoinChange {
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
