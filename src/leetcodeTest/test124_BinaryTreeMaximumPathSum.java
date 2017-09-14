package leetcodeTest;

public class test124_BinaryTreeMaximumPathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	int ans;
	/**
	 * ��ǰ�ڵ��������ֵ��ǰ�����
	 * @param r
	 * @return
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
			temp = Math.max(temp, r.val); // �ӽڵ��ֵ�п����Ǹ���
			// ���ǽڵ��и��������
			ans = Math.max(ans, temp);
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
