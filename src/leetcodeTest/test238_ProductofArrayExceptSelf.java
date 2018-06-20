package leetcodeTest;

public class test238_ProductofArrayExceptSelf {
	/*
	 * Given an array nums of n integers where n > 1, return an array output
	 * such that output[i] is equal to the product of all the elements of nums
	 * except nums[i].
	 * 
	 * Example:
	 * 
	 * Input: [1,2,3,4] Output: [24,12,8,6]
	 */
	/*
	 * ���һ:ֻҪ�����е�0���������ڵ���2,��ô���ص�ֵһ��ȫΪ0��
	 * 
	 * �����:���������ֻ��һ��0,��ô����ֵ����iλ�õ���,��������ֵһ��ҲΪ0��
	 * 
	 * �����:����������û��0,�򵥲���
	 */
	public int[] productExceptSelf(int[] nums) {
		int product = 1;
		int zeros = 0;// ��¼������0�ĸ���
		int[] result = new int[nums.length];
		for (int num : nums) {
			if (num == 0) {
				zeros++;
				if (zeros == 2) { // ����������2������0ʱ,���صĽ��һ��ȫ��0
					return result;
				}
			} else {
				product = product * num;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (zeros == 0) { // ������û��0�����
				result[i] = product / nums[i];
			} else { // ��������һ��0�����
				if (nums[i] == 0) {
					result[i] = product;
				}
			}
		}
		return result;
	}

	/*
	 * �����ǲ��ó����ķ���:
	 * 
	 * ��Ҫ��������forѭ��,��һ��ѭ���а�result[i]��ֵΪǰ�����nums��ǰi-1�����ĳ˻�
	 * 
	 * �ڶ���forѭ����temp��ֵΪnum�ĺ�i-1�����ĳ˻�
	 */
	public int[] productExceptSelf1(int[] nums) {
		int[] result = new int[nums.length];
		result[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			result[i] = result[i - 1] * nums[i - 1];
		}
		int temp = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			temp = temp * nums[i + 1];
			result[i] = result[i] * temp;
		}
		return result;
	}
}
