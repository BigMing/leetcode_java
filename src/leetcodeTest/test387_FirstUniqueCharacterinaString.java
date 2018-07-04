package leetcodeTest;

public class test387_FirstUniqueCharacterinaString {
	/*
	 * Given a string, find the first non-repeating character in it and return
	 * it's index. If it doesn't exist, return -1.
	 * 
	 * Examples:
	 * 
	 * s = "leetcode" return 0.
	 * 
	 * s = "loveleetcode", return 2.
	 */
	// 开个26个数的数组，然后先对字符串过一遍，统计每个字母出现的次数，然后从头再国一遍，第一个字母数为1的即为首先出现并且只出现一次的字母。
	public int firstUniqChar(String s) {
		int[] a = new int[26];
		for (int i = 0; i < s.length(); i++)
			a[s.charAt(i) - 'a']++;
		for (int i = 0; i < s.length(); i++) {
			if (a[s.charAt(i) - 'a'] == 1)
				return i;
		}
		return -1;
	}
}
