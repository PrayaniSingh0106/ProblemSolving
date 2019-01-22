import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



	class LevelOrderTrav {

	public ArrayList<ArrayList<NodeL>> levelOrder(NodeL root) {
		ArrayList<ArrayList<NodeL>> result = new ArrayList<ArrayList<NodeL>>();
		ArrayList<NodeL> levelResult = new ArrayList<NodeL>();

		NodeL marker = new NodeL(Integer.MIN_VALUE);

		Queue<NodeL> bfs = new LinkedList<NodeL>();
		bfs.add(root);
		bfs.add(marker);

		while (!bfs.isEmpty()) {
			NodeL curNodeL = bfs.peek(); // pop from front of standard dequeue
			bfs.poll();

			if (curNodeL != null) {
				// if dummy NodeL popped from queue means a level has ended
				if (curNodeL.data == Integer.MIN_VALUE) {
					result.add(levelResult); // store level result
					levelResult = new ArrayList<NodeL>(); // initialize levelresult for next level

					// if queue not empty after removing marker, meaning a next level exists or null
					// NodeLs remaining
					//we add marker if null nodes are remaining
					if (!bfs.isEmpty())
						bfs.add(marker);
				} else {
					levelResult.add(curNodeL); // storing current level values into levelresult
					// kids pushed at back of queue ( standard enqueue operation )
					bfs.add(curNodeL.left);
					bfs.add(curNodeL.right);

				}

			}

		}

		 result.remove(result.size()-1);

		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LevelOrderTrav lt = new LevelOrderTrav();
		NodeL root = new NodeL(1);
		root.left=new NodeL(2);
		root.right=new NodeL(3);
		root.left.left=new NodeL(4);
		root.left.right=new NodeL(5);
		root.right.left=new NodeL(6);
		root.right.right=new NodeL(7);
		
		ArrayList<ArrayList<NodeL>> n = lt.levelOrder(root);
		
	for(ArrayList<NodeL> a:n) {
		
		for(NodeL b:a) {
			System.out.print(b.data + " ");
		}
		System.out.println("\n");
	}
	}

}
