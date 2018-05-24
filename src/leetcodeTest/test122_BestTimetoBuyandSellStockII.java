package leetcodeTest;

public class test122_BestTimetoBuyandSellStockII {
	/*
	 * Example 1:
	 * 
	 * Input: [7,1,5,3,6,4] Output: 7 Explanation: Buy on day 2 (price = 1) and
	 * sell on day 3 (price = 5), profit = 5-1 = 4. Then buy on day 4 (price =
	 * 3) and sell on day 5 (price = 6), profit = 6-3 = 3. Example 2:
	 * 
	 * Input: [1,2,3,4,5] Output: 4 Explanation: Buy on day 1 (price = 1) and
	 * sell on day 5 (price = 5), profit = 5-1 = 4. Note that you cannot buy on
	 * day 1, buy on day 2 and sell them later, as you are engaging multiple
	 * transactions at the same time. You must sell before buying again.
	 */
	public int maxProfit(int[] prices) {
		int p = 0;
		for (int i = 1; i < prices.length; i++) {
			int delta = prices[i] - prices[i - 1];
			if (delta > 0) {
				p += delta;
			}
		}
		// һ���л����ռ��ȥ׬Ǯ�����Ծ��ǰ�ÿ����ļ۸������������������������ˣ������������ļ۸�������Ϊ������ô�Ͳ����н��ס�
		return p;
	}
}
