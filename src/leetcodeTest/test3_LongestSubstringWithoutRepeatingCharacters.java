package leetcodeTest;

import java.util.HashMap;

public class test3_LongestSubstringWithoutRepeatingCharacters {
	/*
	 * Given "abcabcbb", the answer is "abc", which the length is 3.
	 * Given "bbbbb", the answer is "b", with the length of 1.
	 * Given "pwwkew", the answer is "wke", with the length of 3. 
	 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 */
	/*
	 * ����hashmap�洢���ظ��Ӵ���keyΪ�ַ���valueΪ���ַ���λ�á���ǰ�����б�����ֻҪmap��û�е�ǰ�ַ����㽫�����map��
	 * �����Ӵ����ȼ�һ������ǰ�ַ��Ѿ�������map�У����map�д��ַ���λ�ã������λ���Լ�֮ǰ�ĵ�����key���Ӵ�λ��֮�����¼����Ӵ�����֤���Ӵ��Ĳ��ظ���
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s == null)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		int maxLen = 0;
		int len = 0; // �Ӵ�����
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				len++;
				if (len > maxLen)
					maxLen = len; // ���ظ�ʱ���ϵļ�¼��ǰ��󳤶�
				map.put(s.charAt(i), i);
			} else { // �ַ����ֹ�
				int index = map.get(s.charAt(i)); // map���д��ַ�ʱ��ȡ�����±�
				for (int j = start; j <= index; j++) {
					map.remove(s.charAt(j)); // ɾ����index֮ǰ������key������index
				}
				map.put(s.charAt(i), i); // ���·����key
				start = index + 1; // ����start�ͳ���
				len = i - index;
			}
		}
		return maxLen;
	}
}
