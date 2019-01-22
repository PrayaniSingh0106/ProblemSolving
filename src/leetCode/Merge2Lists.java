package leetCode;

public class Merge2Lists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode l1 = new ListNode(-9);
		l1.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(7);
		
		ListNode l3 = mergeTwoLists(l1, l2);
		System.out.println("List node 3 : " + l3.val + l3.next.val + l3.next.next.val + l3.next.next.next.val );

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		//int len1 = 0, len2 = 0;
		ListNode head1 = l1;
		ListNode head2 = l2;
		ListNode l3 = new ListNode(0);
		ListNode head3 = l3;
		
		/*while (!(head1 == null)) {
			head1 = head1.next;
			len1++;
		}

		while (!(head2 == null)) {
			head2 = head2.next;
			len2++;
		}
	*/
		head1 = l1;
		head2 = l2;
		
		while (head1 != null && head2 != null) {
				
			if (head1.val < head2.val) {
					l3.next = head1;
					head1 = head1.next;
				}
				else {
					l3.next = head2;
					head2 = head2.next;

				}
					
				l3 = l3.next;

			}
		while(head1 != null) {
			l3.next = head1;
			head1 = head1.next;
			l3 = l3.next;
		}
		while(head2 != null) {
			l3.next = head2;
			head2 = head2.next;
			l3 = l3.next;
		}

		return head3.next;
	}

}
