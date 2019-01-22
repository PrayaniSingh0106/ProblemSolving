package leetCode;



public class BinTreeLongPath {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	int count = 0;

	public int longestUnivaluePath(TreeNode root) {

		if (root.left == null)
			return count;
		if (root.right == null)
			return count;

		longestUnivaluePath(root.left);
		longestUnivaluePath(root.right);

		if (root.val == root.left.val)
			count++;
		else
			count = 0;

		if (root.val == root.right.val)
			count++;
		else
			count = 0;

		return count;

	}
}
