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
	 * ����˼·���ȱ���������������ƥ��ĵ㣬û�з���null�� �����������������ƥ��ĵ㣬û�з���null�����left��right����Ϊnull��
	 * ����ڵ������ǵĹ�ͬ�ڵ㡣���leftΪ�գ��������ڵ㶼��������������right�����rightΪ�գ��������ڵ㶼��������������left.
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
