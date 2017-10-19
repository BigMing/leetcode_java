package leetcodeTest;

public class test5_LongestPalindromicSubstring {
	// 暴力法，超时
	public static String longestPalindrome1(String s) {
		int len = s.length(); // 字符串长度
		if (len == 1) {
			return s;
		}
		
		int maxlength = 0; // 最长回文字符串长度
		int start = 0; // 回文开始的地方
		
		for (int i = 0; i < len; i++) {
			// 对于每一个i，j从1到len
			for (int j = i + 1; j < len; j++) { // 0, 2
				int index1 = 0;
				int index2 = 0;
				// 对每个子串都从两边开始向中间遍历
				for (index1 = i, index2 = j; index1 < index2; index1++, index2--) { // 1, 1
					if (s.charAt(index1) != s.charAt(index2)) // 在i，j的条件下找回文子串
						break;
				}
				// 若index1=index2,表示串是类似于abcba这种类型；若大于，则是abccba这种类型
				if (index1 >= index2 // 判定找到回文了
						&& j - i >= maxlength) { // 看找到的回文长度
					maxlength = j - i + 1; // 更新最大的回文长度 3
					start = i; // 记录回文开始的地方  0
				}
			}
		}
		if (maxlength > 0)
			return s.substring(start, start + maxlength);
		return s.substring(0, 1);
	}
	public static void main(String[] args) {
		System.out.println(longestPalindrome1("aaaaa"));
	}
	
	/*
	 * 回文字符串的子串也是回文，比如P[i,j]（表示以i开始以j结束的子串）是回文字符串，那么P[i+1,j-1]也是回文字符串。
	 * 这样最长回文子串就能分解成一系列子问题了。这样需要额外的空间O（N^2)，算法复杂度也是O(N^2)。
	 * 首先定义状态方程和转移方程：
	 * P[i,j]=false:表示子串[i,j]不是回文串。P[i,j]=true:表示子串[i,j]是回文串。
	 * P[i,i]=true:当且仅当P[i+1,j-1] = true && (s[i]==s[j]）
	 * 否则p[i,j] =false;
	 */
    public static String longestPalindrome2(String s) {
		int len = s.length();
		int start = 0;
		int maxlength = 0;
		boolean p[][] = new boolean[s.length()][s.length()];
		// 子串长度为1和为2的初始化
		for (int i = 0; i < len; i++) {
			p[i][i] = true; // 1
			if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) { // 2
				p[i][i + 1] = true;
				start = i;
				maxlength = 2;
			}
		}
		// 使用上述结果可以dp出子串长度为3~len -1的子串
		for (int strlen = 3; strlen <= len; strlen++) {
			for (int i = 0; i <= len - strlen; i++) {
				int j = i + strlen - 1; // 子串结束的位置，子串为s[i, j]
				if (p[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
					p[i][j] = true;
					maxlength = strlen;
					start = i;
				}
			}
		}
		if (maxlength > 0)
			return s.substring(start, start + maxlength);
		return s.substring(0, 1);
    }
    
    /*
     * 中心扩展就是把给定的字符串的每一个字母当做中心，向两边扩展，这样来找最长的子回文串。算法复杂度为O(N^2)。
     * 但是要考虑两种情况：
     * 1、像aba，这样长度为奇数。
     * 2、像abba，这样长度为偶数。
     */
    public static String longestPalindrome3(String s) {
		int len = s.length();
		int maxlength = 0;
		int start = 0;
		// 类似于aba这种情况，以i为中心向两边扩展
		for (int i = 0; i < len; i++) {
			int j = i - 1;
			int k = i + 1;
			while (j >= 0 && k < len && s.charAt(j) == s.charAt(k)) {
				if (k - j + 1 > maxlength) {
					maxlength = k - j + 1;
					start = j;
				}
				j--;
				k++;
			}
		}
		// 类似于abba这种情况，以i，i+1为中心向两边扩展
		for (int i = 0; i < len; i++) {
			int j = i;
			int k = i + 1;
			while (j >= 0 && k < len && s.charAt(j) == s.charAt(k)) {
				if (k - j + 1 > maxlength) {
					maxlength = k - j + 1;
					start = j;
				}
				j--;
				k++;
			}
		}
		if (maxlength > 0)
			return s.substring(start, start + maxlength);
		return null;
    }
}
