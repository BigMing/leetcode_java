package leetcodeTest;

public class test8_StringtoInteger {
	/*
	 * Example 1:Input: "42",Output: 42
	 * Example 2:Input: "   -42",Output: -42,
	 * Explanation: The first non-whitespace character is '-', which is the minus sign. Then take as many numerical digits as possible, which gets 42.
	 * Example 3:Input: "4193 with words",Output: 4193,
	 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
	 * Example 4:Input: "words and 987",Output: 0,
	 * Explanation: The first non-whitespace character is 'w', which is not a numerical, digit or a +/- sign. Therefore no valid conversion could be performed.
	 * Example 5:Input: "-91283472332",Output: -2147483648,
	 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer. Thefore INT_MIN (−231) is returned.
	 */
	public static int myAtoi(String str) {
		long MAX_VALUE = Integer.MAX_VALUE; // 这里用int定义的话+1会出错
		long ans = 0;
		str = str.trim(); // 去掉str前面的空格
		char [] strCharArray = str.toCharArray(); // 先把String转化为char数组
		boolean flag = false; // 考虑正负号
		int index = 0;
		if (index < strCharArray.length && strCharArray[index] == '+') {
			index++;
		} else if (index < strCharArray.length && strCharArray[index] == '-') { // 有'+-'的情况出现
			index++;
			flag = true;
		}
		for (; index < strCharArray.length; index++) { // 转化为数
			if (strCharArray[index] <= '9' && strCharArray[index] >= '0') {
				ans = ans * 10 + strCharArray[index] - '0';
				if (ans > MAX_VALUE) {
					ans = MAX_VALUE + 1;
					break;
				}
			} else {
				break; // str中出现非数字直接break
			}
		}
		if (flag) { // 负数最小为-2147483648
			ans = -ans;
		}
		if (ans > MAX_VALUE) {
			ans = MAX_VALUE;
		}
        return (int) ans;
    }
	
	public static void main(String[] args) {
		System.out.println(myAtoi("-"));
	}
}
