package systemDesign;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	class DLinkedList {
		DLinkedList next;
		DLinkedList prev;
		int val;
		int key;
	}

	public DLinkedList removeNode(DLinkedList node) {

		node.prev.next = node.next;
		node.next.prev = node.prev;

		return node;
	}

	public void addNode(DLinkedList newNode) {

		System.out.println("val " + newNode.val);
		newNode.next = head.next;
		newNode.prev = head;

		head.next.prev = newNode;
		head.next = newNode;
	}

	public void moveToTop(DLinkedList node) {
		this.removeNode(node);
		this.addNode(node);
	}

	public DLinkedList popFromTail() {

		DLinkedList lastNode = tail.prev;
		DLinkedList removedNode = removeNode(lastNode);
		return removedNode;

	}

	private int capacity;
	private int count;
	private DLinkedList head;
	private DLinkedList tail;
	private Map<Integer, DLinkedList> hmap = new HashMap<Integer, DLinkedList>();

	public LRUCache(int cap) {
		capacity = cap;
		count = 0;

		head = new DLinkedList();
		tail = new DLinkedList();
		head.next = tail;
		head.prev = null;
		tail.next = null;
		tail.prev = head;
	}

	public int get(int key) {

		DLinkedList node = hmap.get(key);

		if (node == null)
			return -1;

		moveToTop(node);

		return node.val;
	}

	public void put(int key, int val) {

		DLinkedList node = hmap.get(key);

		if (node == null) {
			DLinkedList newNode = new DLinkedList();
			newNode.key = key;
			newNode.val = val;

			this.addNode(newNode);
			this.hmap.put(key, newNode);
			count++;

			if (count > capacity) {
				DLinkedList remNode = popFromTail();
				this.hmap.remove(remNode.key);
				count--;
			}

		} else {
			node.val = val;
			this.moveToTop(node);
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(5);
		cache.put(1, 49);
		cache.put(2, 39);
		cache.put(3, 29);
		cache.put(4, 19);

		int val = cache.get(4);
		System.out.println("val : " + val);

	}

}
