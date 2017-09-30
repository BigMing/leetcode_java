package leetcodeTest;

public class test108_ConvertSortedArraytoBinarySearchTree {
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
        a= nums;
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
