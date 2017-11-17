package leetcodeTest;

public class test44_WildcardMatching {
    public boolean isMatch(String s, String p) {
    	char[] s1 = s.toCharArray();
    	char[] p1 = p.toCharArray();
    	int i = 0, j = 0; // s1和p1的指针
    	int x = 0, y = 0;
        boolean has_star = false;
        while (i < s1.length && (has_star || j < p1.length)) {
			if (s1[i] == p1[j] || p1[j] == '?') {
				++i;
				++j;
			} else if (p1[j] == '*') {
				has_star = true;
				if (j + 1 == p1.length) { // *是最后一个字符
					return true;
				}
				x = i;
				y = j + 1;
			} else {
				if (!has_star) {
					return false;
				}
				i = x + 1;
				j = y;
			}
		}
        while (i < s1.length && s1[i] == '*') {
			++i;
		}
        if (i == s1.length && j == p1.length) {
			return true;
		}
        return false;
    }
}
