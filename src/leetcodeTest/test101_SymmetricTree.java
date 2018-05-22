package leetcodeTest;

public class test101_SymmetricTree {
	/*
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public boolean fun(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p != null && q != null && p.val == q.val) {
			return fun(p.left, q.right) && fun(p.right, q.left);
		}
		return false;
	}
	
    public boolean isSymmetric(TreeNode root) {
    	if (root == null) {
			return true;
		}
    	return fun(root.left, root.right);
    }
}
