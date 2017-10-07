package leetcodeTest;

public class test307_RangeSumQueryMutable {
	class TreeNode {
		int start = 0;
		int end = 0;
		int sum = 0;
		TreeNode left = null;
		TreeNode right = null;
	}

	TreeNode root = null;

	public void init(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		this.root = buildTree(0, nums.length - 1, nums);
	}

	public TreeNode buildTree(int start, int end, int[] data) {
		TreeNode t = new TreeNode();
		t.start = start;
		t.end = end;
		if (start == end) { // 构造线段树终止条件
			t.sum = data[start];
			return t;
		}
		int mid = start + (end - start) / 2;
		t.left = buildTree(start, mid, data);
		t.right = buildTree(mid + 1, end, data);
		t.sum = t.left.sum + t.right.sum;
		return t;
	}

	public void NumArray(int[] nums) {
	        init(nums);
	    }

	public void updateTree(TreeNode node, int index, int val) {
		if (node == null)
			return;
		if (node.start == node.end) {
			node.sum = val;
			return;
		}
		int mid = node.start + (node.end - node.start) / 2;
		if (index <= mid) {
			updateTree(node.left, index, val);
		} else {
			updateTree(node.right, index, val);
		}
		node.sum = node.left.sum + node.right.sum; // 整个线段树都更新
	}

	public void update(int i, int val) {
		updateTree(this.root, i, val);
	}

	public int queryTree(TreeNode node, int left, int right) {
		if (node == null)
			return 0;
		if (node.start == left && node.end == right)
			return node.sum;
		int mid = node.start + (node.end - node.start) / 2;
		if (mid >= right) {
			return queryTree(node.left, left, right);
		} else if (mid < left) {
			return queryTree(node.right, left, right);
		} else {
			return queryTree(node.left, left, mid) + queryTree(node.right, mid + 1, right);
		}
	}

	public int sumRange(int i, int j) {
		return queryTree(this.root, i, j);
	}
}
