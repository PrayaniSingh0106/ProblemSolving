package leetCode;

public class HashMapDesign {

	ListNode[] n = new ListNode[10000];

	/** value will always be non-negative. */
	public void put(int key, int value) {

		int index = getIndex(key);
		ListNode prev = findElement(key, index);

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
		ListNode prev = findElement(key, index);
		return prev.next == null ? -1 : prev.next.val;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		int index = getIndex(key);

		ListNode prev = findElement(key, index);

		if (prev.next != null) {
			prev.next = prev.next.next;
		}
	}

	public int getIndex(int key) {
		return Integer.hashCode(key) % n.length;
	}

	public ListNode findElement(int key, int index) {

		if (n[index] == null)
			return n[index] = new ListNode(-1, -1);

		ListNode prev = n[index];

		while (prev.next != null && prev.next.key != key) {
			prev = prev.next;
		}
		return prev;
	}

	private static class ListNode {
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
}
