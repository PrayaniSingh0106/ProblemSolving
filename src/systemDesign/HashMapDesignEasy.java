package systemDesign;

public class HashMapDesignEasy {

	ListNode[] n = new ListNode[10000];

	/** value will always be non-negative. */
	public void put(int key, int value) {

		int index = getIndex(key);

		if (n[index] == null)
			n[index] = new ListNode(-1, -1);

		ListNode prev = findElement(n[index], key);

		if (prev.next == null) {
			prev.next = new ListNode(key, value);
		} else {
			prev.next.val = value;
		}
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 of this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		int index = getIndex(key);
		ListNode prev = findElement(n[index], key);
		return prev.next == null ? -1 : prev.next.val;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {

		int index = getIndex(key);

		if (n[index] == null)
			return;

		ListNode prev = findElement(n[index], key);

		if (prev.next != null) {
			prev.next = prev.next.next;
		}
	}

	public int getIndex(int key) {
		return Integer.hashCode(key) % n.length;
	}

	public ListNode findElement(ListNode bucket, int key) {

		ListNode node = bucket;

		ListNode prev = null;

		while (node != null && node.key != key) {
			prev = node;
			node = node.next;
		}
		return prev;
	}

	class ListNode {
		int val;
		ListNode next;
		int key;

		ListNode(int key, int val) {
			this.key = key;
			this.val = val;
			next = null;
		}
	}

	/**
	 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
	 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
	 * obj.remove(key);
	 */
	public static void main(String[] args) {

		HashMapDesignEasy hmap = new HashMapDesignEasy();
		hmap.put(3, 10);
		hmap.put(4, 20);

		int param1 = hmap.get(3);
		System.out.println(" param1 " + param1);
	}
}
