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
		ListNode p = head; // ��ָ��
		ListNode q = head; // ��ָ��
		while (p != null && q != null && p.next != null) { // �߽������ǳ��ֿ�ָ�룬�ͷ���false��
			q = q.next;
			p = p.next.next; // ��ָ��û��next����������NullPointerException����
			if (p == q)
				return true;
		}
		return false;
	}
}
