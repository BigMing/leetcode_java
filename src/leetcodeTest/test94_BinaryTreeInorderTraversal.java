package leetcodeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class test94_BinaryTreeInorderTraversal {
	/*
	 * Input: [1,null,2,3]
	 * 1
	 *  \
	 *   2
	 *  /
	 * 3
	 * Output: [1,3,2]
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public static List<Integer> result = new ArrayList<>();

	public static List<Integer> inorderTraversal(TreeNode root, List<Integer> result) {
		if (root != null) {
			inorderTraversal(root.left, result);
			result.add(root.val);
			inorderTraversal(root.right, result);
		}
		return result;
	}
	
	public static List<Integer> inorderTraversal2(TreeNode root, List<Integer> result) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> nodeStack = new Stack<>();
		while (root != null || !nodeStack.isEmpty()) {
			while (root != null) {
				nodeStack.push(root);
				root = root.left;
			}
			TreeNode tempNode = nodeStack.pop();
			res.add(tempNode.val);
			root = tempNode.right;
		}
		return res;
	}
}
