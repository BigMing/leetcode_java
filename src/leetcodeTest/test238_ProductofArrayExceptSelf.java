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
	 * 情况一:只要数组中的0的数量大于等于2,那么返回的值一定全为0。
	 * 
	 * 情况二:如果数组中只有一个0,那么返回值除了i位置的数,其他返回值一定也为0。
	 * 
	 * 情况三:输入数组中没有0,简单操作
	 */
	public int[] productExceptSelf(int[] nums) {
		int product = 1;
		int zeros = 0;// 记录数组中0的个数
		int[] result = new int[nums.length];
		for (int num : nums) {
			if (num == 0) {
				zeros++;
				if (zeros == 2) { // 当数组中有2个以上0时,返回的结果一定全是0
					return result;
				}
			} else {
				product = product * num;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (zeros == 0) { // 数组中没有0的情况
				result[i] = product / nums[i];
			} else { // 数组中有一个0的情况
				if (nums[i] == 0) {
					result[i] = product;
				}
			}
		}
		return result;
	}

	/*
	 * 下面是不用除法的方案:
	 * 
	 * 需要进行两次for循环,第一次循环中把result[i]赋值为前面的数nums的前i-1个数的乘积
	 * 
	 * 第二次for循环把temp赋值为num的后i-1个数的乘积
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
