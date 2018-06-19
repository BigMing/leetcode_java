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
		// 元素个数大于1才进行下面的操作
		if (nums != null && nums.length > 1) {
			// 创建一个hashSet
			Set<Integer> set = new HashSet<>(nums.length);
			for (int i : nums) {
				// 如果元素已经存在就返回true
				if (set.contains(i)) {
					return true;
				}
				// 没有就添加到元素集合中
				else {
					set.add(i);
				}
			}
		}
		return false;
	}
}
