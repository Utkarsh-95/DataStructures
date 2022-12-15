package a.graph.gfgstriv;

import java.util.*;

public class CreateGraph {

	// A utility function to add an edge in an undirected graph
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	// A utility function to print the adjacency list representation of graph
	static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		System.out.println("\nAdjacency list of Graph");
		for (int i = 0; i < adj.size(); i++) {
			System.out.print("V" + i + " = ");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(" " + adj.get(i).get(j));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// Creating a graph with 7 vertices
		int V = 7;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

		for (int i = 0; i <= V; i++)
			adj.add(new ArrayList<Integer>());

//		addEdge(adj, 1, 2);
//		addEdge(adj, 2, 7);
//		addEdge(adj, 2, 3);
//		addEdge(adj, 3, 5);
//		addEdge(adj, 5, 7);
//
//		addEdge(adj, 4, 6);// disconnected graph

		addEdge(adj, 1, 2);
		addEdge(adj, 2, 7);
		addEdge(adj, 2, 4);
		addEdge(adj, 4, 6);
		addEdge(adj, 6, 7);

		addEdge(adj, 3, 5);// disconnected graph

		System.out.println("Graph Input : " + adj);

		printGraph(adj);

		BFSGraphTraversal bfs = new BFSGraphTraversal();
		ArrayList<Integer> printBfs = bfs.bfsHelper(adj, V);
		System.out.println("BFS of Graph Output : " + printBfs + "\n");

		DFSGraphTraversal dfs = new DFSGraphTraversal();
		ArrayList<Integer> printDfs = dfs.dfsHelper(adj, V);
		System.out.println("DFS of Graph Output : " + printDfs + "\n");

		CycleDetectionBFS cycleBfs = new CycleDetectionBFS();
		boolean isCycleBFS = cycleBfs.checkCycleBfsHelper(adj, V);
		System.out.println("Is Cycle BFS : " + isCycleBFS);

		CycleDetectionDFS cycleDfs = new CycleDetectionDFS();
		boolean isCycleDFS = cycleDfs.checkCycleDfsHelper(adj, V);
		System.out.println("Is Cycle DFS : " + isCycleDFS);
	}
}
