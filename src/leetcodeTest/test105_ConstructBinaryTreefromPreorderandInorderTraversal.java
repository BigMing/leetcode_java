package leetcodeTest;

public class test105_ConstructBinaryTreefromPreorderandInorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
    public int[] pre;
	public int[] in;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        in = inorder;
        TreeNode r = build(0, pre.length - 1, 0, in.length - 1);
        return r;
    }
    
	private TreeNode build(int st1, int ed1, int st2, int ed2) {
		if (st1 > ed1) {
			return null;
		}
		TreeNode r = new TreeNode(pre[st1]); // 根节点是前序的第一个元素
		int find = -1;
		for (int i = st2; i <= ed2; i++) {
			if (in[i] == r.val) {
				find = i;
				break;
			}
		}
		if (find == -1) {
			return null;
		}
		int c = find - st2;
		r.left = build(st1 + 1, st1 + c, st2, find - 1);
		r.right = build(st1 + c + 1, ed1, find + 1, ed2);
		return r;
	}
}
