package trees;

import java.util.ArrayList;
import java.util.List;

public class InOrderTravRec {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */

	List<Integer> res = new ArrayList<Integer>();

	public List<Integer> inorderTraversal(TreeNode root) {

		TreeNode tree = inorderHelper(root);
		return res;
	}

	public TreeNode inorderHelper(TreeNode root) {
		if (root == null)
			return root;

		inorderTraversal(root.left);
		res.add(root.val);
		inorderTraversal(root.right);

		return root;
	}

}
