//package leetcodeTest;
//
//public class knapsackproblem {
//	int w[n], v[n], W; // n����������������ֵ���������ܴ�С
//	S <= W
//	�Ѿ�ռ�� = W - ʣ�����
//	int search() {
//		if (S > W) {
//			return 0;
//		}
//		if (idx >= n) {
//			return 0;
//		}
//		if (f[idx][S] >= 0) {
//			return f[idx][S];
//		}
//		// S�ǵ�ǰ����
//		f[idx][S] = Math.max(search(idx + 1, S + w[idx]) + v[idx], search(idx + 1, S));
//		return f[idx][S]; // ��¼����ģ�ȥ������
//	}
//}
//
//f[0][0] = 0;
//for (int i = 1; i <= W; i++) {
//	f[0][i] = -maxValue;
//}
//for (int idx = 1; idx <= n; idx++) {
//	f[idx][0] = 0;
//	for (int j = 1; j <= W; j++) {
//		f[idx][j] = f[idx - 1][j];
//		if (j >= w[idx]) {
//			f[idx][j] = Math.max(search(idx - 1, j - w[idx]) + v[idx], f[idx][j]);
//		}
//	}
//}
//
//f[idx][S] = Math.max(search(idx + 1, S + w[idx]) + v[idx], search(idx + 1, S));