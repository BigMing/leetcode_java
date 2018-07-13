package leetcodeTest;

public class test148_SortList {
	/*
	 * Sort a linked list in O(n log n) time using constant space complexity.
	 */
	/*
	 * 知识点1：归并排序的整体思想 知识点2：找到一个链表的中间节点的方法 知识点3：合并两个已排好序的链表为一个新的有序链表
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) // 递归出口 当只有一个节点时就不再递归
			return head;
		ListNode middle = getMiddleOfList(head);
		ListNode next = middle.next;
		middle.next = null; // 把两个链表断开分为左边（包括middle）一半和右边一半
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
