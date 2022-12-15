package a.graph.gfgstriv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ToplogicalSortBFS {

	public static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int v) {

		int[] topo = new int[v];
		int[] indeg = new int[v];

		for (int i = 0; i < v; i++) {
			for (int it : adj.get(i)) {
				indeg[it]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < v; i++) {
			if (indeg[i] == 0) {
				q.add(i);
			}
		}

		System.out.println(Arrays.toString(indeg));

		int index = 0;
		while (!q.isEmpty()) {
			int node = q.poll();
			topo[index++] = node;

			for (int it : adj.get(node)) {// 4 -> 0,1
				indeg[it]--;
				if (indeg[it] == 0) {
					q.add(it);
				}
			}
		}
		return topo;
	}

	public static void main(String[] args) {
		int V = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		adj = GraphUtil.createAdjancencyList(V);

		GraphUtil.addDirectedEdge(adj, 2, 3);
		GraphUtil.addDirectedEdge(adj, 3, 1);
		GraphUtil.addDirectedEdge(adj, 4, 0);
		GraphUtil.addDirectedEdge(adj, 4, 1);
		GraphUtil.addDirectedEdge(adj, 5, 0);
		GraphUtil.addDirectedEdge(adj, 5, 2);

		System.out.println("Graph Input : " + adj);

		GraphUtil.printGraph(adj);

		int[] topo = topoSort(adj, V + 1);
		System.out.println("Topological Sort : " + Arrays.toString(topo));

	}

}
