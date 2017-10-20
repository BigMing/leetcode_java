package leetcodeTest;

public class test10_RegularExpressionMatching {

	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		if (p.length() == 1 || p.charAt(1) != '*') { // p����Ϊ1����p�ĵڶ����ַ�����*
			if (s.isEmpty() // sΪ�տ϶�����false
					|| (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) { // p�ĵ�һ���ַ�����. ��p��s��һ���ַ���ͬ
				return false;
			} else { // p��s��һ���ַ�ƥ����
				return isMatch(s.substring(1), p.substring(1));
			}
		}
		// p�ĳ��ȴ���1 �� p�ĵڶ����ַ���*�������
		while (!s.isEmpty() // s�ǿ� ��
				&& (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) { // s��p�ĵ�һ���ַ�ƥ����
			if (isMatch(s, p.substring(2))) { // ��Ϊp�ڶ����ַ���*�����ظ���һ���ַ�0�λ�n�Σ�����*�ǿ��ظ�0�ε����
				return true;
			}
			s = s.substring(1); // ������ܵ�һ���ַ��ظ����
		}
		return isMatch(s, p.substring(2)); // ����ѭ��ûreturn���ܴ�ʱsΪ�գ�����ֱ��pΪ��
	}
}
