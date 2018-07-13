package leetcodeTest;

public class test148_SortList {
	/*
	 * Sort a linked list in O(n log n) time using constant space complexity.
	 */
	/*
	 * ֪ʶ��1���鲢���������˼�� ֪ʶ��2���ҵ�һ��������м�ڵ�ķ��� ֪ʶ��3���ϲ��������ź��������Ϊһ���µ���������
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) // �ݹ���� ��ֻ��һ���ڵ�ʱ�Ͳ��ٵݹ�
			return head;
		ListNode middle = getMiddleOfList(head);
		ListNode next = middle.next;
		middle.next = null; // ����������Ͽ���Ϊ��ߣ�����middle��һ����ұ�һ��
		return mergeTwoList(sortList(head), sortList(next));
	}

	public ListNode getMiddleOfList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode mergeTwoList(ListNode headA, ListNode headB) {
		ListNode fakeNode = new ListNode(0);
		ListNode cur = fakeNode;
		while (headA != null && headB != null) {
			if (headA.val <= headB.val) {
				cur.next = headA;
				headA = headA.next;
			} else {
				cur.next = headB;
				headB = headB.next;
			}
			cur = cur.next;
		}
		cur.next = headA == null ? headB : headA;
		return fakeNode.next;
	}
}
