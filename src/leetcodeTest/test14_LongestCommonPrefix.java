package leetcodeTest;

import java.util.Arrays;

public class test14_LongestCommonPrefix {
	/*
	 * Example 1:Input: ["flower","flow","flight"]，Output: "fl"
	 * Example 2:Input: ["dog","racecar","car"]，Output: ""，
	 * Explanation: There is no common prefix among the input strings.
	 */
	public String longestCommonPrefix(String[] strs) {
		int len = strs.length;
		if (len == 0)
			return "";
		String result = "";
		int minSize = 100000;
		int minIndex = 0;
		if (len == 1) {
			result = strs[0];
			return result;
		}
		for (int i = 0; i < len; i++) { // 遍历每个String
			int size = strs[i].length(); // 每个String的length
			if (size < minSize) {
				minSize = size;
				minIndex = i;
			}
		} // 找到最短的String和它的下标
		for (int i = minSize; i >= 0; i--) {
			result = strs[minIndex].substring(0, i); // 在最短的String上依次拿到它的前i个字符的串
			int j = 0;
			for (; j < len; j++) { // 依次在其他String上看前i个字符的串匹配不
				if (j == minIndex) // 遇到自己就跳过
					continue;
				String temp = strs[j].substring(0, i);
				if (!result.equals(temp))
					break;
			}
			if (j == len) // 全部匹配了就返回
				return result;
		}
		return result;
	}
	
    public String longestCommonPrefix1(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if (strs != null && strs.length > 0) {
            Arrays.sort(strs);
            char[] a = strs[0].toCharArray(); // a和b相当于是差别最大的两个String，找它们的公共前缀就可以了
            char[] b = strs[strs.length - 1].toCharArray();
            for (int i = 0; i < a.length; i++) {
                if (b.length > i && b[i] == a[i]) {
                    prefix.append(b[i]);
                } else {
                    return prefix.toString();
                }
            }
        }
        return prefix.toString();
    }
}
