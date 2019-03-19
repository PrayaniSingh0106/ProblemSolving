package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NaryNode {
	public int val;
	public List<NaryNode> children;

	public NaryNode() {
	}

	public NaryNode(int _val, List<NaryNode> _children) {
		val = _val;
		children = _children;
	}

}

public class LOTravNary {

	// Definition for a Node. class Node { public int val; public List<Node>

	public List<List<Integer>> levelOrder(NaryNode root) {
		List<List<Integer>> ret = new LinkedList<>();

		if (root == null)
			return ret;

		Queue<NaryNode> queue = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			List<Integer> curLevel = new LinkedList<>();
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				NaryNode curr = queue.poll();
				curLevel.add(curr.val);
				for (NaryNode c : curr.children)
					queue.offer(c);
			}
			ret.add(curLevel);
		}

		return ret;
	}

	public static void main(String[] args) {
		LOTravNary obj = new LOTravNary();
		NaryNode n = new NaryNode(3, null);
		NaryNode n1 = new NaryNode(2, null);
		List<NaryNode> l = new ArrayList<NaryNode>();
		l.add(n);
		l.add(n1);
		NaryNode root = new NaryNode(1, l);
		obj.levelOrder(root);
	}
}
