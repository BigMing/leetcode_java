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
	 * ��ͼ���Ƿ��л�����
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] map = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			map[prerequisites[i][1]]++; // map[i]��¼��[i]�ĳ���
		}
		Queue<Integer> que = new LinkedList<Integer>();
		for (int i = 0; i < map.length; i++) {
			if (map[i] == 0) // ����Ϊ0�������
				que.add(i);
		}
		int count = que.size();
		while (!que.isEmpty()) {
			int k = que.remove(); // ��������Ϊ0�ĵ�k
			for (int i = 0; i < prerequisites.length; i++) {
				if (k == prerequisites[i][0]) { // ��������Ҫĳ��ǰ��ڵ�
					int l = prerequisites[i][1]; // ��l��¼kǰ��ĵ�
					map[l]--; // l�ĳ���--
					if (map[l] == 0) { // l�ĳ���Ϊ0ʱ
						que.add(l); // l�������
						++count;
					}
				}
			}
		}
		return count == numCourses;
	}
}
