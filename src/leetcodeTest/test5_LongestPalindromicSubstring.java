package leetcodeTest;

public class test5_LongestPalindromicSubstring {
	// ����������ʱ
	public static String longestPalindrome1(String s) {
		int len = s.length(); // �ַ�������
		if (len == 1) {
			return s;
		}
		
		int maxlength = 0; // ������ַ�������
		int start = 0; // ���Ŀ�ʼ�ĵط�
		
		for (int i = 0; i < len; i++) {
			// ����ÿһ��i��j��1��len
			for (int j = i + 1; j < len; j++) { // 0, 2
				int index1 = 0;
				int index2 = 0;
				// ��ÿ���Ӵ��������߿�ʼ���м����
				for (index1 = i, index2 = j; index1 < index2; index1++, index2--) { // 1, 1
					if (s.charAt(index1) != s.charAt(index2)) // ��i��j���������һ����Ӵ�
						break;
				}
				// ��index1=index2,��ʾ����������abcba�������ͣ������ڣ�����abccba��������
				if (index1 >= index2 // �ж��ҵ�������
						&& j - i >= maxlength) { // ���ҵ��Ļ��ĳ���
					maxlength = j - i + 1; // �������Ļ��ĳ��� 3
					start = i; // ��¼���Ŀ�ʼ�ĵط�  0
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
	 * �����ַ������Ӵ�Ҳ�ǻ��ģ�����P[i,j]����ʾ��i��ʼ��j�������Ӵ����ǻ����ַ�������ôP[i+1,j-1]Ҳ�ǻ����ַ�����
	 * ����������Ӵ����ֽܷ��һϵ���������ˡ�������Ҫ����Ŀռ�O��N^2)���㷨���Ӷ�Ҳ��O(N^2)��
	 * ���ȶ���״̬���̺�ת�Ʒ��̣�
	 * P[i,j]=false:��ʾ�Ӵ�[i,j]���ǻ��Ĵ���P[i,j]=true:��ʾ�Ӵ�[i,j]�ǻ��Ĵ���
	 * P[i,i]=true:���ҽ���P[i+1,j-1] = true && (s[i]==s[j]��
	 * ����p[i,j] =false;
	 */
    public static String longestPalindrome2(String s) {
		int len = s.length();
		int start = 0;
		int maxlength = 0;
		boolean p[][] = new boolean[s.length()][s.length()];
		// �Ӵ�����Ϊ1��Ϊ2�ĳ�ʼ��
		for (int i = 0; i < len; i++) {
			p[i][i] = true; // 1
			if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) { // 2
				p[i][i + 1] = true;
				start = i;
				maxlength = 2;
			}
		}
		// ʹ�������������dp���Ӵ�����Ϊ3~len -1���Ӵ�
		for (int strlen = 3; strlen <= len; strlen++) {
			for (int i = 0; i <= len - strlen; i++) {
				int j = i + strlen - 1; // �Ӵ�������λ�ã��Ӵ�Ϊs[i, j]
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
     * ������չ���ǰѸ������ַ�����ÿһ����ĸ�������ģ���������չ��������������ӻ��Ĵ����㷨���Ӷ�ΪO(N^2)��
     * ����Ҫ�������������
     * 1����aba����������Ϊ������
     * 2����abba����������Ϊż����
     */
    public static String longestPalindrome3(String s) {
		int len = s.length();
		int maxlength = 0;
		int start = 0;
		// ������aba�����������iΪ������������չ
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
		// ������abba�����������i��i+1Ϊ������������չ
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
