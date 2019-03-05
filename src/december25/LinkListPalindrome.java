package december25;

public class LinkListPalindrome {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public boolean isPalindrome(ListNode head) {
		int n = length(head);
		
		ListNode pre=head;
		ListNode post;
		//ListNode headCpy = head;
		ListNode temp=head ;
		
		int mid = n/2;
		
		for(int i=0;i<mid;i++) {
			temp.next=pre.next;
			
			temp.next = temp;
			temp = pre.next.next;
			pre=pre.next;
			
		}
		return true;

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
