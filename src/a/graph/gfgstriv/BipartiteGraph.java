package a.graph.gfgstriv;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

	public static void main(String[] args) {

		int V = 7;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < V; i++)
			adj.add(new ArrayList<Integer>());

		adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(2).add(3);
		adj.get(3).add(2);

		adj.get(4).add(3);
		adj.get(3).add(4);

		adj.get(4).add(5);
		adj.get(5).add(4);

		adj.get(4).add(6);
		adj.get(6).add(4);

		adj.get(1).add(6);
		adj.get(6).add(1);

		System.out.println(adj);
		GraphUtil.printGraph(adj);
		boolean check = checkBipartite(adj, V);
		if (check == true) {
			System.out.println("Graph is Bipartite");
		} else {
			System.out.println("Graph is not Bipartite");
		}

	}

	private static boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int n) {
		int color[] = new int[n];
		for (int i = 0; i < n; i++) {
			color[i] = -1;
		}
		for (int i = 0; i < n; i++) {
			if (color[i] == -1) {
				if (!bfsCheck(adj, i, color)) {
					return false;
				}
			}
		}
		return true;
	}

	// 0 -> Green and 1 -> Blue
	private static boolean bfsCheck(ArrayList<ArrayList<Integer>> adj, int node, int color[]) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		color[node] = 1;
		while (!q.isEmpty()) {
			Integer nde = q.poll();

			for (Integer it : adj.get(nde)) {
				if (color[it] == -1) {
					color[it] = 1 - color[nde];
					q.add(it);
				} else if (color[it] == color[nde]) {
					return false;
				}
			}
		}
		return true;
	}

}
