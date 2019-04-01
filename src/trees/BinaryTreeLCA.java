package trees;

class TreeNode{
	TreeNode left, right;
	int val;
	TreeNode(int val){
		this.val = val;
		left=right=null;
	}
}

public class BinaryTreeLCA {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null)
			return root;
		if (root == p || root == q)
			return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (root.left == null && root.right == null)
			return null;
		if (root.left != null && root.right != null)
			return root;
		return left != null ? left : right;

	}
}
