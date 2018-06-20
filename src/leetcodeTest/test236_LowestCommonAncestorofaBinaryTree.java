package leetcodeTest;

public class test236_LowestCommonAncestorofaBinaryTree {
	/*
	 * Given a binary tree, find the lowest common ancestor (LCA) of two given
	 * nodes in the tree.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * 解题思路：先遍历左子树，返回匹配的点，没有返回null。 后遍历右子树，返回匹配的点，没有返回null。如果left和right都不为null，
	 * 则根节点是它们的共同节点。如果left为空，则两个节点都在右子树，返回right。如果right为空，则两个节点都在左子树，返回left.
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}
}
