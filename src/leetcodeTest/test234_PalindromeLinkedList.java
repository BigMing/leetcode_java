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
	 * 反转链表法，将链表后半段原地翻转，再将前半段、后半段依次比较，判断是否相等，时间复杂度O（n），空间复杂度为O（1）满足题目要求
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

	// 快慢指针查找中点
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

	// 反转List
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
