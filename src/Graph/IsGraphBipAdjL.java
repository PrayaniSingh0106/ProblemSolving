package Graph;

import java.util.LinkedList;

public class IsGraphBipAdjL {

	LinkedList<Integer>[] l = new LinkedList[200];
	int v;
	
	IsGraphBipAdjL(int cap) {
		v=cap;
		for (int i = 0; i < v; i++) {
			l[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int src, int dest,IsGraphBipAdjL obj) {
		obj.l[src].add(dest);
		obj.l[dest].add(src);
	}

	public static void main(String[] args) {
		IsGraphBipAdjL obj = new IsGraphBipAdjL(6);
		obj.addEdge(0, 1, obj);
		obj.addEdge(1, 2, obj);
		obj.addEdge(2, 3, obj);
		obj.addEdge(3, 4, obj);
		obj.addEdge(4, 5, obj);
		
		
		System.out.println(isBipartite(obj.l));

	}

	private static char[] isBipartite(LinkedList<Integer>[] list) {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}
}
