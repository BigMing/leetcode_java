package leetcodeTest;

public class test10_RegularExpressionMatching {
	/*
	 * Example 1:Input:s = "aa",p = "a",Output: false,Explanation: "a" does not match the entire string "aa".
	 * Example 2:Input:s = "aa",p = "a*",Output: true,Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
	 * Example 3:Input:s = "ab",p = ".*",Output: true,Explanation: ".*" means "zero or more (*) of any character (.)".
	 * Example 4:Input:s = "aab",p = "c*a*b",Output: true,Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
	 * Example 5:Input:s = "mississippi",p = "mis*is*p*.",Output: false,
	 */
	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		if (p.length() == 1 || p.charAt(1) != '*') { // p����Ϊ1����p�ĵڶ����ַ�����*
			if (s.isEmpty() // sΪ�տ϶�����false
					|| (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) { // p�ĵ�һ���ַ�����. ��p��s��һ���ַ���ͬ
				return false;
			} else { // p��s��һ���ַ�ƥ���ϣ���ȥƥ�������ַ�
				return isMatch(s.substring(1), p.substring(1));
			}
		}
		// p�ĳ��ȴ���1 �� p�ĵڶ����ַ���*�������
		while (!s.isEmpty() // s�ǿ�
				&& (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) { // s��p�ĵ�һ���ַ�ƥ����
			if (isMatch(s, p.substring(2))) { // ��Ϊp�ڶ����ַ���*�����ظ���һ���ַ�0�λ�n�Σ�����*�ǿ��ظ�0�ε����
				return true;
			}
			s = s.substring(1); // ������ܵ�һ���ַ��ظ����
		}
		return isMatch(s, p.substring(2)); // ����ѭ��ûreturn���ܴ�ʱsΪ�գ�����ֱ��pΪ��
	}
}
