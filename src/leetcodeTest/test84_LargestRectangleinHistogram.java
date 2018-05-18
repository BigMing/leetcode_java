package leetcodeTest;

import java.util.Stack;

public class test84_LargestRectangleinHistogram {
	/*
	 * Example:Input: [2,1,5,6,2,3],Output: 10
	 */
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> st = new Stack<Integer>();
		int i = 0, maxarea = 0, area;
		while (i < heights.length) {
			if (st.isEmpty() || heights[st.peek()] <= heights[i]) {
				st.push(i++); // 右边的高就加入栈，栈里存的是0，1，2……是数组元素的下标
			} else { // 右边的低于栈顶的高度
				int tp = st.pop(); // i为右边第一个比栈顶元素小的元素的下标
				area = heights[tp] * (st.empty() ? i : i - st.peek() - 1);
				if (area > maxarea) {
					maxarea = area;
				}
			}
		} // 如果高度一致都是递增的就一直压入栈，一旦遇到一个高度减小的，就计算栈里面能够组成的最大四边形面积（一个个出栈分别计算四边形面积）
		while (!st.isEmpty()) {
			int tp = st.pop();
			area = heights[tp] * (st.empty() ? i : i - st.peek() - 1);
			if (area > maxarea) {
				maxarea = area;
			}
		}
		return maxarea;
	}
}
