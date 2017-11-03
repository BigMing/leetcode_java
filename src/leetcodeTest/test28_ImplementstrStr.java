package leetcodeTest;

public class test28_ImplementstrStr {
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() < needle.length())
			return -1;
		if (haystack.length() == 0 || needle.length() == 0)
			return 0;
		
		int[] next = calNext(needle);
		
		int hlen = haystack.length();
		int nlen = needle.length();
		int hindex = 0;
		int nindex = 0;
		
		while (hindex < hlen && nindex < nlen) {
			if (haystack.charAt(hindex) == needle.charAt(nindex)) // 从头开始，若匹配就一直继续比较
			{
				hindex++;
				nindex++;
			} else if (next[nindex] == -1) // 表示与子串的第一个字符就没有匹配上，则主串自己向后移动
			{
				hindex++;
			} else // 直到nindex - 1都匹配上了，所以子串不需要从头继续，只需要从next[nindex]位继续匹配即可
			{
				nindex = next[nindex];
			}
		}
		return nindex == nlen ? hindex - nindex : -1; // 如果匹配到子串的结尾，则返回此时主串与子串的位置差，即为开始匹配的地方
	}

	public int[] calNext(String needle) {
		if (needle.length() == 1)
			return new int[] { -1 };
		int[] next = new int[needle.length()];
		next[0] = -1;
		next[1] = 0;
		int cn = 0;
		int pos = 2;
		while (pos < next.length) {
			if (needle.charAt(pos - 1) == needle.charAt(cn))
				next[pos++] = ++cn;
			else if (cn > 0) // 回退
				cn = next[cn];
			else
				next[pos++] = 0;
		}
		return next;
	}
}
