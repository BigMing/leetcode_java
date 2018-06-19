package leetcodeTest;

import java.util.LinkedList;
import java.util.Queue;

public class test210_CourseScheduleII {
	/*
	 * Example 1:
	 * 
	 * Input: 2, [[1,0]] Output: [0,1] Explanation: There are a total of 2
	 * courses to take. To take course 1 you should have finished course 0. So
	 * the correct course order is [0,1] . Example 2:
	 * 
	 * Input: 4, [[1,0],[2,0],[3,1],[3,2]] Output: [0,1,2,3] or [0,2,1,3]
	 * Explanation: There are a total of 4 courses to take. To take course 3 you
	 * should have finished both courses 1 and 2. Both courses 1 and 2 should be
	 * taken after you finished course 0. So one correct course order is
	 * [0,1,2,3]. Another correct ordering is [0,2,1,3] .
	 */
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] map = new int[numCourses];
		int n = prerequisites.length;
		int[] res = new int[numCourses];

		for (int i = 0; i < n; i++) {
			map[prerequisites[i][1]]++; // 记录出度
		}

		Queue<Integer> que = new LinkedList<Integer>();
		int index = numCourses - 1;
		for (int i = 0; i < numCourses; i++) {
			if (map[i] == 0) { // 出度=0
				que.add(i); // 加入队列
				res[index--] = i; // 放入结果集末尾
			}
		}

		while (!que.isEmpty()) {
			int k = que.remove(); // 出队列，出度=0的节点
			for (int i = 0; i < n; i++) {
				int l = prerequisites[i][1];
				if (k == prerequisites[i][0]) { // 找k的前序l
					map[l]--; // l出度--
					if (map[l] == 0) { // l出度减为0时
						que.add(l); // l入队
						res[index--] = l; // l从后放入结果集
					}
				}
			}
		}
		if (index != -1) // 说明不存在刚好完成的拓扑排序
			return new int[0];
		else
			return res;
	}
}
