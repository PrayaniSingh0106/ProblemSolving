package leetCode;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

final class Main {
	private static final int MAXM = Integer.MAX_VALUE;

	public static void main(String[] args) {

		try (final Scanner in = new Scanner(System.in)) {
			final int vertices = in.nextInt();
			final int edges = in.nextInt();

			final Main o1 = new Main();
			List<List<Node>> adjcnt = o1.getAdjcn(vertices);

			for (int i = 0; i < edges; i++) {
				int v1 = in.nextInt();
				int v2 = in.nextInt();
				int weight = in.nextInt();

				adjcnt.get(v1).add(new Node(v2, weight));
				adjcnt.get(v2).add(new Node(v1, weight));
			}

			final int src = in.nextInt();
			final int dest = in.nextInt();

			final Output output = o1.dijkstraAlg(adjcnt, vertices, src, dest);

			System.out.println(output.optCost);
			o1.seqVertices(output.path);
		}
	}

	private static class Node {
		private final int v;
		private final int dist;

		Node(int v, int dist) {
			this.v = v;
			this.dist = dist;
		}
	}

	private Output dijkstraAlg(List<List<Node>> adj, int vertices, int src, int dest) {

		boolean[] vist = new boolean[vertices];
		int[] distSrc = getInitInfinity(vertices);
		distSrc[src] = 0;

		List<List<Node>> prev = new ArrayList<>();
		for (int i = 0; i < vertices; i++) {
			prev.add(i, new ArrayList<>());
		}

		for (int i = 0; i < vertices; i++) {
			int u = getNextMinDistNode(vist, distSrc, vertices);
			vist[u] = true;
			for (Node node : adj.get(u)) {
				int nextNode = node.v;
				int nextDist = node.dist;
				if (!vist[nextNode] && distSrc[u] + nextDist <= distSrc[nextNode]) {
					distSrc[nextNode] = distSrc[u] + nextDist;
					prev.get(nextNode).add(0, new Node(u, distSrc[nextNode]));
				}
			}
		}

		int minDist = distSrc[dest];
		List<Integer> path = getAllMinDistPath(prev, vertices, src, dest, minDist);
		return new Output(minDist, path);
	}

	private List<Integer> getAllMinDistPath(List<List<Node>> prev, int vertices, int src, int dest, int minDist) {

		List<List<Node>> everyPath = new ArrayList<>();
		boolean[] vs = new boolean[vertices];

		for (Node e : prev.get(dest)) {
			if (e.dist == minDist) {
				List<Node> path = new ArrayList<>();
				path.add(new Node(dest, minDist));

				getAllMinDistPath(prev, everyPath, path, vs, e, src);
			}
		}
		return getMinDistPath(everyPath);
	}

	private List<Integer> getMinDistPath(List<List<Node>> everyPath) {

		int minSize = MAXM;
		List<Integer> minmPath = new ArrayList<>();

		for (List<Node> path : everyPath) {
			if (path.size() < minSize) {

				minSize = path.size();
				minmPath = path.stream().map(e -> e.v).collect(toList());

			} else if (path.size() == minSize) {

				for (int i = path.size() - 1; i >= 0; i--) {
					if (path.get(i).v > minmPath.get(i)) {
						break;
					}
					if (path.get(i).v != minmPath.get(i)) {
						minmPath = path.stream().map(e -> e.v).collect(toList());
						break;
					}
				}
			}
		}

		Collections.reverse(minmPath);

		return Collections.unmodifiableList(minmPath);
	}

	private void getAllMinDistPath(List<List<Node>> prev, List<List<Node>> everyPath, List<Node> path, boolean[] vist,
			final Node e, final int src) {

		vist[e.v] = true;
		path.add(e);

		if (src == e.v) {
			everyPath.add(new ArrayList<>(path));
		} else {
			int minDist = MAXM;

			for (Node node : prev.get(e.v)) {

				if (!vist[node.v] && node.dist <= minDist) {
					minDist = node.dist;
					getAllMinDistPath(prev, everyPath, path, vist, node, src);
				}
			}
		}

		vist[e.v] = false;
		path.remove(e);
	}

	private int getNextMinDistNode(boolean[] vis, int[] distFromSrc, int vertices) {
		int node = 0;
		int minDist = MAXM;
		for (int i = 0; i < vertices; i++) {
			if (!vis[i] && distFromSrc[i] < minDist) {
				node = i;
				minDist = distFromSrc[i];
			}
		}
		return node;
	}

	private static class Output {
		private final int optCost;
		private final List<Integer> path;

		Output(int optCost, List<Integer> path) {
			this.optCost = optCost;
			this.path = path;
		}
	}

	private List<List<Node>> getAdjcn(int vrtcs) {
		List<List<Node>> adjc = new ArrayList<>();
		for (int i = 0; i < vrtcs; i++) {
			adjc.add(i, new ArrayList<>());
		}
		return adjc;
	}

	private void seqVertices(List<Integer> path) {
		for (int i = 0; i < path.size(); i++) {
			if (i != path.size() - 1) {
				System.out.print(path.get(i) + " ");
			} else {
				System.out.print(path.get(i));
			}
		}
		System.out.println();
	}

	private int[] getInitInfinity(int vertices) {
		int[] distFromSrc = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			distFromSrc[i] = MAXM;
		}
		return distFromSrc;
	}

}
