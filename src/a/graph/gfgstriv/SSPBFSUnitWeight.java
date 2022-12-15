package a.graph.gfgstriv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SSPBFSUnitWeight {

	private static int[] printShortestPathGraph(int src, ArrayList<ArrayList<Integer>> adj, int v) {
		int distance[] = new int[v + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		Queue<Integer> q = new LinkedList<>();
		distance[src] = 0;
		q.add(src);

		while (!q.isEmpty()) {
			int node = q.poll();

			for (Integer it : adj.get(node)) {
				if (distance[node] + 1 < distance[it]) {
					distance[it] = distance[node] + 1;
					q.add(it);
				}
			}
		}
		return distance;
	}

	public static void main(String[] args) {
		int V = 8;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		adj = GraphUtil.createAdjancencyList(V);

		GraphUtil.addUndirectedEdge(adj, 0, 1);
		GraphUtil.addUndirectedEdge(adj, 0, 3);
		GraphUtil.addUndirectedEdge(adj, 1, 2);
		GraphUtil.addUndirectedEdge(adj, 1, 3);
		GraphUtil.addUndirectedEdge(adj, 2, 6);
		GraphUtil.addUndirectedEdge(adj, 3, 4);
		GraphUtil.addUndirectedEdge(adj, 4, 5);
		GraphUtil.addUndirectedEdge(adj, 5, 6);
		GraphUtil.addUndirectedEdge(adj, 6, 7);
		GraphUtil.addUndirectedEdge(adj, 6, 8);
		GraphUtil.addUndirectedEdge(adj, 7, 8);

		System.out.println("Graph Input : " + adj);

		GraphUtil.printGraph(adj);
		int src = 0;
		int[] ssp = printShortestPathGraph(src, adj, V);
		System.out.println(Arrays.toString(ssp));

		for (int i = 0; i < ssp.length; i++) {
			System.out.println("Distance from Source " + src + " to " + i + " is " + ssp[i]);
		}
	}

}
