package WePay;

import java.util.LinkedList;

public class IsGraphBipMatr {

	public static boolean isBipartiteUtil(int[][] g, int[] color, int src) {

		int v = g[0].length;
		color[src] = 1;

		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(src);

		while (!q.isEmpty()) {

			int u = q.getFirst();
			q.pop();

			if (g[u][u] == 1)
				return false;

			for (int j = 0; j < v; j++) {
				if (g[u][j] == 1 && color[j] == -1) {
					color[j] = 1 - color[u];
					q.push(j);
				} else if (g[u][j] == 1 && color[u] == color[j])
					return false;
			}
		}
		return true;

	}

	public static boolean isBipartite(int[][] g) {

		int v = g[0].length;

		int[] color = new int[v];

		for (int i = 0; i < v; i++) {
			color[i] = -1;
		}

		for (int i = 0; i < v; i++) {

			if (color[i] == -1)
				if (isBipartiteUtil(g, color, i) == false)
					return false;
		}

		return true;

	}

	public static void main(String[] args) {

		int[][] graph = { { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 0, 1, 0 }

		};
		System.out.println(isBipartite(graph));

	}
}
