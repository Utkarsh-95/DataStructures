package a.graph.gfgstriv;

import java.util.ArrayList;

public class BridgesinGraph {

	static ArrayList<String> result = new ArrayList<>();
	static int count = 0;

	private static void bridgesGraph(ArrayList<ArrayList<Integer>> adj, int v) {
		// 1 based indexing
		int vis[] = new int[v + 1];
		int tin[] = new int[v + 1];
		int low[] = new int[v + 1];

		int timer = 0;
		for (int k = 0; k < v; k++) {
			if (vis[k] == 0) {
				dfs(k, -1, vis, tin, low, adj, timer);
			}
		}
	}

	private static void dfs(int node, int parent, int[] vis, int[] tin, int[] low, ArrayList<ArrayList<Integer>> adj,
			int timer) {

		vis[node] = 1;
		tin[node] = low[node] = timer++;

		for (Integer it : adj.get(node)) {
			if (it == parent) {
//				System.out.println(it + "=" + parent);
				continue;
			}
			if (vis[it] == 0) {
				dfs(it, node, vis, tin, low, adj, timer);
				low[node] = Math.min(low[it], low[node]);

				if (low[it] > tin[node]) {// condition of bridge
					count++;
					System.out.print("Bridges : ");
					System.out.println(node + " - " + it);
					result.add(node + " - " + it);
				}
			} else {
				low[node] = Math.min(tin[it], low[node]);
			}
		}
	}

	public static void main(String[] args) {
		int V = 6;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		for (int i = 0; i <= V; i++)
			adj.add(new ArrayList<>());

		adj.get(1).add(2);
		adj.get(1).add(4);
		adj.get(2).add(1);
		adj.get(2).add(3);
		adj.get(3).add(2);
		adj.get(3).add(4);
		adj.get(4).add(3);
		adj.get(4).add(1);
		adj.get(4).add(5);
		adj.get(5).add(4);
		adj.get(5).add(6);
		adj.get(6).add(5);

		printGraph(adj);
		bridgesGraph(adj, V);
		System.out.println(result);
		System.out.println("No of Components in graph : " + count);

	}

	private static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		System.out.println("Adjacency of graph");
		for (int i = 1; i < adj.size(); i++) {
			System.out.print("V" + i + "=");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(" " + adj.get(i).get(j));
			}
			System.out.println();
		}

	}

}
