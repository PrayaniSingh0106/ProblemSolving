package Intuit;

class Node {
	Node left, right;
	int val;

	Node(int val) {
		this.val = val;
		left = right = null;
	}
}
public class LCABST {
	
	Node root;

	public Node lca(Node root, Node p, Node q) {

		if(root==null)
			return null;
		
		if (root.val > p.val && root.val > q.val)
			return lca(root.left, p, q);
		if (root.val < p.val && root.val < q.val)
			return lca(root.right, p, q);

		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCABST tree = new LCABST();

		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		Node lcs = tree.lca(tree.root,tree.root.left, tree.root.left.right.right );
		System.out.println(lcs.val);
	}

}
