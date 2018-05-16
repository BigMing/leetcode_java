package leetcodeTest;

public class test44_WildcardMatching {
	/*
	 * Example 1:Input:s = "aa",p = "a",Output: false,Explanation: "a" does not match the entire string "aa".
	 * Example 2:Input:s = "aa",p = "*",Output: true,Explanation: '*' matches any sequence.
	 * Example 3:Input:s = "cb",p = "?a",Output: false,Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
	 * Example 4:Input:s = "adceb",p = "*a*b",Output: true,Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
	 * Example 5:Input:s = "acdcb",p = "a*c?b",Output: false
	 */
	public boolean isMatch(String s, String p) {
		int is = 0;
		int ip = 0;

		int press = 0;
		int presp = 0;

		boolean backstrack = false;
		
		for (is = 0; is < s.length();) {
			if (ip == p.length()) { // 结束
				if (backstrack == false) {
					return false;
				} else if (p.charAt(p.length() - 1) == '*') {
					return true;
				} else {
					ip = presp;
					is = ++press;
				}
			}
			if (p.charAt(ip) == '?') {
				is++;
				ip++;
			} else if (p.charAt(ip) == '*') {
				presp = ++ip;
				press = is;
				backstrack = true;
			} else { // 匹配字母
				if (p.charAt(ip) == s.charAt(is)) {
					is++;
					ip++;
				} else if (backstrack) { // 字母不等时看之前是否是*
					ip = presp;
					is = ++press;
				} else {
					return false;
				}
			}
		}
		while (ip <= p.length() - 1 && p.charAt(ip) == '*') {
			ip++;
			if (ip == p.length()) {
				break;
			}
		}
		return ip == p.length();
	}
}
