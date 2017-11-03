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
			if (haystack.charAt(hindex) == needle.charAt(nindex)) // ��ͷ��ʼ����ƥ���һֱ�����Ƚ�
			{
				hindex++;
				nindex++;
			} else if (next[nindex] == -1) // ��ʾ���Ӵ��ĵ�һ���ַ���û��ƥ���ϣ��������Լ�����ƶ�
			{
				hindex++;
			} else // ֱ��nindex - 1��ƥ�����ˣ������Ӵ�����Ҫ��ͷ������ֻ��Ҫ��next[nindex]λ����ƥ�伴��
			{
				nindex = next[nindex];
			}
		}
		return nindex == nlen ? hindex - nindex : -1; // ���ƥ�䵽�Ӵ��Ľ�β���򷵻ش�ʱ�������Ӵ���λ�ò��Ϊ��ʼƥ��ĵط�
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
			else if (cn > 0) // ����
				cn = next[cn];
			else
				next[pos++] = 0;
		}
		return next;
	}
}
