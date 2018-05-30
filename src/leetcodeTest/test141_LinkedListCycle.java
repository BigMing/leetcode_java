package leetcodeTest;

public class test141_LinkedListCycle {
	/*
	 * Given a linked list, determine if it has a cycle in it.
	 * 
	 * Follow up: Can you solve it without using extra space?
	 */
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		ListNode p = head; // 快指针
		ListNode q = head; // 慢指针
		while (p != null && q != null && p.next != null) { // 边界条件是出现空指针，就返回false；
			q = q.next;
			p = p.next.next; // 空指针没有next，否则会出现NullPointerException问题
			if (p == q)
				return true;
		}
		return false;
	}
}
