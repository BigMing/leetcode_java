package leetcodeTest;

public class test21_MergeTwoSortedLists {
	/*
	 * Input: 1->2->4, 1->3->4,Output: 1->1->2->3->4->4
	 */
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null && l2 != null)
			return l2;
		if (l1 != null && l2 == null)
			return l1;
		ListNode p = null; // ͷ
		ListNode q = p; // β
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				if (p == null) {
					p = l1;
					q = p;
					l1 = l1.next;
					continue;
				}
				q.next = l1;
				q = q.next;
				l1 = l1.next;
			} else {
				if (p == null) {
					p = l2;
					q = p;
					l2 = l2.next;
					continue;
				}
				q.next = l2;
				q = q.next;
				l2 = l2.next;
			}
		}
		while (l1 != null) {
			q.next = l1;
			q = q.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			q.next = l2;
			q = q.next;
			l2 = l2.next;
		}
		return p;
	}
}
