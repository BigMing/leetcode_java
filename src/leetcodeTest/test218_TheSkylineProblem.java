package leetcodeTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class test218_TheSkylineProblem {
	// 线段树节点
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
		TreeNode root = new TreeNode(0, Integer.MAX_VALUE, 0); // 构造根节点，水平线
		for (int i = 0; i < buildings.length; i++) {
			insert(root, buildings[i][0], buildings[i][1] - 1, buildings[i][2]); // 左，右，高度

		}
		List<int[]> ans = new ArrayList<int[]>();
		buildans(root, ans, 0);
		return ans;
	}

	private void buildans(TreeNode root, List<int[]> ans, int lastH) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) { // 叶节点
			if (root.h != lastH) {
				lastH = root.h;
				ans.add(new int[] { root.st, root.h });
			}
		} else { // 非叶节点
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
		if (root.left == null && root.right == null) { // 叶子节点
			if (st <= root.st && ed >= root.ed) { // 不需要分裂
				root.h = Math.max(root.h, h);
			} else {
				if (root.st < st) { // 左边需要分裂[root.st,st-1][st,root.ed]
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
		} else { // 非叶节点
			insert(root.left, st, ed, h);
			insert(root.right, st, ed, h);
		}
	}

	/*
	 * 把每一个building拆成两个edge，一个入一个出。所有的edge加入到一个list中。再对这个list进行排序，
	 * 排序顺序为：如果两个边的position不一样，那么按pos排，否则根据edge是入还是出来排。
	 * 根据position从前到后扫描每一个edge，将edge根据是入还是出来将当前height加入或者移除heap。
	 * 再得到当前最高点来决定是否加入最终结果。
	 */
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> result = new ArrayList<>();
		List<int[]> height = new ArrayList<>();
		for (int[] b : buildings) {
			height.add(new int[] { b[0], -b[2] }); // 入边
			height.add(new int[] { b[1], b[2] }); // 出边
		}
		Collections.sort(height, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) // 先按照边的位置排序
					return a[0] - b[0];
				return a[1] - b[1]; // 再按照出入边排序，入边为负，在前
			}
		});
		// 优先队列要重写排序方法
		Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b - a; // 从大到小
			}
		});
		pq.offer(0); // 插入0
		int prev = 0;
		for (int[] h : height) {
			if (h[1] < 0) { // 如果是入边
				pq.offer(-h[1]); // 插入
			} else { // 如果是出边
				pq.remove(h[1]); // 删除
			}
			int cur = pq.peek(); // 获得优先队列的第一个元素，最大
			if (prev != cur) {
				result.add(new int[] { h[0], cur });
				prev = cur;
			}
		}
		return result;
	}
}
