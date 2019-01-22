
// A Java Program to detect cycle in a graph 
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class DetectCycle {

	private final int V;
	private final List<List<Integer>> adj;

	public DetectCycle(int V) {
		// initialise the number of rows
		this.V = V;
		adj = new ArrayList<>(V);

		// initilaise a linkedList for each row
		for (int i = 0; i < V; i++)
			adj.add(new LinkedList<>());
	}

	// This function is a variation of DFSUytil() in
	// https://www.geeksforgeeks.org/archives/18212
	private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {

		System.out.println("isCyclicUtil called with i : " + i);
		// check if already present in recStack
		if (recStack[i])
			return true;
		if (visited[i])
			return false;

		// Mark the current node as visited and
		// part of recursion stack
		visited[i] = true;
		recStack[i] = true;

		List<Integer> children = adj.get(i);

		for (Integer c : children) {
			System.out.println("Children of i: " + i + " is: " + c);
			// recursion call with the vertex's first child, which in turn will call the
			// function recursively with it's first child and that child will call the
			// function recursively with it's own child and so on
			if (isCyclicUtil(c, visited, recStack))
				return true;
		}
		recStack[i] = false;

		return false;
	}

	private void addEdge(int source, int dest) {
		// add adjacent vertices to vertex from 0 to 3
		adj.get(source).add(dest);
	}

	// Returns true if the graph contains a
	// cycle, else false.
	// This function is a variation of DFS() in
	// https://www.geeksforgeeks.org/archives/18212
	private boolean isCyclic() {

		// Mark all the vertices as not visited and
		// not part of recursion stack
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];

		// Call the recursive helper function to
		// detect cycle in different DFS trees (The loop helps in case of disconnected
		// graph)
		for (int i = 0; i < V; i++) {
			System.out.println("Calling isCyclicUtil with i: " + i);
			if (isCyclicUtil(i, visited, recStack))
				return true;
		}
		return false;
	}

	// Driver code
	public static void main(String[] args) {
		DetectCycle graph = new DetectCycle(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		// graph.addEdge(3, 1);

		if (graph.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't " + "contain cycle");
	}
}

// This code is contributed by Sagar Shah. 
