package Intuit;

public class BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BST tree = new BST();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(10);
		
		tree.postOrder();
	}

	class Node{
		Node left, right;
		int val;
		 Node(int val) {
			this.val = val;
			left=right=null;
		}
	}
	Node root;
	
	public void insert(int val) {
		root = insertEl(root, val);
	}
	
	public Node insertEl(Node root, int val) {
		
		if(root==null)
			return new Node(val);
		
		else if(val > root.val) {
			root.right = insertEl(root.right, val);
		}
		else if(val < root.val) {
			root.left = insertEl(root.left, val);
		}
		else if(val == root.val){
			return root;
		}
		return root;
	}
	
	void postOrder() {
		postOrderTrav(root);
	}
	
	 void postOrderTrav(Node root) {
		
		if(root==null)
			return;
		
		postOrderTrav(root.left);
		
		postOrderTrav(root.right);
		System.out.println(root.val);
		
	}
	
	
}
