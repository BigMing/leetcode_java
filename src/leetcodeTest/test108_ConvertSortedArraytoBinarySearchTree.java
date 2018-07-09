package leetcodeTest;

public class test108_ConvertSortedArraytoBinarySearchTree {
	/*
	 * Given an array where elements are sorted in ascending order, convert it
	 * to a height balanced BST. For this problem, a height-balanced binary tree
	 * is defined as a binary tree in which the depth of the two subtrees of
	 * every node never differ by more than 1.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int[] a;

	public TreeNode sortedArrayToBST(int[] nums) {
		a = nums;
		return build(0, a.length - 1);
	}

	private TreeNode build(int st, int ed) {
		if (st > ed) {
			return null;
		}
		int mid = ed - (ed - st) / 2;
		TreeNode r = new TreeNode(a[mid]);
		r.left = build(st, mid - 1);
		r.right = build(mid + 1, ed);
		return r;
	}
}
