package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTravIter {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */

	public List<Integer> inorderTraversal(TreeNode root) {

		Stack<TreeNode> st = new Stack<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();
		TreeNode cur = root;

		while (!st.empty() || cur != null) {

			while (cur != null) {
				st.add(cur);
				cur = cur.left;
			}
			cur = st.pop();
			res.add(cur.val);
			cur = cur.right;

		}
		return res;
	}

}
