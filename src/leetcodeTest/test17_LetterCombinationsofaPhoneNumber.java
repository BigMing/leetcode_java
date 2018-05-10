package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test17_LetterCombinationsofaPhoneNumber {
	/*
	 * Input: "23",Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	 */
	public List<String> letterCombinations(String digits) {
		// 把table上的数字对应的字母列出来，当输入为2是，digits[2]就是2所对应的"abc"
		String[] table = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		List<String> ans = new ArrayList<String>();
		// index从0开始，即digits的第一个数字
		letterCombinations(ans, digits, "", 0, table);
		return ans;
	}
	/**
	 * @param ans 最终结果集，传引用
	 * @param digits 传入的数字
	 * @param curr 临时存的可能的结果
	 * @param index 当前运算到传入的数字的下标
	 * @param table 字母和数字是映射关系，下标是数字，内容是字母
	 */
	private void letterCombinations(List<String> ans, String digits, String curr, int index, String[] table) {
		if (index == digits.length()) { // 最后一层退出条件
			if (curr.length() != 0)
				ans.add(curr);
			return;
		}
		// 找到数字对应的字符串
		String temp = table[digits.charAt(index) - '0']; // digits[index]对应的字母集合
		for (int i = 0; i < temp.length(); i++) {
			String next = curr + temp.charAt(i); // 每次循环把不同字符串加到当前curr之后
			letterCombinations(ans, digits, next, index + 1, table); // 进入下一层next, index + 1
		}
	}
}
