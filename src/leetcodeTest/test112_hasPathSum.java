package leetcodeTest;

public class test112_hasPathSum {
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
	 * ǰ��������������
	 * @param r
	 * @param want
	 * @param now
	 * @return
	 */
	public boolean visit(TreeNode r, int want, int now) {
		if (r == null) {
			return false;
		}
		if (r.left == null && r.right == null) { // Ҷ�ڵ�
			return (now + r.val == want);
		} else { // ��Ҷ�ڵ�
			return visit(r.left, want, now + r.val) || visit(r.right, want, now + r.val);
		}
	}
}
