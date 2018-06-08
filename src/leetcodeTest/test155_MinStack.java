package leetcodeTest;

import java.util.Stack;

public class test155_MinStack {
	/*
	 * MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
	 * minStack.push(-3); minStack.getMin(); --> Returns -3. minStack.pop();
	 * minStack.top(); --> Returns 0. minStack.getMin(); --> Returns -2.
	 */
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();

	public test155_MinStack() {

	}

	public void push(int x) {
		if (minStack.isEmpty() || x <= minStack.peek())
			minStack.push(x);
		stack.push(x);
	}

	public void pop() {
		if (stack.peek().equals(minStack.peek()))
			minStack.pop();
		stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
