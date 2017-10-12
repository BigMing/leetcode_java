package leetcodeTest;

import java.util.List;

public class test139_WordBreak {
	/**
	 * ����A[i]��ʾ0���±�Ϊi�����ַ��ܷ񱻷ָ��dict�еĶ�����ʡ� 
	 * ��ôA[i]��A[j],0<=j< i���й�ϵ����A[i]��ǰA[]�е�ǰi-1��й�ϵ������Ϊ��
	 * ���A[0]Ϊ1���ж�s���±��1��ʼ��i�������ַ��Ƿ���dict�У�����ڣ�����A[i]Ϊ1���������������ڶ�����
	 * ���A[1]Ϊ1���ж�s���±��2��ʼ��i�������ַ��Ƿ���dict�У�����ڣ�����A[i]Ϊ1���������������ڶ����� 
	 * ��..
	 * ����һֱ������A[i-1]λ�á�
	 * ������ı������������������ĳһ��j,A[j]=1����j+1��i��ʾ���ַ���������dict�У�
	 * ��ʾǰj���ַ����ָܷ��dict�еĵ��ʣ�j+1��i�е��ַ�����Ҳ�ָܷ��dict�еĵ��ʣ�������ʾǰi���ַ��ܱ��ָ��dict�еĵ��ʡ�
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		int length = s.length();
		boolean[] words = new boolean[length];

		for (int i = 1; i <= length; i++) {
			int j;
			for (j = 0; j < i; j++) {
				String substr = s.substring(j, i);
				if (wordDict.contains(substr) && (j == 0 || words[j - 1])) {
					words[i - 1] = true;
					break;
				}
			}
			if (j == i)
				words[i - 1] = false;
		}
		return words[length - 1];
	}
}