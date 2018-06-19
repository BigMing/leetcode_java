package leetcodeTest;

import java.util.HashSet;
import java.util.Set;

public class test217_ContainsDuplicate {
	/*
	 * Example 1:
	 * 
	 * Input: [1,2,3,1] Output: true Example 2:
	 * 
	 * Input: [1,2,3,4] Output: false Example 3:
	 * 
	 * Input: [1,1,1,3,3,4,3,2,4,2] Output: true
	 */
	public boolean containsDuplicate(int[] nums) {
		// Ԫ�ظ�������1�Ž�������Ĳ���
		if (nums != null && nums.length > 1) {
			// ����һ��hashSet
			Set<Integer> set = new HashSet<>(nums.length);
			for (int i : nums) {
				// ���Ԫ���Ѿ����ھͷ���true
				if (set.contains(i)) {
					return true;
				}
				// û�о���ӵ�Ԫ�ؼ�����
				else {
					set.add(i);
				}
			}
		}
		return false;
	}
}
