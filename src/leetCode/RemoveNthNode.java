package leetCode;

public class RemoveNthNode {
	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode(int x) { val = x; } }
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode fast = head;
		ListNode slow = head;
		int count = 0;

		for (int i = 0; i < n; i++) {
			fast = fast.next;
			count++;
		}
		if (count == n && fast == null) {
			head = head.next;
			return head;
		}
		if (fast != null)
			fast = fast.next;

		while (fast != null && slow != null) {
			fast = fast.next;
			slow = slow.next;
		}

		if (slow.next != null)
			slow.next = slow.next.next;

		return head;
	}
}
