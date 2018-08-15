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
	 * ��һ��ѭ�����ҳ���������ĳ��Ȳ�N �ڶ���ѭ��������������N����Ȼ��ͬʱ�ƶ����ж��Ƿ�����ͬ�ڵ�
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
		} // ����count��¼
		if (p != q) // ���һ���ڵ㲻ͬ�����ؿ�
			return null;
		p = headA;
		q = headB;
		while (pcount-- != 0) {
			p = p.next;
		}
		while (qcount-- != 0) {
			q = q.next;
		} // β������
		while (p != q) {
			p = p.next;
			q = q.next;
		}
		return p;
	}
}
