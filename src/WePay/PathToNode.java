package WePay;

import java.util.ArrayList;
import java.util.List;

public class PathToNode {

	public static boolean isPathToRoot(List<Integer> arr, TNode root, int x) {

		if (root == null)
			return false;

		arr.add(root.val);

		if (root.val == x)
			return true;

		if (isPathToRoot(arr, root.left, x) || isPathToRoot(arr, root.right, x)) {
			return true;
		}

		arr.remove(arr.size() - 1);

		return false;
	}

	public static void main(String[] args) {

		TNode root = new TNode(1);
		root.left = new TNode(2);
		root.left.left = new TNode(2);
		root.left.right = new TNode(5);
		root.right = new TNode(3);
		root.right.right = new TNode(7);
		root.right.left = new TNode(6);

		List<Integer> path = new ArrayList<Integer>();

		System.out.println(isPathToRoot(path, root, 5));
	}

}
