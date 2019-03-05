package leetCode;

public class LinkedListIntersection {

	
	ListNode hA;
	ListNode hB;
	
	public static ListNode getIntersec(ListNode headA, ListNode headB) {
		
		ListNode headI = headA;
		ListNode headII = headB;
		ListNode longer, shorter;
		
		int lenA = 0, lenB = 0;
		ListNode l = null;
		int diff = 0;
		
		
		while(headI!=null) {
			lenA++; 
			headI = headI.next ;
			System.out.println("headI "+headI);
		}
		
		while(headII!=null) {
			headII = headII.next ;
			lenB++;
		}
		
		if(lenA > lenB) {
			diff = lenA - lenB;
			longer = headA;
			shorter = headB;
			}
		else {
			diff = lenB - lenA;
			longer = headB;
			shorter = headA;
		}
		
		while(diff!=0) {
			longer = longer.next;
			diff--;
		}
		
		while(longer!=null) {
			
			if(longer == shorter)
				return longer;
			longer = longer.next;
			shorter = shorter.next;
			
		}
		
		return l;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListIntersection lli = new LinkedListIntersection();
		lli.hA = new ListNode(5);
		lli.hA.next = new ListNode(2);
		lli.hA.next.next = new ListNode(3);
		lli.hA.next.next.next = new ListNode(10);
		lli.hA.next.next.next.next = new ListNode(9);
		
		lli.hB = new ListNode(6);
		lli.hB.next = new ListNode(14);
		lli.hB.next.next = new ListNode(12);
		lli.hB.next.next.next = lli.hA.next.next;
		lli.hB.next.next.next.next = lli.hA.next.next.next;
		lli.hB.next.next.next.next.next = lli.hA.next.next.next.next;
		
		ListNode n = getIntersec(lli.hA,lli.hB);
		System.out.println("Intersec: " + n.val);
		
	}

}
