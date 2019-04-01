package trees;

class LNode {
	LNode next;
	int val;

	LNode(int val) {
		this.val = val;
		next = null;
	}
}

public class LoopDetect {
	static LNode head;
	

	public static boolean detectCycle() {

		
		LNode runner = head, itr = head;

		while (runner.next != null && itr != null) {

			runner = runner.next.next;
			itr = itr.next;

			if (itr == runner)
				return true;
			else if (runner == null)
				return false;
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoopDetect list = new LoopDetect();
		list.head = new LNode(1);
		list.head.next= new LNode(2);
		list.head.next.next= new LNode(3);
		list.head.next.next.next= new LNode(5);

		list.head.next.next.next.next= new LNode(5);
		list.head.next.next.next.next=list.head.next;
		
		System.out.println(detectCycle());
		
		//list.detectCycle(head);
	}

}
