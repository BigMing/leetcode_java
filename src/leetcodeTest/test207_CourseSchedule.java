package leetcodeTest;

import java.util.LinkedList;
import java.util.Queue;

public class test207_CourseSchedule {
	/*
	 * Example 1:
	 * 
	 * Input: 2, [[1,0]] Output: true Explanation: There are a total of 2
	 * courses to take. To take course 1 you should have finished course 0. So
	 * it is possible. Example 2:
	 * 
	 * Input: 2, [[1,0],[0,1]] Output: false Explanation: There are a total of 2
	 * courses to take. To take course 1 you should have finished course 0, and
	 * to take course 0 you should also have finished course 1. So it is
	 * impossible.
	 */
	/*
	 * 求图中是否有环存在
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] map = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			map[prerequisites[i][1]]++; // map[i]记录下[i]的出度
		}
		Queue<Integer> que = new LinkedList<Integer>();
		for (int i = 0; i < map.length; i++) {
			if (map[i] == 0) // 出度为0的入队列
				que.add(i);
		}
		int count = que.size();
		while (!que.isEmpty()) {
			int k = que.remove(); // 弹出出度为0的点k
			for (int i = 0; i < prerequisites.length; i++) {
				if (k == prerequisites[i][0]) { // 弹出的需要某个前序节点
					int l = prerequisites[i][1]; // 用l记录k前序的点
					map[l]--; // l的出度--
					if (map[l] == 0) { // l的出度为0时
						que.add(l); // l加入队列
						++count;
					}
				}
			}
		}
		return count == numCourses;
	}
}
