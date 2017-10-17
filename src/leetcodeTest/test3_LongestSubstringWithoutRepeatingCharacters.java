package leetcodeTest;

import java.util.HashMap;

public class test3_LongestSubstringWithoutRepeatingCharacters {
	/*
	 * 利用hashmap存储不重复子串，key为字符，value为此字符的位置。
	 * 从前向后进行遍历，只要map 中没有当前字符，便将其加入map 。
	 * 并将子串长度加一。若当前字符已经出现在map 中，获得map中 此字符的位置，
	 * 清除此位置以及之前的的所有key 。从此位置之后重新计算子串，保证了子串的不重复。
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s == null)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		int maxLen = 0;
		int len = 0; // 子串长度
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				len++;
				if (len > maxLen)
					maxLen = len; // 不重复时不断的记录当前最大长度
				map.put(s.charAt(i), i);
			} else {
				int index = map.get(s.charAt(i)); // map中有此字符时，取出其下标
				for (int j = start; j <= index; j++) {
					map.remove(s.charAt(j)); // 删除此index之前的所以key，包括index
				}
				map.put(s.charAt(i), i); // 重新放入该key
				start = index + 1; // 更新start和长度
				len = i - index;
			}
		}
		return maxLen;
	}
}
