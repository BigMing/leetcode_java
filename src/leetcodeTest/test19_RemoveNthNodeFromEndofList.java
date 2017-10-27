package leetcodeTest;

public class test19_RemoveNthNodeFromEndofList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	/**
	 * 1.先计算出链表的长度len，再根据其求出要删除的元素的正序。
	 * 2.考虑头结点的操作。
	 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr1 = head;
        int count = 1; // 长度
        while (ptr1.next != null) {
			ptr1 = ptr1.next;
			count++;
		}
        n = count - n; // 正序5-2=3,是要删除的元素的前一个元素
        if (n == 0) { // 就是要删除第一个元素
			ptr1 = head;
			head = head.next; // 跳过了第一个元素，即删除了第一个元素
			// delete ptr1
			return head;
		}
        ptr1 = head;
        ListNode ptr2 = head;
        while (n-- > 0) { // 3,2,1
			ptr1 = ptr1.next;
		} // 找到要删除的元素
        while (ptr2 != ptr1 && ptr2.next != ptr1) {
			ptr2 = ptr2.next;
		} // 找到要删除的前一个元素
        ptr2.next = ptr1.next;
        // delete ptr1
        return head;
    }
}
