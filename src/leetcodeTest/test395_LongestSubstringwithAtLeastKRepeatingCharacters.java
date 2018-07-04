package leetcodeTest;

public class test395_LongestSubstringwithAtLeastKRepeatingCharacters {
	/*
	 * Find the length of the longest substring T of a given string (consists of
	 * lowercase letters only) such that every character in T appears no less
	 * than k times.
	 * 
	 * Example 1:
	 * 
	 * Input: s = "aaabb", k = 3
	 * 
	 * Output: 3
	 * 
	 * The longest substring is "aaa", as 'a' is repeated 3 times. Example 2:
	 * 
	 * Input: s = "ababbc", k = 2
	 * 
	 * Output: 5
	 * 
	 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is
	 * repeated 3 times.
	 */
	/*
	 * Ҫ��s[i,j]������Ӵ�����ͳ��Ƶ����Ȼ�����һ��Ƶ�����ҳ���һ��Ƶ��С��k�Ҵ���0���ַ���Ȼ���ҳ�����ַ���λ�ã��������ķ�������Ҫ��
	 * ����ַ�һ�����ܳ������κε��Ӵ��У���Ϊi,j���������Ӵ�����ij����Ƶ����û�дﵽk����ô��ij���κ��Ӵ��У�����ַ�Ҳ�����ܴﵽƵ��k��
	 * ���Բ���������ַ�����ô�������λ����һ�����Σ�����ǰ�벿�ֺͺ�벿�ֵ����ֵ��
	 */
	public int longestSubstring(String s, int k) {
		return longestSubstringSub(s, k, 0, s.length() - 1);
	}

	private int longestSubstringSub(String s, int k, int start, int end) {
		if (start > end)
			return 0;
		int[] count = new int[26];
		for (int i = start; i <= end; i++) { // ��¼Ƶ��
			count[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (count[i] > 0 && count[i] < k) {
				int pos = s.indexOf((char) (i + 'a'), start);
				return Math.max(longestSubstringSub(s, k, start, pos - 1), longestSubstringSub(s, k, pos + 1, end));
			}
		}
		return end - start + 1;
	}
}
