package leetcodeTest;

public class test206_ReverseLinkedList {
	/*
	 * Reverse a singly linked list.
	 * 
	 * Example:
	 * 
	 * Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) { // 递归
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode p = head.next; // 第二个
		ListNode n = reverseList(p); // 递归调用到最后一个
		head.next = null;
		p.next = head;
		return n;
	}

	public ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pre = head; // 0
		ListNode p = head.next; // 1
		pre.next = null;
		ListNode nxt;
		while (p != null) {
			nxt = p.next;
			p.next = pre;
			pre = p;
			p = nxt;
		}
		return pre;
	}
}
