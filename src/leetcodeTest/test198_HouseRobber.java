package leetcodeTest;

public class test198_HouseRobber {
	/*
	 * Example 1:
	 * 
	 * Input: [1,2,3,1] Output: 4 Explanation: Rob house 1 (money = 1) and then
	 * rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4. Example 2:
	 * 
	 * Input: [2,7,9,3,1] Output: 12 Explanation: Rob house 1 (money = 2), rob
	 * house 3 (money = 9) and rob house 5 (money = 1). Total amount you can rob
	 * = 2 + 9 + 1 = 12.
	 */
	public int rob1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length > 2) { // ��������е�Ԫ�ظ���������2�������ڡ�A��ʽ��i=2��dp[2-3]������
			nums[2] += nums[0];
		}
		int i = 3; // �ӵ��ĸ�Ԫ�ؿ�ʼ����
		for (; i < nums.length; i++) { // �����i��Ԫ�ص����ֵ
			nums[i] += Math.max(nums[i - 2], nums[i - 3]);
		}
		if (nums.length == 1) { // ���ֻ��һ��Ԫ�أ��������Ԫ��ֵ
			return nums[0];
		} else if (nums.length == 2) { // ������Ԫ�ط������нϴ��ֵ
			return Math.max(nums[0], nums[1]);
		} else { // ��������Ԫ�أ����ֵ��ĩβ����֮�䣬�����ķ���
			return Math.max(nums[i - 1], nums[i - 2]);
		}
	}

	public static int[] result;

	/**
	 * �Զ�����ʽ�ģ� Ҳ�����Ե����ϣ���idx=0��ʼ
	 * 
	 * @param idx
	 *            �ڼ��ҵ�
	 */
	public int solve(int idx, int[] nums) {
		if (idx < 0) {
			return 0;
		}
		if (result[idx] >= 0) { // ��������
			return result[idx];
		}
		result[idx] = Math.max(nums[idx] + solve(idx - 2, nums), solve(idx - 1, nums));
		return result[idx];
	}

	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		result = new int[nums.length];
		result[0] = nums[0];
		result[1] = Math.max(nums[0], nums[1]);
		// for (int i = 0; i < nums.length; i++) {
		// result[i] = -1;
		// }
		for (int idx = 2; idx < nums.length; idx++) {
			result[idx] = Math.max(nums[idx] + result[idx - 2], result[idx - 1]);
		}
		return result[nums.length - 1]; // �ĳɵ��Ƶķ�ʽ
	}
}
