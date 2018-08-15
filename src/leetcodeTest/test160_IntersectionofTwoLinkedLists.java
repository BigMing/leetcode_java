package leetcodeTest;

public class test160_IntersectionofTwoLinkedLists {
	/*
	 * Write a program to find the node at which the intersection of two singly
	 * linked lists begins.
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/*
	 * 第一遍循环，找出两个链表的长度差N 第二遍循环，长链表先走N步，然后同时移动，判断是否有相同节点
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		ListNode p = headA;
		ListNode q = headB;
		int pcount = 0;
		int qcount = 0;
		while (p.next != null || q.next != null) {
			if (p == q)
				return p;
			if (p.next != null)
				p = p.next;
			else
				++qcount;
			if (q.next != null)
				q = q.next;
			else
				++pcount;
		} // 两个count记录
		if (p != q) // 最后一个节点不同，返回空
			return null;
		p = headA;
		q = headB;
		while (pcount-- != 0) {
			p = p.next;
		}
		while (qcount-- != 0) {
			q = q.next;
		} // 尾部对齐
		while (p != q) {
			p = p.next;
			q = q.next;
		}
		return p;
	}
}
