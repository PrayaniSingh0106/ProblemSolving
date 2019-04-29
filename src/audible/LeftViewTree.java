package audible;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import audible.TopViewTree.QueueObj;

import java.util.Queue;

public class LeftViewTree {

	static class QueueObj{
		Node node;
		int horDist;
		QueueObj(Node node, int horDist){
			this.node = node;
			this.horDist = horDist;
		}
	}
	
	Node root;
	
	LeftViewTree(){
		root = null;
	}
	
	public static void printSideView(Node root) {
		
		if(root == null)
			return;
		
		HashMap<Integer, QueueObj> res = new HashMap<Integer, QueueObj>();
		Queue<QueueObj> bfs = new LinkedList<QueueObj>();
		
		bfs.add(new QueueObj(root,0));
		res.put(0, new QueueObj(root,0));
		
		while(!bfs.isEmpty()) {
			QueueObj top = bfs.poll();
			
			if(!res.containsKey(top.horDist)) {
				res.put(top.horDist, top);
			}
			
			if(top.node.left!=null) {
				bfs.add(new QueueObj(top.node.left,top.horDist+1));
			}
			if(top.node.right!=null) {
				bfs.add(new QueueObj(top.node.right,top.horDist+1));
			}
		}
		
		for(Entry<Integer, QueueObj> entry : res.entrySet()) {
			System.out.println(entry.getKey() + "  " + entry.getValue().node.data);
		}
	}
	
	public static void main(String[] args) {

		LeftViewTree t = new LeftViewTree();
		
		t.root = new Node(1);
		t.root.left = new Node(2);
		t.root.right = new Node(3);
		t.root.left.left = new Node(4);
		t.root.left.right = new Node(5);
		t.root.right.right = new Node(6);
		//t.root.right.left = new Node(6);

		 printSideView(t.root);

	
	}
}
