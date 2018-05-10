package leetcodeTest;

import java.util.Arrays;

public class test14_LongestCommonPrefix {
	/*
	 * Example 1:Input: ["flower","flow","flight"]��Output: "fl"
	 * Example 2:Input: ["dog","racecar","car"]��Output: ""��
	 * Explanation: There is no common prefix among the input strings.
	 */
	public String longestCommonPrefix(String[] strs) {
		int len = strs.length;
		if (len == 0)
			return "";
		String result = "";
		int minSize = 100000;
		int minIndex = 0;
		if (len == 1) {
			result = strs[0];
			return result;
		}
		for (int i = 0; i < len; i++) { // ����ÿ��String
			int size = strs[i].length(); // ÿ��String��length
			if (size < minSize) {
				minSize = size;
				minIndex = i;
			}
		} // �ҵ���̵�String�������±�
		for (int i = minSize; i >= 0; i--) {
			result = strs[minIndex].substring(0, i); // ����̵�String�������õ�����ǰi���ַ��Ĵ�
			int j = 0;
			for (; j < len; j++) { // ����������String�Ͽ�ǰi���ַ��Ĵ�ƥ�䲻
				if (j == minIndex) // �����Լ�������
					continue;
				String temp = strs[j].substring(0, i);
				if (!result.equals(temp))
					break;
			}
			if (j == len) // ȫ��ƥ���˾ͷ���
				return result;
		}
		return result;
	}
	
    public String longestCommonPrefix1(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if (strs != null && strs.length > 0) {
            Arrays.sort(strs);
            char[] a = strs[0].toCharArray(); // a��b�൱���ǲ����������String�������ǵĹ���ǰ׺�Ϳ�����
            char[] b = strs[strs.length - 1].toCharArray();
            for (int i = 0; i < a.length; i++) {
                if (b.length > i && b[i] == a[i]) {
                    prefix.append(b[i]);
                } else {
                    return prefix.toString();
                }
            }
        }
        return prefix.toString();
    }
}
