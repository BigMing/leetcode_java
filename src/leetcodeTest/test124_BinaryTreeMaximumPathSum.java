package leetcodeTest;

public class test124_BinaryTreeMaximumPathSum {
	/*
	 * For this problem, a path is defined as any sequence of nodes from some
	 * starting node to any node in the tree along the parent-child connections.
	 * The path must contain at least one node and does not need to go through
	 * the root.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int ans;

	/*
	 * 求当前节点为根的最大和，前序遍历
	 */
	public int maxDeep(TreeNode r) {
		if (r == null) {
			return 0;
		}
		if (r.left == null && r.right == null) {
			ans = Math.max(ans, r.val);
			return r.val;
		} else {
			int maxLeft = maxDeep(r.left);
			int maxRight = maxDeep(r.right);
			int temp = Math.max(maxLeft, maxRight) + r.val;
			temp = Math.max(temp, r.val); // 子节点的值有可能是负数
			
			ans = Math.max(ans, temp); // 考虑节点有负数的情况
			ans = Math.max(ans, maxLeft + maxRight + r.val);
			
			return temp;
		}
	}

	public int maxPathSum(TreeNode root) {
		ans = Integer.MIN_VALUE;
		maxDeep(root);
		return ans;
	}
}
