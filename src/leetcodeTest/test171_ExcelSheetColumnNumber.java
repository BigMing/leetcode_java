package leetcodeTest;

public class test171_ExcelSheetColumnNumber {
	/*
	 * Given a column title as appear in an Excel sheet, return its
	 * corresponding column number.
	 * 
	 * For example:
	 * 
	 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 ...
	 */
	/*
	 * 本题就是A-Z代表26进制的数，计算出26进制字符串对于的10进制数
	 * 这里用到一个数学函数Math.pow(a,b)=a的b次幂，即Math.pow(26,len-1-i)代表26的（len-1-i）次幂
	 */
	public int titleToNumber(String s) {
		// s中字符个数
		int len = s.length();
		// 保存最终结果
		int result = 0;
		// 从个位数开始累加计算
		for (int i = len - 1; i >= 0; i--) {
			// Math.pow(a,b)是计算a的b次幂，这里底数是26
			result += (s.charAt(i) - 'A' + 1) * Math.pow(26, len - 1 - i);
		}
		return result;
	}
}
