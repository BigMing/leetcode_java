package leetcodeTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test102_BinaryTreeLevelOrderTraversal {
	/*
	 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (root == null)
			return res;
		q.offer(root);
		int mark = 0;
		while (!q.isEmpty()) {
			mark = q.size(); // 用mark记录一层的个数
			List<Integer> tmpList = new ArrayList<Integer>();
			TreeNode tmpNode = new TreeNode(0);
			
			for (int i = 0; i < mark; i++) {
				tmpNode = q.poll();
				tmpList.add(tmpNode.val);
				if (tmpNode.left != null)
					q.offer(tmpNode.left);
				if (tmpNode.right != null)
					q.offer(tmpNode.right);
			}
			res.add(tmpList);
		}
		return res;
	}
}
