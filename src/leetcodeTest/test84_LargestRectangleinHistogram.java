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
				st.push(i++); // �ұߵĸ߾ͼ���ջ��ջ������0��1��2����������Ԫ�ص��±�
			} else { // �ұߵĵ���ջ���ĸ߶�
				int tp = st.pop(); // iΪ�ұߵ�һ����ջ��Ԫ��С��Ԫ�ص��±�
				area = heights[tp] * (st.empty() ? i : i - st.peek() - 1);
				if (area > maxarea) {
					maxarea = area;
				}
			}
		} // ����߶�һ�¶��ǵ����ľ�һֱѹ��ջ��һ������һ���߶ȼ�С�ģ��ͼ���ջ�����ܹ���ɵ�����ı��������һ������ջ�ֱ�����ı��������
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
