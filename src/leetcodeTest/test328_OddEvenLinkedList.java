package leetcodeTest;

public class test328_OddEvenLinkedList {
	/*
	 * 
	 * Given a singly linked list, group all odd nodes together followed by the
	 * even nodes. Please note here we are talking about the node number and not
	 * the value in the nodes.
	 * 
	 * You should try to do it in place. The program should run in O(1) space
	 * complexity and O(nodes) time complexity.
	 * 
	 * Example 1:
	 * 
	 * Input: 1->2->3->4->5->NULL Output: 1->3->5->2->4->NULL Example 2:
	 * 
	 * Input: 2->1->3->5->6->4->7->NULL Output: 2->3->6->7->1->5->4->NULL
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return head;
		ListNode oddHead = head, evenHead = head.next; // 奇偶头节点
		ListNode prevOdd = oddHead, prevEven = evenHead;

		while (prevOdd.next != null && prevEven.next != null) {
			prevOdd.next = prevEven.next;
			prevOdd = prevOdd.next;

			prevEven.next = prevOdd.next;
			prevEven = prevEven.next;
		}
		prevOdd.next = evenHead; // 奇数后连上偶数

		return oddHead;
	}
}
