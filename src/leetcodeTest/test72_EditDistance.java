package leetcodeTest;

public class test72_EditDistance {
	public int min(int a, int b, int c) {
		if (b < a) {
			a = b;
		}
		if (c < a) {
			a = c;
		}
		return a;
	}
	/**
	 * dp[i][j]��ʾ��word1��ǰi���ַ�( 0 ~ i - 1 )��word2��ǰj���ַ�(  0 ~ j - 1)�ı༭�����У�
	 * ��Ҫ�����ٲ�������ô�����  word1[i] = word2[j]   ��   dp[i][j]   =   dp[i-1][j-1]
	 * ���  word1[i] != word2[j]    
	 * ��   dp[i][j] =   min   { dp[i-1][j]  ,  dp[i][j-1],    dp[i-1][j-1] }  + 1
	 */
    public int minDistance(String word1, String word2) {
    	char[] w1 = word1.toCharArray();
    	char[] w2 = word2.toCharArray();
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
        	dp[i][0] = i;
        }
        for (int i = 1; i <= len2; i++) {
        	dp[0][i] = i;
        }
		for (int i = 1; i <= len1; i++) { // ���±�1��ʼ
			for (int j = 1; j <= len2; j++) {
				if (w1[i - 1] == w2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1;
				}
			}
		}
		return dp[len1][len2];
    }
}
