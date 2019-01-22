package ctci;

import java.util.HashSet;

public class RemoveDups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node start = new Node(5);
		start.next = new Node(8);
		start.next.next = new Node(11);
		start.next.next.next = new Node(8);
		start.next.next.next.next = new Node(11);
		start.next.next.next.next.next = new Node(2);
		printList(start);
		removeDups(start);
		printList(start);

	}

	static void printList(Node head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println("\n");
	}

	static class Node {

		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	static void removeDups(Node head) {

		HashSet<Integer> hset = new HashSet<>();
		Node n = head;
		hset.add(n.val);
		
		while (n.next != null) {
			
			if (hset.contains(n.next.val)) {
				n.next = n.next.next;
			}

			else {
				hset.add(n.next.val);
				n = n.next;
			}
		}
	}
}
