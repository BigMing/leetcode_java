package leetcodeTest;

public class test169_MajorityElement {
	/*
	 * Example 1:
	 * 
	 * Input: [3,2,3] Output: 3 Example 2:
	 * 
	 * Input: [2,2,1,1,1,2,2] Output: 2
	 */
	public int majorityElement(int[] nums) {
		int main = nums[0]; // 用于记录主元素，假设第一个是主元素
		int count = 1; // 用于抵消数的个数

		for (int i = 1; i < nums.length; i++) { // 从第二个元素开始到最后一个元素
			if (main == nums[i]) { // 如果两个数相同就不能抵消
				count++; // 用于抵消的数据加1
			} else {
				if (count > 0) { // 如果不相同，并且有可以抵消的数
					count--; // 进行数据抵消
				} else { // 如果不相同，并且没有可以抵消的数
					main = nums[i]; // 记录最后不可以抵消的数
				}
			}
		}
		return main;
	}
}
