package leetcodeTest;

import java.util.HashMap;
import java.util.Map;

public class test76_MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		int minStart = 0, minEnd = 0;
		int count = t.length();
		for (char c : t.toCharArray()) {
			map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
		} // 记录下t中每个字母出现几次
		int left = 0;
		for (int right = 0; right < s.length(); right++) {
			char val = s.charAt(right);
			if (map.containsKey(val)) {
				map.put(val, map.get(val) - 1);
				if (map.get(val) >= 0) {
					count--;
				}
			}
			while (count == 0) { // 全覆盖了t中的字母
				if (right - left < min) {
					min = right - left; // 记录最短长度
					minStart = left;
					minEnd = right;
				}
				char temp = s.charAt(left);
				if (map.containsKey(temp)) {
					map.put(temp, map.get(temp) + 1);
					if (map.get(temp) > 0)
						count++;
				}
				left++;
			}
		}
		return min == Integer.MAX_VALUE ? "" : s.substring(minStart, minEnd + 1);
	}
}
