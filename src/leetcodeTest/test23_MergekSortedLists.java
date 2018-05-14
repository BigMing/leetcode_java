package leetcodeTest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class test23_MergekSortedLists {
	/*
	 * Input:[1->4->5,1->3->4,2->6],Output: 1->1->2->3->4->4->5->6
	 */
	public class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		int size = lists.length;
		if (size == 0) {
			return null;
		}
		if (size == 1) {
			return lists[0];
		}
		/*
		 * 在Java里面heap的implementation是PriorityQueue。
		 * Parameters:
		 * initialCapacity the initial capacity for this priority queue
		 * comparator the comparator that will be used to order this priority queue. 
		 * If null, the natural ordering of the elements will be used.
		 */
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(2, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode node1, ListNode node2) {
				return node1.val - node2.val;
			}
		});
		for (ListNode node : lists) { // 把每个链表首节点放入heap
			if (node != null) {
				heap.add(node);
			}
		}
		ListNode head = null;
		ListNode cur = null;
		while (!heap.isEmpty()) {
			ListNode node = heap.poll(); // Retrieves and removes the head of this queue, or returns null if this queue is empty.
			if (node.next != null) { // 弹出最小的之后放入它的next
				heap.add(node.next);
			}
			if (head == null) { // 赋值头节点
				head = node;
				cur = node;
			} else { // 依次链接
				cur.next = node;
				cur = cur.next;
			}
		}
		return head;
	}
}
