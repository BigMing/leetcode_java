package leetcodeTest;

import java.util.Stack;

public class test84_LargestRectangleinHistogram {
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
		}
		
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
