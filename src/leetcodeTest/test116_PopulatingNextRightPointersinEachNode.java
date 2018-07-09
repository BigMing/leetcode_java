package leetcodeTest;

public class test116_PopulatingNextRightPointersinEachNode {
	/*
	 * Populate each next pointer to point to its next right node. If there is
	 * no next right node, the next pointer should be set to NULL. Initially,
	 * all next pointers are set to NULL.
	 */
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		TreeLinkNode level_start = root;
		while (level_start != null) {
			TreeLinkNode cur = level_start;
			while (cur != null) { // 非空
				if (cur.left != null) // 左孩子非空
					cur.left.next = cur.right; // 左孩子->右孩子
				if (cur.right != null && cur.next != null)
					cur.right.next = cur.next.left;
				cur = cur.next;
			} // cur的next空了，找左孩子
			level_start = level_start.left;
		}
	}
}
