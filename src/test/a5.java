package test;

import java.util.Arrays;

public class a5 {
	public static int sulotion2(int n, int k, int m, int prices[]) {
		int ans = 0;
		for (int i = m - k - 1; i < m; i++) {
			// 从小开始遍历价格
			int tempPrice = 0;
			for (int j = 0; j < k; j++) {
				// k个菜
				tempPrice += prices[i - j];
			}
			if (tempPrice <= n) {
				ans++;
			}
		}
		return ans;
	}
	
	/**
	 * @param n 剩余的钱
	 * @param k 还需要取的菜品个数
	 * @param m 可选的菜品个数
	 * @param prices 菜品价格清单，升序
	 * @return 方案个数
	 */
	public static int sulotion1(int n, int k, int m, int prices[]) {
		if (n <= 0 || k <= 0) {
			return 0;
		}
		int ans = 0;
		if (k == 1) { // 当只需要选一种菜的时候
			for (int i = 0; i < m; i++) {
				if (prices[i] < n) {
					ans++;
				}
			}
		} else { // 要选多个菜的时候，依次去掉最大的价
			for (int i = 0; i <= m - k; i++) {
				// 按价格从大到小的取菜品，n此时为剩余的钱
				ans += sulotion1(n - prices[m - 1 - i], k - 1, m - i, Arrays.copyOf(prices, m - i));
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int prices[] = { 10, 3, 5, 12 };
		Arrays.sort(prices); // 排序，升序
		System.out.println(sulotion1(10, 2, 4, prices));
	}
}
