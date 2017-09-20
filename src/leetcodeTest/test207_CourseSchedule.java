package leetcodeTest;

import java.util.LinkedList;
import java.util.Queue;

public class test207_CourseSchedule {
	/**
	 * 求图中是否有环存在
	 * @param numCourses 一共有几门课
	 * @param prerequisites [[1,0],[0,1]] prerequisite pairs 此时是有环的
	 * @return
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] map = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			map[prerequisites[i][1]]++; // map[i]记录下[i]的出度
		}
		Queue<Integer> que = new LinkedList<Integer>();
		for (int i = 0; i < map.length; i++) {
			if (map[i] == 0) // 出度为0，接入队列
				que.add(i);
		}
		int count = que.size();
		while (!que.isEmpty()) {
			int k = que.remove(); // 弹出出度为0的点k
			for (int i = 0; i < prerequisites.length; i++) {
				if (k == prerequisites[i][0]) {
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
