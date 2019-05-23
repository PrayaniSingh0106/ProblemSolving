package PracticeI;

public class AddNums {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode dummyHead = new ListNode(0);
		ListNode l3 = dummyHead;
		int carry = 0;
		int val = 0;

		while (l1 != null && l2 != null) {

			val = l1.val + l2.val + carry;

			if (val >= 10) {
				val = val % 10;
				carry = 1;
			} else
				carry = 0;

			ListNode newNode = new ListNode(val);
			l3.next = newNode;

			l1 = l1.next;
			l2 = l2.next;
			l3 = l3.next;
		}

		while (l1 != null) {

			val = l1.val + carry;

			if (val >= 10) {
				val = val % 10;
				carry = 1;
			} else
				carry = 0;

			ListNode newNode = new ListNode(val);
			l3.next = newNode;

			l1 = l1.next;
			l3 = l3.next;
		}

		while (l2 != null) {
			val = l2.val + carry;

			if (val >= 10) {
				val = val % 10;
				carry = 1;
			} else
				carry = 0;

			ListNode newNode = new ListNode(val);
			l3.next = newNode;

			l2 = l2.next;
			l3 = l3.next;
		}

		if (carry == 1) {

			ListNode newNode = new ListNode(1);
			l3.next = newNode;
			l3 = l3.next;
		}

		return dummyHead.next;
	}
}
