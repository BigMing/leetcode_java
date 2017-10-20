package leetcodeTest;

public class test10_RegularExpressionMatching {

	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		if (p.length() == 1 || p.charAt(1) != '*') { // p长度为1或者p的第二个字符不是*
			if (s.isEmpty() // s为空肯定返回false
					|| (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) { // p的第一个字符不是. 且p和s第一个字符不同
				return false;
			} else { // p和s第一个字符匹配上
				return isMatch(s.substring(1), p.substring(1));
			}
		}
		// p的长度大于1 且 p的第二个字符是*的情况下
		while (!s.isEmpty() // s非空 且
				&& (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) { // s和p的第一个字符匹配上
			if (isMatch(s, p.substring(2))) { // 因为p第二个字符是*代表重复第一个字符0次或n次，跳过*是看重复0次的情况
				return true;
			}
			s = s.substring(1); // 否则可能第一个字符重复多次
		}
		return isMatch(s, p.substring(2)); // 上面循环没return可能此时s为空，可以直到p为空
	}
}
