package ctci;

import ctci.RemoveDups.Node;

public class KthLast {

	static class Node {

		Node next;
		int val;

		Node(int v) {
			val = v;
		}
	}

	public static Node KthLastEl(Node head, int k, int l) {

		Node n = head;
	//	int index = l - k + 1;
		
		if (k == 0) {
			return n;
		}

		else
			return KthLastEl(n.next, k - 1, l);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node start = new Node(5);
		start.next = new Node(8);
		start.next.next = new Node(11);
		start.next.next.next = new Node(8);
		start.next.next.next.next = new Node(11);
		start.next.next.next.next.next = new Node(2);
		KthLastEl(start, 4, 6);
		// printList(start);

	}
}
