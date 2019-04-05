package systemDesign;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class DeepIterator implements Iterator<Integer> {
	private Stack stack = new Stack<>();
	private Integer top = null;

	public DeepIterator(Iterable nestedList) {
		this.stack.push(nestedList.iterator());
	}

	@Override
	public boolean hasNext() {

		if (this.top != null)
			return true;

		while (!this.stack.isEmpty()) {
			Iterator tmpIterator = (Iterator) this.stack.peek();

			if (tmpIterator.hasNext()) {
				Object tmp = tmpIterator.next();
				// If tmp is an integer
				if (tmp instanceof Integer) {
					this.top = (Integer) tmp;
					return true;
				} // If tmp is an nested list
				else if (tmp instanceof Iterable) {
					this.stack.push(((Iterable) tmp).iterator());
				} else {
					throw new RuntimeException("Unsupported data type. ");
				}
			} else {
				this.stack.pop();
			}
		}
		return false;
	}

	@Override
	public Integer next() throws NoSuchElementException {
		if (hasNext()) {
			Integer tmp = this.top;
			this.top = null;
			return tmp;
		}

		throw new NoSuchElementException();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("This is not supported right now.");
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

		list1 = new LinkedList();
		newList = new LinkedList<Integer>();
		di = new DeepIterator(list1);
		while (di.hasNext()) {
			newList.add(di.next());
		}

		// assertTrue(newList.size() == 0);
		System.out.println(String.format("newList size is %d, expcted 0", newList.size()));

		list1 = new LinkedList();
		list1.add(new LinkedList<Integer>());
		list1.add(1);
		list1.add(new LinkedList<Integer>());
		list2 = new LinkedList();
		list2.add(list1);
		list2.add(2);
		List<Integer> list3 = new LinkedList<Integer>();
		list3.add(3);
		list3.add(4);
		list3.add(5);
		List list4 = new LinkedList();
		list4.add(list2);
		list4.add(list3);

		newList = new LinkedList<Integer>();

		di = new DeepIterator(list4);
		while (di.hasNext()) {
			newList.add(di.next());
		}

		// assertTrue(newList.size() == 5);
		System.out.println(String.format("newList size is %d, expcted 5", newList.size()));

		/**
		 * ----> 5 | ---- 3 -> 4 -> L -> 6 | 1 -> 2 -> L -> 7-> 8
		 */
		list3 = new LinkedList<Integer>();
		list3.add(3);

		list2 = new LinkedList<Integer>();
		list2.add(2);
		list2.add(list3);
		list2.add(4);

		list1 = new LinkedList<Integer>();
		list1.add(1);
		list1.add(list2);
		list1.add(5);
		list1.add(6);

		di = new DeepIterator(list1);
		newList = new LinkedList<Integer>();
		while (di.hasNext()) {
			newList.add(di.next());
		}
		System.out.println(String.format("newList size is %d, expcted 6", newList.size()));
	}
}
/*
 * public class DeepIterator implements Iterator<Integer> {
 * 
 * public DeepIterator(List<DeepIterator> nestedList) { lists = new Stack<>();
 * lists.push(nestedList.listIterator()); }
 * 
 * public Integer next() { hasNext(); return lists.peek().next().getInteger(); }
 * 
 * public boolean hasNext() { while (!lists.empty()) { if
 * (!lists.peek().hasNext()) { lists.pop(); } else { DeepIterator x =
 * lists.peek().next(); if (x.isInteger()) return lists.peek().previous() == x;
 * lists.push(x.getList().listIterator()); } } return false; }
 * 
 * private Stack<ListIterator<DeepIterator>> lists; }
 */
