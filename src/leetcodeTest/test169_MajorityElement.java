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
		int main = nums[0]; // ���ڼ�¼��Ԫ�أ������һ������Ԫ��
		int count = 1; // ���ڵ������ĸ���

		for (int i = 1; i < nums.length; i++) { // �ӵڶ���Ԫ�ؿ�ʼ�����һ��Ԫ��
			if (main == nums[i]) { // �����������ͬ�Ͳ��ܵ���
				count++; // ���ڵ��������ݼ�1
			} else {
				if (count > 0) { // �������ͬ�������п��Ե�������
					count--; // �������ݵ���
				} else { // �������ͬ������û�п��Ե�������
					main = nums[i]; // ��¼��󲻿��Ե�������
				}
			}
		}
		return main;
	}
}
