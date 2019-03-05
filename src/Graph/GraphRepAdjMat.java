package Graph;

import java.util.LinkedList;

public class GraphRepAdjMat {

	LinkedList<Integer> graph[];
	int count;

	GraphRepAdjMat(int nodesCount) {

		graph = new LinkedList[nodesCount];
		count = nodesCount;
		for (int i = 0; i < count; i++) {
			graph[i] = new LinkedList<Integer>();
		}

	}

	public void addEdge(GraphRepAdjMat obj, int src, int dest) {
		obj.graph[src].add(dest);
		obj.graph[dest].add(src);
	}

	public static void main(String[] args) {
		GraphRepAdjMat obj = new GraphRepAdjMat(5);
		obj.addEdge(obj, 0, 1);
		obj.addEdge(obj, 1, 2);
		obj.addEdge(obj, 2, 3);
		obj.addEdge(obj, 3, 4);
		obj.addEdge(obj, 4, 0);

		printGraph(obj);
	}

	static void printGraph(GraphRepAdjMat obj) {
		// TODO Auto-generated method stub
		for (int i = 0; i < obj.count; i++) {
			System.out.println("Adjacency list of vertex " + i + " is: ");
			for (Integer j : obj.graph[i]) {
				System.out.print(j + " ");
			}
			System.out.println("");
		}
	}
}
