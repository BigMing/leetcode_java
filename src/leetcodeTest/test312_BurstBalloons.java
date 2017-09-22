package leetcodeTest;

public class test312_BurstBalloons {
	/**
	 * ��̬�滮���飺DP[k][h]��nums[k...h]�ܴ�����������ֵ ���ƹ�ϵ��
	 * ȡk<m<h��nums[m]���������һ�����Ƶ�����
	 * ��DP[k][h] = for (m = k+1...h) 
	 * max(DP[k][m] + DP[m][h] + nums[k] * nums[m] * nums[h]); 
	 * ��ʼֵ����Ҫ��չnums�����鳤+2��ͷ��β�ֱ����1 
	 * DP[k][h]: ��k + 1 = h �� k = hʱ��Ϊ0;
	 * ��k + 2 = h ʱ��Ϊ nums[k] * nums[k+1] * nums[k+2];
	 */
	public int maxCoins(int[] nums) {
		int n = nums.length + 2;
		int[] newnums = new int[n];
		for (int i = 0; i < n - 2; i++) {
			newnums[i + 1] = nums[i];
		}
		newnums[0] = newnums[n - 1] = 1; // �ڸ�������ǰ�����1
		int[][] DP = new int[n][n];
		for (int k = 2; k < n; k++) {
			for (int l = 0; l + k < n; l++) {
				int h = l + k;
				for (int m = l + 1; m < h; m++) {
					DP[l][h] = Math.max(DP[l][h], 
							newnums[l] * newnums[m] * newnums[h] + DP[l][m] + DP[m][h]);
				}
			}
		}
		return DP[0][n - 1];
	}

	// �س�ʱ�����ݷ�
	public int maxR(int[] nums) {
		if (0 == nums.length) {
			return 0;
		} else if (1 == nums.length) {
			return nums[0];
		} else {
			int max = Integer.MIN_VALUE;
			int[] newNum = new int[nums.length - 1];
			for (int i = 0; i < nums.length; i++) {
				int r = 0;
				if (i == 0) {
					System.arraycopy(nums, 1, newNum, 0, nums.length - 1);
					r = maxR(newNum) + nums[0] * nums[1];
				} else if (i == nums.length - 1) {
					System.arraycopy(nums, 0, newNum, 0, nums.length - 1);
					r = maxR(newNum) + nums[nums.length - 2] * nums[nums.length - 1];
				} else {
					System.arraycopy(nums, 0, newNum, 0, i);
					System.arraycopy(nums, i + 1, newNum, i, nums.length - i - 1);
					r = maxR(newNum) + nums[i - 1] * nums[i] * nums[i + 1];
				}
				if (max < r)
					max = r;
			}
			return max;
		}
	}
}
