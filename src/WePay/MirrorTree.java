package WePay;

//FOR PERFECT UNDERSTANDING
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
	TNode root;
	public static TNode findMirror(TNode root) {
		
		if(root==null)
			return null;
		
		System.out.println("Calling left of root " + root.val);
		TNode left = findMirror(root.left);
		System.out.println("Calling right of root " + root.val);
		TNode right = findMirror(root.right);
			System.out.println(" Comes to root: " + root.val);
		root.left = right;
		root.right = left;
		System.out.println("Returning root from last " + root.val);
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
		
		MirrorTree obj = new MirrorTree();
		obj.root = new TNode(1);
		obj.root.left = new TNode(3);
		obj.root.right = new TNode(2);
		obj.root.right.left = new TNode(5);
		obj.root.right.right = new TNode(4);
		TNode newRoot = findMirror(obj.root);	
		inOrder(newRoot);
	}
	
	
}
