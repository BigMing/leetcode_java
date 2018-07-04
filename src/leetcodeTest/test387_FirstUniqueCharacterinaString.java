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
	// ����26���������飬Ȼ���ȶ��ַ�����һ�飬ͳ��ÿ����ĸ���ֵĴ�����Ȼ���ͷ�ٹ�һ�飬��һ����ĸ��Ϊ1�ļ�Ϊ���ȳ��ֲ���ֻ����һ�ε���ĸ��
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
