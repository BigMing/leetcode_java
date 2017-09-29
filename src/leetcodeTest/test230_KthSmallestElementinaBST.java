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
	 * 1������������Ԫ�ظ���left��
	 * 2�� left+1 = K������ڵ㼴Ϊ��K��Ԫ��
	 * left >=k, ���K��Ԫ�����������У�
	 * left +1 <k, ��ת��Ϊ���������У�Ѱ�ҵ�K-left-1Ԫ�ء�
	 */
	public int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return 0;
		}
		int leftSize = calcTreeSize(root.left);
		if (k == leftSize + 1) {
			return root.val; // left+1 = K������ڵ㼴Ϊ��K��Ԫ��
		} else if (leftSize >= k) {
			return kthSmallest(root.left, k); // ��������
		} else {
			return kthSmallest(root.right, k - leftSize - 1); // left +1 <k, ��ת��Ϊ���������У�Ѱ�ҵ�K-left-1Ԫ�ء�
		}
	}
	
	private int calcTreeSize(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + calcTreeSize(root.left) + calcTreeSize(root.right);
	}
}
