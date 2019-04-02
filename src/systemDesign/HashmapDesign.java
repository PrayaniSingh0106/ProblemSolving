package systemDesign;

class HashMapDesign {

	class BucketListNode {
		int val;
		BucketListNode prev;
		BucketListNode next;

		BucketListNode(int val) {
			this.val = val;
			prev = next = null;
		}
	}

	BucketListNode[] nodes = new BucketListNode[2000];
	
	public void put(int key, int val) {
		int index = getIndex(key);
		
	}

	public int get(int key) {
		
		int index = getIndex(key);
		BucketListNode node = find(nodes[index], key);
		
		if(node.next==null)
			return -1;
		
		return node.next.val;
	}

	public void remove() {

	}

	public int getIndex(int key) {
		return 0;

	}

	public BucketListNode find(BucketListNode bucket, int key) {
		
		return null;

	}
}