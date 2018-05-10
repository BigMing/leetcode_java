package leetcodeTest;

import java.util.Stack;

public class test20_ValidParentheses {
	/*
	 * Example 1:Input: "()",Output: true Example 2:Input: "()[]{}",Output: true
	 * Example 3:Input: "(]",Output: false Example 4:Input: "([)]",Output: false
	 * Example 5:Input: "{[]}",Output: true
	 */
	/*
	 * ���������String
	 * s��������������ž���ջ��������������ţ����ջ���Ϊ�գ�֤������ƥ�䣬���ջ���գ�pop��ջ����Ԫ�أ����Ƿ��뵱ǰ��������ƥ�䡣
	 * ���ƥ�䣬�������½�����һ�ֵ�ѭ���������ƥ�䣬����false.
	 * ע�⣺ȫ���ַ�����������Ժ��ж�ջ�Ƿ�Ϊ�գ�������ȷ��ƥ�䣬������֤����ûƥ��ġ�
	 * ����ַ�����==�����String����.isEqual()����ΪString���������ͣ�ֵ��ȵ��ǵ�ַ���ܲ��ȡ�
	 */
	public boolean isValid(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == '(' || cur == '{' || cur == '[') {
				stack.push(cur);
			} else {
				switch (cur) {
				case ')':
					if (stack.isEmpty() || stack.pop() != '(') {
						return false;
					}
					break;
				case ']':
					if (stack.isEmpty() || stack.pop() != '[') {
						return false;
					}
					break;
				case '}':
					if (stack.isEmpty() || stack.pop() != '{') {
						return false;
					}
					break;
				default:
					break;
				}
			}
		}
		return stack.size() == 0;
	}
}
