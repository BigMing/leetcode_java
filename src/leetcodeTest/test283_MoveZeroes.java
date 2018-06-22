package leetcodeTest;

public class test283_MoveZeroes {
	/*
	 * Given an array nums, write a function to move all 0's to the end of it
	 * while maintaining the relative order of the non-zero elements.
	 * 
	 * Example:
	 * 
	 * Input: [0,1,0,3,12] Output: [1,3,12,0,0]
	 */
	/*
	 * ά������ָ�룬i j��iָ��nums�ĵ�һ��0��jָ���һ��������
	 */
	public void moveZeroes(int[] nums) {
		int i = 0;
		int j = 0;
		while (j < nums.length) {
			if (nums[j] != 0) {
				if (i != j) { // iָ��0
					nums[i++] = nums[j];
					nums[j] = 0;
				} else {
					++i;
				}
			}
			++j; // ����0
		}
	}

	// ��һ��ֵ���浱ǰ�������ķ���Ԫ��������������i��Ԫ�ظ�ֵ�������±�Ϊi��1��Ԫ�ء���������ʣ�µ�λ�ã�����ֵΪ0����������Ŀ��Ҫ��
	public void moveZeroes1(int[] nums) {
		if (nums != null && nums.length == 0)
			return;
		int insertPost = 0;
		for (int num : nums) {
			if (num != 0) {
				nums[insertPost++] = num;
			}
		}
		while (insertPost < nums.length) {
			nums[insertPost++] = 0;
		}
	}
}
