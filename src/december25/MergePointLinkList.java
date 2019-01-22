package december25;

import leetCode.ListNode;

public class MergePointLinkList {

	// Definition for singly-linked list.
	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode l1 = new ListNode(10);
		l1.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(7);

		ListNode l3 = getIntersectionNode(l1, l2);
		System.out.println("List node 3 : " + l3.val + l3.next.val + l3.next.next.val + l3.next.next.next.val);

	}

	public static ListNode getIntersectionNode(ListNode a, ListNode b) {

		int aLen = (int) Math.ceil(length(a));
		int bLen = length(b);
		ListNode mergeP = null;
		int d = Math.abs(aLen - bLen);
		ListNode temp;

		if (aLen > bLen) {
			temp = a;
			a = b;
			b = temp;
		}

		while (d != 0) {
			b = b.next;
			d--;
		}

		while (a != null && b != null) {
			if (a == b) {
				return a;
			}
			a = a.next;
			b = b.next;
		}

		return mergeP;

	}

	public static int length(ListNode x) {

		ListNode head = x;
		int length = 0;

		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}
}
