package trees;

public class IsBST {
	public boolean isValidBST(TreeNode root) {

		return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isValidBSTHelper(TreeNode root, long min, long max) {

		if (root == null)
			return true;

		else if (root.val <= min || root.val >= max)
			return false;

		return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right, root.val, max);

	}

}
