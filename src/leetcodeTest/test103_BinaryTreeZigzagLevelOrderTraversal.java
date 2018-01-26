package leetcodeTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test103_BinaryTreeZigzagLevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		levelRecursion(root, result, 0);

		return result;
	}

	private void levelRecursion(TreeNode node, List<List<Integer>> result, int level) {
		if (node == null) {
			return;
		}
		if (result.size() < level + 1) { // 说明还需要添加一行
			result.add(new LinkedList<Integer>()); // 结果集里加一行
		}
		if (level % 2 != 0) { // 0 % 2 == 0; 1 % 2 != 0
			((LinkedList<Integer>) result.get(level)).addFirst(node.val);
		} else {
			result.get(level).add(node.val);
		}

		levelRecursion(node.left, result, level + 1);
		levelRecursion(node.right, result, level + 1);
	}
}
