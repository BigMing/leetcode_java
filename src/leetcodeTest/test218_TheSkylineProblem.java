package leetcodeTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class test218_TheSkylineProblem {
	// �߶����ڵ�
	class TreeNode {
		int st;
		int ed;
		int h;
		TreeNode left;
		TreeNode right;

		TreeNode(int s, int e, int h) {
			st = s;
			ed = e;
			this.h = h;
			left = null;
			right = null;
		}
	}

	public List<int[]> getSkyline1(int[][] buildings) {
		TreeNode root = new TreeNode(0, Integer.MAX_VALUE, 0); // ������ڵ㣬ˮƽ��
		for (int i = 0; i < buildings.length; i++) {
			insert(root, buildings[i][0], buildings[i][1] - 1, buildings[i][2]); // ���ң��߶�

		}
		List<int[]> ans = new ArrayList<int[]>();
		buildans(root, ans, 0);
		return ans;
	}

	private void buildans(TreeNode root, List<int[]> ans, int lastH) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) { // Ҷ�ڵ�
			if (root.h != lastH) {
				lastH = root.h;
				ans.add(new int[] { root.st, root.h });
			}
		} else { // ��Ҷ�ڵ�
			buildans(root.left, ans, lastH);
			buildans(root.right, ans, lastH);
		}
	}

	private void insert(TreeNode root, int st, int ed, int h) {
		if (root == null) {
			return;
		}
		if (root.st > ed || root.ed < st) {
			return;
		}
		if (root.left == null && root.right == null) { // Ҷ�ӽڵ�
			if (st <= root.st && ed >= root.ed) { // ����Ҫ����
				root.h = Math.max(root.h, h);
			} else {
				if (root.st < st) { // �����Ҫ����[root.st,st-1][st,root.ed]
					root.left = new TreeNode(root.st, st - 1, root.h);
					root.right = new TreeNode(st, root.ed, root.h);
					insert(root.right, st, ed, h);
				} else {
					if (root.ed > ed) { // [root.st,ed][ed+1,root.ed]
						root.left = new TreeNode(root.st, ed, root.h);
						root.right = new TreeNode(ed + 1, root.ed, root.h);
						insert(root.left, st, ed, h);
					}
				}
			}
		} else { // ��Ҷ�ڵ�
			insert(root.left, st, ed, h);
			insert(root.right, st, ed, h);
		}
	}

	/*
	 * ��ÿһ��building�������edge��һ����һ���������е�edge���뵽һ��list�С��ٶ����list��������
	 * ����˳��Ϊ����������ߵ�position��һ������ô��pos�ţ��������edge���뻹�ǳ����š�
	 * ����position��ǰ����ɨ��ÿһ��edge����edge�������뻹�ǳ�������ǰheight��������Ƴ�heap��
	 * �ٵõ���ǰ��ߵ��������Ƿ�������ս����
	 */
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> result = new ArrayList<>();
		List<int[]> height = new ArrayList<>();
		for (int[] b : buildings) {
			height.add(new int[] { b[0], -b[2] }); // ���
			height.add(new int[] { b[1], b[2] }); // ����
		}
		Collections.sort(height, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) // �Ȱ��ձߵ�λ������
					return a[0] - b[0];
				return a[1] - b[1]; // �ٰ��ճ�����������Ϊ������ǰ
			}
		});
		// ���ȶ���Ҫ��д���򷽷�
		Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b - a; // �Ӵ�С
			}
		});
		pq.offer(0); // ����0
		int prev = 0;
		for (int[] h : height) {
			if (h[1] < 0) { // ��������
				pq.offer(-h[1]); // ����
			} else { // ����ǳ���
				pq.remove(h[1]); // ɾ��
			}
			int cur = pq.peek(); // ������ȶ��еĵ�һ��Ԫ�أ����
			if (prev != cur) {
				result.add(new int[] { h[0], cur });
				prev = cur;
			}
		}
		return result;
	}
}
