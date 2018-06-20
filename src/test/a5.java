package test;

import java.util.Arrays;

public class a5 {
	public static int sulotion2(int n, int k, int m, int prices[]) {
		int ans = 0;
		for (int i = m - k - 1; i < m; i++) {
			// ��С��ʼ�����۸�
			int tempPrice = 0;
			for (int j = 0; j < k; j++) {
				// k����
				tempPrice += prices[i - j];
			}
			if (tempPrice <= n) {
				ans++;
			}
		}
		return ans;
	}
	
	/**
	 * @param n ʣ���Ǯ
	 * @param k ����Ҫȡ�Ĳ�Ʒ����
	 * @param m ��ѡ�Ĳ�Ʒ����
	 * @param prices ��Ʒ�۸��嵥������
	 * @return ��������
	 */
	public static int sulotion1(int n, int k, int m, int prices[]) {
		if (n <= 0 || k <= 0) {
			return 0;
		}
		int ans = 0;
		if (k == 1) { // ��ֻ��Ҫѡһ�ֲ˵�ʱ��
			for (int i = 0; i < m; i++) {
				if (prices[i] < n) {
					ans++;
				}
			}
		} else { // Ҫѡ����˵�ʱ������ȥ�����ļ�
			for (int i = 0; i <= m - k; i++) {
				// ���۸�Ӵ�С��ȡ��Ʒ��n��ʱΪʣ���Ǯ
				ans += sulotion1(n - prices[m - 1 - i], k - 1, m - i, Arrays.copyOf(prices, m - i));
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int prices[] = { 10, 3, 5, 12 };
		Arrays.sort(prices); // ��������
		System.out.println(sulotion1(10, 2, 4, prices));
	}
}
