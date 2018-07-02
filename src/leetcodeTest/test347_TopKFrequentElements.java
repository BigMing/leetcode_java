package leetcodeTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test347_TopKFrequentElements {
	/*
	 * Given a non-empty array of integers, return the k most frequent elements.
	 * 
	 * For example, Given [1,1,1,2,2,3] and k = 2, return [1,2].
	 * 
	 * Note: You may assume k is always valid, 1 ≤ k ≤ number of unique
	 * elements. Your algorithm's time complexity must be better than O(n log
	 * n), where n is the array's size.
	 * 
	 */
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		// 统计nums中每个元素出现的次数
		for (int i = 0; i < nums.length; i++) {
			if (count.containsKey(nums[i]))
				count.put(nums[i], count.get(nums[i]) + 1);
			else
				count.put(nums[i], 1);
		}
		// 重写排序算法
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(count.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		// 获得最终要获得的top k的元素
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < k; i++)
			result.add(list.get(i).getKey());
		return result;
	}
}
