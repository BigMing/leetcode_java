package leetcodeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test350_IntersectionofTwoArraysII {
	/*
	 * Given two arrays, write a function to compute their intersection.
	 * 
	 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
	 * 
	 * Note: Each element in the result should appear as many times as it shows
	 * in both arrays. The result can be in any order.
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num1 : nums1) {
			if (!map.containsKey(num1)) {
				map.put(num1, 1);
			} else {
				map.put(num1, map.get(num1) + 1);
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int num2 : nums2) {
			if (map.containsKey(num2) && map.get(num2) > 0) {
				list.add(num2);
				map.put(num2, map.get(num2) - 1);
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
