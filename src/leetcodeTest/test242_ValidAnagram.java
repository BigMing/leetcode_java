package leetcodeTest;

import java.util.Arrays;

public class test242_ValidAnagram {
	/*
	 * Given two strings s and t , write a function to determine if t is an
	 * anagram of s.
	 * 
	 * Example 1:
	 * 
	 * Input: s = "anagram", t = "nagaram" Output: true Example 2:
	 * 
	 * Input: s = "rat", t = "car" Output: false
	 */
	public boolean isAnagram(String s, String t) { // ���ַ�����
		char[] schar = s.toCharArray();
		char[] tchar = t.toCharArray();

		Arrays.sort(schar);
		Arrays.sort(tchar);

		// ��ֱ�ӱȽ�char[], ����String���ڱȽ�
		String s1 = new String(schar);
		String s2 = new String(tchar);

		if (s1.equals(s2))
			return true;
		else
			return false;
	}

	public boolean isAnagram1(String s, String t) { // ���ַ�����
		if (s.length() != t.length())
			return false;

		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();

		int[] temp = new int[128];
		for (char c : sChar) {
			temp[c]++;
		}
		for (char c : tChar) {
			temp[c]--;
			if (temp[c] < 0)
				return false;
		}
		return true;
	}
}
