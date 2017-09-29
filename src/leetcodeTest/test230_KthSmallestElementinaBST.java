package leetcodeTest;

public class test230_KthSmallestElementinaBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	/**
	 * 1、计算左子树元素个数left。
	 * 2、 left+1 = K，则根节点即为第K个元素
	 * left >=k, 则第K个元素在左子树中，
	 * left +1 <k, 则转换为在右子树中，寻找第K-left-1元素。
	 */
	public int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return 0;
		}
		int leftSize = calcTreeSize(root.left);
		if (k == leftSize + 1) {
			return root.val; // left+1 = K，则根节点即为第K个元素
		} else if (leftSize >= k) {
			return kthSmallest(root.left, k); // 左子树中
		} else {
			return kthSmallest(root.right, k - leftSize - 1); // left +1 <k, 则转换为在右子树中，寻找第K-left-1元素。
		}
	}
	
	private int calcTreeSize(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + calcTreeSize(root.left) + calcTreeSize(root.right);
	}
}
