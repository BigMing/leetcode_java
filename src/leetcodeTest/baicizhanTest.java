package leetcodeTest;

import java.util.Arrays;

public class baicizhanTest {
	public static int sulotion(int n, int k, int m, int prices[]) {
		int ans = 0;
		Arrays.sort(prices);
		for (int i = m - k - 1; i < m; i++) {
			// ��С��ʼ�����۸�
			int tempPrice = 0;
			for (int j = 0; j < k; j++) {
				//k����
				tempPrice += prices[i - j];
			}
//			System.out.println(tempPrice);
			if (tempPrice <= n) {
				ans++;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int prices [] = {10,3,5,12};
		System.out.println(sulotion(10, 2, 4, prices));
	}
}
