package leetcodeTest;

public class test53_MaximumSubarray {
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
