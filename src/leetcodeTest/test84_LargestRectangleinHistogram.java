package leetcodeTest;

import java.util.Stack;

public class test84_LargestRectangleinHistogram {
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> st = new Stack<Integer>();
		int i = 0, maxarea = 0, area;
		
		while (i < heights.length) {
			if (st.isEmpty() || heights[st.peek()] <= heights[i]) {
				st.push(i++); // �ұߵĸ߾ͼ���ջ��ջ������0��1��2����������Ԫ�ص��±�
			} else { // �ұߵĵ���ջ���ĸ߶�
				int tp = st.pop(); // iΪ�ұߵ�һ����ջ��Ԫ��С��Ԫ�ص��±�
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
