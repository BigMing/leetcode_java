package leetcodeTest;

public class test410_SplitArrayLargestSum {
	/**
	 * ������ֳ�m�����֣�ʹ��ÿ���������ĺ���С
	 * @param nums
	 * @param m
	 * @return
	 */
	public static int splitArray(int[] nums, int m) {
		// ��һ�����������ҽ���
		long R = 1; // �Ͻ���ȫ���ĺͣ��ұ��ǿ�����
		for (int i = 0; i < nums.length; i++) {
			R += nums[i];
		}
		long L = 0; // �½���0
		long ans = 0;
		// �ڶ���
		while (L < R) {
			long mid = (L + R) / 2;
			if (guess(mid, nums, m)) {
				ans = mid;
//				L = mid + 1;
				R = mid;
			} else {
//				R = mid;
				L = mid + 1;
			}
		}
		return (int) ans;
	}

	/**
	 * @param mid ����Ĳ��ֺ�
	 * @param nums ����
	 * @param m ��Ҫ�ֳ�m������
	 * @return �������ֵΪmid��ʱ�򣬴�ʱ�Ƿ�ϸ�
	 */
	private static boolean guess(long mid, int[] nums, int m) {
		long sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (sum + nums[i] > mid) {
				m--; // һ�����ֵĺͳ���mid��
				sum = nums[i]; // �¿���һ�����֣�nums[i]�ǵ�һ��ֵ
				if (nums[i] > mid) {
					return false;
				}
			} else {
				sum += nums[i];
			}
		}
		return m >= 1; // ��һ���sum��
	}
}
