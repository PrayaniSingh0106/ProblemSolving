package trees;

class TNode {
	TNode left;
	TNode right;
	int val;

	TNode(int val) {
		this.val = val;
		left = null;
		right = null;
	}
}

public class MirrorTree {
	
	public static TNode findMirror(TNode root) {
		
		if(root==null)
			return null;
		
		TNode left = findMirror(root.left);
		TNode right = findMirror(root.right);
			
		root.left = right;
		root.right = left;
		
		return root;
	}
	
	public static TNode inOrder(TNode root) {
		
		if(root==null)
			return null;
		
		inOrder(root.left);
		System.out.println(root.val + " ");
		inOrder(root.right);
		
		return root;
	}
	
	public static void main(String[] args) {
		
		TNode root = new TNode(1);
		root.left = new TNode(3);
		root.right = new TNode(2);
		root.right.left = new TNode(5);
		root.right.right = new TNode(4);
		TNode newRoot = findMirror(root);	
		inOrder(newRoot);
	}
	
	
}
