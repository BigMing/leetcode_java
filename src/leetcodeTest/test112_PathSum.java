package leetcodeTest;

public class test112_PathSum {
	/*
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf
	 * path such that adding up all the values along the path equals the given
	 * sum.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		} else if (root.left == null && root.right == null && root.val == sum) {
			return true;
		} else {
			return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
		}
	}

	/**
	 * 前序遍历，深度优先
	 * 
	 * @param r
	 * @param want
	 * @param now
	 * @return
	 */
	public boolean visit(TreeNode r, int want, int now) {
		if (r == null) {
			return false;
		}
		if (r.left == null && r.right == null) { // 叶节点
			return (now + r.val == want);
		} else { // 非叶节点
			return visit(r.left, want, now + r.val) || visit(r.right, want, now + r.val);
		}
	}
}
