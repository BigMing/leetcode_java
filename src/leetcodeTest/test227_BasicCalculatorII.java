package leetcodeTest;

import java.util.Stack;

public class test227_BasicCalculatorII {
	/*
	 * Implement a basic calculator to evaluate a simple expression string.
	 * 
	 * The expression string contains only non-negative integers, +, -, *, /
	 * operators and empty spaces . The integer division should truncate toward
	 * zero.
	 * 
	 * Example 1:
	 * 
	 * Input: "3+2*2" Output: 7 Example 2:
	 * 
	 * Input: " 3/2 " Output: 1 Example 3:
	 * 
	 * Input: " 3+5 / 2 " Output: 5
	 */
	public int calculate(String s) {
		int len;
		if (s == null || (len = s.length()) == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>(); // 数字栈
		int num = 0;
		char sign = '+'; // sign记录本次数字之前的上一个运算符，初始值为'+'，
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) { // 遇到数字
				num = num * 10 + s.charAt(i) - '0';
			}
			// 先乘除后加减
			if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) // 非空格非数字，运算符
					|| i == len - 1) { // 到达字符串结束处，需要计算最后一次结果
				if (sign == '-') { // 加减不计算结果，直接压入栈，运算符优先级
					stack.push(-num);
				}
				if (sign == '+') { // 第一轮循环是+
					stack.push(num);
				}
				if (sign == '*') { // 乘除从栈中弹出一个数字计算结果，在压入栈
					stack.push(stack.pop() * num);
				}
				if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = s.charAt(i);
				num = 0;
			}
		}

		int res = 0;
		for (int i : stack) {
			res += i;
		}
		return res;
	}
}
