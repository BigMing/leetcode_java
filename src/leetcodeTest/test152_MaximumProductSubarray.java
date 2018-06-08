package leetcodeTest;

public class test152_MaximumProductSubarray {
	/*
	 * Example 1:
	 * 
	 * Input: [2,3,-2,4] Output: 6 Explanation: [2,3] has the largest product 6.
	 * Example 2:
	 * 
	 * Input: [-2,0,-1] Output: 0 Explanation: The result cannot be 2, because
	 * [-2,-1] is not a subarray.
	 */
	/*
	 * ����Product Subarray��Ҫ���ǵ�һ������������������͸�����ˣ�
	 * ���ǰ��õ�һ����С�ĸ������ͺ���һ���ϴ�ĸ�����ˣ��õ��ķ�����һ���ϴ��������{2��-3��-7}��
	 * ���ԣ������ڴ���˷���ʱ�򣬳�����Ҫά��һ���ֲ����ֵ��ͬʱ��Ҫά��һ���ֲ���Сֵ n<1˵�������д�n����0ʱ Fmax(0)=num[0]
	 * Fmin(0)=num[0] Fmax(n+1) = MAX(MAX(num[n+1]*Fmax(n), num[n+1]),
	 * num[n+1]*Fmin(n)) // ���ֵ Fmin(n+1) = MIN(MIN(num[n+1]*Fmax(n), num[n+1]),
	 * num[n+1]*Fmin(n)) // ��Сֵ��Ϊ��һ���¼�����׼��
	 */
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length < 1) {
			throw new IllegalArgumentException();
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int result = nums[0];
		int fmax = nums[0];
		int fmin = nums[0];
		int prevMax;
		for (int i = 1; i < nums.length; i++) {
			prevMax = fmax;
			fmax = Math.max(Math.max(nums[i] * prevMax, nums[i]), nums[i] * fmin);
			fmin = Math.min(Math.min(nums[i] * prevMax, nums[i]), nums[i] * fmin);
			result = Math.max(result, fmax);
		}
		return result;
	}
}
