package audible;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
// Java program to print top 
// view of binary tree 
import java.util.Queue;

// class to create a node 
class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

// class of binary tree
class TopViewTree {
	Node root;

	public TopViewTree() {
		root = null;
	}

	static class QueueObj {
		Node node;
		int horDist;

		QueueObj(Node node, int horDist) {
			this.node = node;
			this.horDist = horDist;
		}
	}

	// function should print the topView of
	// the binary tree
	private static Map<Integer, QueueObj> TopView(Node root) {

		Queue<QueueObj> bfs = new LinkedList<QueueObj>();
		Map<Integer, QueueObj> res = new HashMap<Integer, QueueObj>();

		if (root == null)
			return null;

		res.put(0, new QueueObj(root, 0));
		bfs.add(new QueueObj(root, 0));

		while (!bfs.isEmpty()) {

			QueueObj top = bfs.poll();

			if (!res.containsKey(top.horDist)) {
				res.put(top.horDist, top);
			}
			if (top.node.left != null) {
				bfs.add(new QueueObj(top.node.left, top.horDist - 1));
			}
			if (top.node.right != null) {
				bfs.add(new QueueObj(top.node.right, top.horDist + 1));
			}

		}
		return res;

	}

	// Driver Program to test above functions
	public static void main(String[] args) {

		TopViewTree t = new TopViewTree();
		
		t.root = new Node(1);
		t.root.left = new Node(2);
		t.root.right = new Node(3);
		//root.left.left = new Node(4);
		t.root.left.right = new Node(4);
		t.root.left.right.right = new Node(5);
		t.root.left.right.right.right = new Node(6);

		Map<Integer, QueueObj> res = TopView(t.root);

		for (Entry<Integer, QueueObj> i : res.entrySet()) {
			System.out.println("key : " + i.getKey() + " val : " + i.getValue().node.data);
		}

	}

}
