package audible;

public class LLHasCycle {
	public boolean hasCycle(ListNode head) {

		ListNode runner = head, itr = head;

		while (runner != null && itr != null && runner.next != null) {
			runner = runner.next.next;
			itr = itr.next;

			if (runner == itr)
				return true;
			else if (runner == null)
				return false;
		}
		return false;
	}
}
