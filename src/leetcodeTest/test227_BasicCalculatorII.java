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
		Stack<Integer> stack = new Stack<Integer>(); // ����ջ
		int num = 0;
		char sign = '+'; // sign��¼��������֮ǰ����һ�����������ʼֵΪ'+'��
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) { // ��������
				num = num * 10 + s.charAt(i) - '0';
			}
			// �ȳ˳���Ӽ�
			if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) // �ǿո�����֣������
					|| i == len - 1) { // �����ַ�������������Ҫ�������һ�ν��
				if (sign == '-') { // �Ӽ�����������ֱ��ѹ��ջ����������ȼ�
					stack.push(-num);
				}
				if (sign == '+') { // ��һ��ѭ����+
					stack.push(num);
				}
				if (sign == '*') { // �˳���ջ�е���һ�����ּ���������ѹ��ջ
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
