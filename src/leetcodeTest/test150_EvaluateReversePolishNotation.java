package leetcodeTest;

import java.util.Stack;

public class test150_EvaluateReversePolishNotation {
	/*
	 * Example 1:
	 * 
	 * Input: ["2", "1", "+", "3", "*"] Output: 9 Explanation: ((2 + 1) * 3) = 9
	 * Example 2:
	 * 
	 * Input: ["4", "13", "5", "/", "+"] Output: 6 Explanation: (4 + (13 / 5)) =
	 * 6 Example 3:
	 * 
	 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5",
	 * "+"] Output: 22 Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 =
	 * ((10 * (6 / (12 * -11))) + 17) + 5 = ((10 * (6 / -132)) + 17) + 5 = ((10
	 * * 0) + 17) + 5 = (0 + 17) + 5 = 17 + 5 = 22
	 */
	/*
	 * 遇到数字就进栈，遇到运算符号就出栈两个数字然后再将计算结果进栈。
	 */
	public int evalRPN(String[] tokens) {
		int length = tokens.length;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < length; i++) {
			if (!isOperator(tokens[i])) // 数字压栈
				stack.push(Integer.parseInt(tokens[i]));
			else { // 遇到运算符
				int operaNum2 = stack.pop();
				int operaNum1 = stack.pop();
				if (tokens[i].equals("+"))
					stack.push(operaNum1 + operaNum2);
				else if (tokens[i].equals("-"))
					stack.push(operaNum1 - operaNum2);
				else if (tokens[i].equals("*"))
					stack.push(operaNum1 * operaNum2);
				else {
					stack.push(operaNum1 / operaNum2);
				}
			}

		}
		return stack.pop();
	}

	public boolean isOperator(String s) {
		if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
			return true;
		else
			return false;
	}
}
