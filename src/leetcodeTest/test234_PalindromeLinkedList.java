package leetcodeTest;

public class test234_PalindromeLinkedList {
	/*
	 * Given a singly linked list, determine if it is a palindrome.
	 * 
	 * Example 1:
	 * 
	 * Input: 1->2 Output: false Example 2:
	 * 
	 * Input: 1->2->2->1 Output: true
	 * 
	 * Could you do it in O(n) time and O(1) space?
	 */
	/*
	 * ��ת���������������ԭ�ط�ת���ٽ�ǰ��Ρ��������αȽϣ��ж��Ƿ���ȣ�ʱ�临�Ӷ�O��n�����ռ临�Ӷ�ΪO��1��������ĿҪ��
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		ListNode middle = partition(head);
		middle = reverseList(middle);

		while (head != null && middle != null) {
			if (head.val != middle.val) {
				return false;
			}
			head = head.next;
			middle = middle.next;
		}
		return true;
	}

	// ����ָ������е�
	private ListNode partition(ListNode head) {
		ListNode p = head;
		while (p.next != null && p.next.next != null) {
			p = p.next.next;
			head = head.next;
		}
		p = head.next;
		head.next = null;
		return p;
	}

	// ��תList
	private ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode temp = head.next;
		ListNode n = reverseList(temp);
		head.next = null;
		temp.next = head;
		return n;
	}
}
