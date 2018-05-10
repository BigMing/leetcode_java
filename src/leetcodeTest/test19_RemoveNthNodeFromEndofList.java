package leetcodeTest;

public class test19_RemoveNthNodeFromEndofList {
	/*
	 * Given linked list: 1->2->3->4->5, and n = 2. After removing the second
	 * node from the end, the linked list becomes 1->2->3->5.
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/*
	 * 1.�ȼ��������ĳ���len���ٸ��������Ҫɾ����Ԫ�ص����� 2.����ͷ���Ĳ�����
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode ptr1 = head;
		int count = 1; // ����
		while (ptr1.next != null) {
			ptr1 = ptr1.next;
			count++;
		}
		n = count - n; // ����5-2=3,��Ҫɾ����Ԫ�ص�ǰһ��Ԫ��
		if (n == 0) { // ����Ҫɾ����һ��Ԫ��
			ptr1 = head;
			head = head.next; // �����˵�һ��Ԫ�أ���ɾ���˵�һ��Ԫ��
			return head; // delete ptr1
		}
		ptr1 = head;
		ListNode ptr2 = head;
		while (n-- > 0) { // 3,2,1
			ptr1 = ptr1.next;
		} // �ҵ�Ҫɾ����Ԫ��
		while (ptr2 != ptr1 && ptr2.next != ptr1) {
			ptr2 = ptr2.next;
		} // �ҵ�Ҫɾ����ǰһ��Ԫ��
		ptr2.next = ptr1.next;
		return head; // delete ptr1
	}
}
