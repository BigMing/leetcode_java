package leetcodeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class test144_BinaryTreePreorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	public List<Integer> list = new ArrayList<Integer>();
	public List<Integer> preorderTraversal(TreeNode root) {
		preOrder(root);
		return list;
	}
	public void preOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		list.add(node.val);
		if (node.left != null) {
			preOrder(node.left);
		}
		if (node.right != null) {
			preOrder(node.right);
		}
	}
	
	/**
     * �ǵݹ鷽ʽ
     */
	public List<Integer> preorderTraversal2(TreeNode root) {
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode tempNode = null;
		while (!stack.isEmpty()) {
			tempNode = stack.pop();
			list.add(tempNode.val);
			if (tempNode.right != null) {
				stack.push(tempNode.right);
			}
			if (tempNode.left != null) {
				stack.push(tempNode.left);
			}
		}
		return list;
	}
}
