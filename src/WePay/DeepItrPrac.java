package WePay;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DeepItrPrac {

	private Stack stack = new Stack<>();
	private Integer top = null;

	public DeepItrPrac(Iterable listOfList) {
		this.stack.push(listOfList.iterator());
	}

	public boolean hasNext() {

		if (this.top != null)
			return true;

		Iterator topEl = (Iterator) this.stack.peek();

		while (!this.stack.isEmpty()) {

			if (topEl.hasNext()) {
				Object tempTop = topEl.next();

				if (tempTop instanceof Integer) {
					this.top = (Integer) top;
					return true;
				} else if (tempTop instanceof Iterable) {
					this.stack.push(((Iterable) tempTop).iterator());
				}
			} else {
				this.stack.pop();
			}
		}

		return false;

	}

	public Integer next() {

		if (hasNext()) {
			Integer temp = this.top;
			this.top = null;
			return temp;
		}

		return null;

	}

	public static void main(String[] args) {
		
		List list1 = new LinkedList();
		list1.add(0);
		list1.add(new LinkedList<Integer>());
		list1.add(1);
		list1.add(new LinkedList<Integer>());
		List list2 = new LinkedList();
		list2.add(list1);
		list2.add(2);

		List<Integer> newList = new LinkedList<Integer>();
		DeepIterator di = new DeepIterator(list2);

		while (di.hasNext()) {
			newList.add(di.next());
		}

		// Use assert if you want
		System.out.println(String.format("newList size is %d, expcted 3", newList.size()));


	}
}
