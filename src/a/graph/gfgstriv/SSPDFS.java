package a.graph.gfgstriv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SSPDFS {

	private static void dfs(ArrayList<ArrayList<Pair>> adj, int node, Stack<Integer> stack, boolean[] visited) {

		visited[node] = true;
		for (Pair it : adj.get(node)) {
			if (visited[it.getDestination()] == false) {
				dfs(adj, it.getDestination(), stack, visited);
			}
		}
		stack.push(node);
	}

	private static int[] sspDirectedDAGTopologicalDFS(ArrayList<ArrayList<Pair>> adj, int src, int v) {

		int dist[] = new int[v];
		boolean visited[] = new boolean[v];
		Stack<Integer> stack = new Stack<>();

		Arrays.fill(visited, false);
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[src] = 0;

		for (int i = 0; i < v; i++) {
			if (visited[i] == false) {
				dfs(adj, i, stack, visited);
			}
		}
		System.out.println("Stack : " + stack);
		while (!stack.isEmpty()) {
			int node = stack.pop();// it will pop first zero 0
			if (dist[node] != Integer.MAX_VALUE) {
				for (Pair it : adj.get(node)) {
					// 0 + 2 = 2
					if (dist[node] + it.getWeight() < dist[it.getDestination()]) {
						dist[it.getDestination()] = dist[node] + it.getWeight();
					}
				}
			}
		}

		return dist;
	}

	public static void main(String[] args) {
		int V = 6;

		ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();

		for (int i = 0; i < V; i++)
			adj.add(new ArrayList<Pair>());

		adj.get(0).add(new Pair(1, 2));
		adj.get(0).add(new Pair(4, 1));
		adj.get(1).add(new Pair(2, 3));
		adj.get(2).add(new Pair(3, 6));
		adj.get(4).add(new Pair(2, 2));
		adj.get(4).add(new Pair(5, 4));
		adj.get(5).add(new Pair(3, 1));

		printGraph(adj);

		int src = 0;
		int[] ssp = sspDirectedDAGTopologicalDFS(adj, src, V);
		System.out.println("Distance Array : " + Arrays.toString(ssp));

		for (int i = 0; i < ssp.length; i++) {
			System.out.println("Distance from Source " + src + " to " + i + " is " + ssp[i]);
		}
	}

	public static void printGraph(ArrayList<ArrayList<Pair>> adjancencyList) {
		System.out.println("Adjacency list of Graph");
		for (int i = 0; i < adjancencyList.size(); i++) {
			System.out.print("V" + i + " = ");
			for (int j = 0; j < adjancencyList.get(i).size(); j++) {
				System.out.print(
						" " + adjancencyList.get(i).get(j).destination + "," + adjancencyList.get(i).get(j).weight);
			}
			System.out.println();
		}
	}

}
