package audible;

class LNode{
	LNode next;
	int val;
	
	LNode(int val){
		this.val = val;
		next=null;
	}
}

public class DetectLoop {

	public static boolean findLoop(LNode x) {
		
		LNode head = x;
		LNode fast = head.next;
		LNode slow = head;
		LNode meetingP = null;
		LNode prev = null;
		boolean flag = false;
		
		while(fast.next!=null && slow!=null) {
			
			
			if(fast == slow) {
				meetingP = slow;
				flag = true;
				break;
			}
			slow = slow.next;
			fast=fast.next.next;
			
		}
		slow =head;
		prev = slow;
		while(slow!=null) {
			System.out.println(slow.val);
			
			if(prev == meetingP)
				prev.next = null;
			
			prev = slow;
			slow = slow.next;
		}
		
		return flag;		
	}
	
	public static void main(String[] args) {
		LNode head = new LNode(5);
		head.next = new LNode(10);
		head.next.next = new LNode(11);
		head.next.next.next = new LNode(2);
		head.next.next.next.next = new LNode(18);
		head.next.next.next.next.next = new LNode(7);
		head.next.next.next.next.next.next = head.next.next;
		System.out.println(findLoop(head));
	}
}

