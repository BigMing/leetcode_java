package leetcodeTest;

public class test53_MaximumSubarray {
	/*
	 * Example:Input: [-2,1,-3,4,-1,2,1,-5,4],Output: 6
	 * Explanation: [4,-1,2,1] has the largest sum = 6.
	 */
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE; // ������Сֵ
		int sum = 0; // ÿһ������ĺ�
		int i = 0;
		while (i < nums.length) {
			sum += nums[i]; // ÿһ�������ǰn���
			if (max < sum) {
				max = sum; // ��¼����
			}
			if (sum < 0) { // ���֮ǰ�ĺ�С��0�����ϻ��С�Ͳ��ü���
				sum = 0;
			}
			i++;
		}
		return max;
	}
}
