package systemDesign;

public class HashmapDesign {

	class BucketListNode {
		int val;
		int key;
		BucketListNode next;

		BucketListNode(int key, int val) {
			this.val = val;
			this.key = key;
			next = null;
		}
	}

	BucketListNode[] nodes = new BucketListNode[2000];

	public void put(int key, int val) {
		int index = getIndex(key);

		if (nodes[index] == null)
			nodes[index] = new BucketListNode(-1, -1);

		BucketListNode node = find(nodes[index], key);

		if (node.next == null) {
			BucketListNode newNode = new BucketListNode(key, val);
			node.next = newNode;
			newNode.next = null;
		}
		if (node.next.key == key) {
			node.next.val = val;
		}
	}

	public int get(int key) {

		int index = getIndex(key);

		if (nodes[index] == null)
			return -1;

		BucketListNode node = find(nodes[index], key);

		return node.next == null ? -1 : node.next.val;
	}

	public void remove(int key) {

		int index = getIndex(key);

		if (nodes[index] == null)
			return;

		BucketListNode prev = find(nodes[index], key);

		if (prev.next == null)
			return;
		prev.next = prev.next.next;

	}

	public int getIndex(int key) {
		return key % nodes.length;

	}

	// returning prev because prev will never be null acc to this logic and we will
	// be able to append a node after prev
	public BucketListNode find(BucketListNode bucket, int key) {

		BucketListNode prev = null;
		BucketListNode node = bucket;

		while (node != null && node.key != key) {
			prev = node;
			node = node.next;
		}

		return prev;

	}

	public static void main(String[] args) {

		HashmapDesign hmap = new HashmapDesign();
		hmap.put(3, 10);
		hmap.put(4, 20);
		hmap.put(4, 30);
		//hmap.remove(4);
		int val = hmap.get(4);
		System.out.println("val : " + val);

	}
}