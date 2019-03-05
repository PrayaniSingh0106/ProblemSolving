package leetCode;

public class LinkedListReverse {
	/**
	 * Definition for singly-linked list. 
	 * public class ListNode { 
	 * int val; 
	 * ListNode next; 
	 * ListNode(int x) { val = x; } }
	 */
	public ListNode reverseList(ListNode head) {

		ListNode prev = null;
		return reverseListNode(head, prev);
	}

	public ListNode reverseListNode(ListNode head, ListNode prev) {

		if (head == null)
			return prev;

		ListNode top = head;
		ListNode temp;

		while (top != null) {
			top.next = prev;

		}
		return top;
	}

}
