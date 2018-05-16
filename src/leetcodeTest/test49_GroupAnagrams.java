package leetcodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test49_GroupAnagrams {
	/*
	 * Example:Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
	 * Output:[["ate","eat","tea"],["nat","tan"],["bat"]]
	 */
	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		for (String temp : strs) {
			// �ع�ÿ���ַ���
			char[] current = temp.toCharArray();
			Arrays.sort(current);
			String sortedTemp = String.valueOf(current);
			// ���ع�����ַ���Ϊ��������ͬ�����б�Ϊֵ
			if (!map.containsKey(sortedTemp)) {
				List<String> tempResult = new ArrayList<String>();
				tempResult.add(temp);
				map.put(sortedTemp, tempResult);
			} else {
				map.get(sortedTemp).add(temp);
			}
		}
		return new ArrayList<List<String>>(map.values());
	}
	
	public static void main(String[] args) {
		String[] str = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(str));
	}
}
