package a.graph.gfgstriv;

import java.util.ArrayList;
import java.util.Arrays;

public class ArticulationPoint {

	private static void articulationPoint(ArrayList<ArrayList<Integer>> adj, int n) {
		int tin[] = new int[n];
		int low[] = new int[n];
		int vis[] = new int[n];
		int timer = 0;
		int isArticulation[] = new int[n];

		for (int i = 0; i < n; i++) {
			if (vis[i] == 0) {
				dfs(i, -1, adj, vis, tin, low, isArticulation, timer);
			}
		}
		System.out.print("Articulation Points : ");
		System.out.println(Arrays.toString(isArticulation));
		for (int i = 0; i < isArticulation.length; i++) {
			if (isArticulation[i] == 1) {
				System.out.print(i + " ");
			}
		}
	}

	private static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] tin, int[] low,
			int[] isArticulation, int timer) {
		vis[node] = 1;
		tin[node] = low[node] = timer++;
		int child = 0;

		for (Integer it : adj.get(node)) {
			if (it == parent)
				continue;
			if (vis[it] == 0) {
				dfs(it, node, adj, vis, tin, low, isArticulation, timer);
				low[node] = Math.min(low[node], low[it]);

				if (low[it] >= tin[node] && parent != -1) {
					isArticulation[node] = 1;
				}
				child++;
			} else {
				low[node] = Math.min(low[node], tin[it]);
			}
		}
		if (parent == -1 && child > 1) {
			isArticulation[node] = 1;
		}
	}

	public static void main(String[] args) {
		int V = 11;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < V; i++)
			adj.add(new ArrayList<Integer>());

		adj.get(1).add(2);
		adj.get(1).add(3);
		adj.get(1).add(4);
		adj.get(2).add(1);
		adj.get(2).add(5);
		adj.get(2).add(6);
		adj.get(3).add(1);
		adj.get(3).add(7);
		adj.get(3).add(8);
		adj.get(4).add(1);
		adj.get(4).add(9);
		adj.get(4).add(10);
		adj.get(5).add(2);
		adj.get(6).add(2);
		adj.get(7).add(3);
		adj.get(8).add(3);
		adj.get(9).add(4);
		adj.get(10).add(4);

		printGraph(adj);
		articulationPoint(adj, V);

	}

	private static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		System.out.println("Adjacency of graph");
		for (int i = 0; i < adj.size(); i++) {
			System.out.print("V" + i + "=");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(" " + adj.get(i).get(j));
			}
			System.out.println();
		}

	}
}
