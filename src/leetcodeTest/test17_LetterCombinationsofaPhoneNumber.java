package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test17_LetterCombinationsofaPhoneNumber {
	/*
	 * Input: "23",Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	 */
	public List<String> letterCombinations(String digits) {
		// ��table�ϵ����ֶ�Ӧ����ĸ�г�����������Ϊ2�ǣ�digits[2]����2����Ӧ��"abc"
		String[] table = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		List<String> ans = new ArrayList<String>();
		// index��0��ʼ����digits�ĵ�һ������
		letterCombinations(ans, digits, "", 0, table);
		return ans;
	}
	/**
	 * @param ans ���ս������������
	 * @param digits ���������
	 * @param curr ��ʱ��Ŀ��ܵĽ��
	 * @param index ��ǰ���㵽��������ֵ��±�
	 * @param table ��ĸ��������ӳ���ϵ���±������֣���������ĸ
	 */
	private void letterCombinations(List<String> ans, String digits, String curr, int index, String[] table) {
		if (index == digits.length()) { // ���һ���˳�����
			if (curr.length() != 0)
				ans.add(curr);
			return;
		}
		// �ҵ����ֶ�Ӧ���ַ���
		String temp = table[digits.charAt(index) - '0']; // digits[index]��Ӧ����ĸ����
		for (int i = 0; i < temp.length(); i++) {
			String next = curr + temp.charAt(i); // ÿ��ѭ���Ѳ�ͬ�ַ����ӵ���ǰcurr֮��
			letterCombinations(ans, digits, next, index + 1, table); // ������һ��next, index + 1
		}
	}
}
