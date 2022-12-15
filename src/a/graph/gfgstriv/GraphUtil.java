package a.graph.gfgstriv;

import java.util.ArrayList;

public class GraphUtil {

	// create Graph representation for 2d array & List<List>
	public static ArrayList<ArrayList<Integer>> createAdjancencyList(int totalVertex) {
		ArrayList<ArrayList<Integer>> adjancencyList = new ArrayList<ArrayList<Integer>>(totalVertex);

		for (int i = 0; i <= totalVertex; i++)
			adjancencyList.add(new ArrayList<Integer>());

		return adjancencyList;
	}

	// A utility function to add an edge in an undirected graph
	public static void addUndirectedEdge(ArrayList<ArrayList<Integer>> adj, int source, int destination) {
		adj.get(source).add(destination);
		adj.get(destination).add(source);
	}

	// A utility function to add an edge in an directed graph
	public static void addDirectedEdge(ArrayList<ArrayList<Integer>> adj, int source, int destination) {
		adj.get(source).add(destination);
	}

	// A utility function to print the adjacency list representation of graph
	public static void printGraph(ArrayList<ArrayList<Integer>> adjancencyList) {
		System.out.println("\nAdjacency list of Graph");
		for (int i = 0; i < adjancencyList.size(); i++) {
			System.out.print("V" + i + " = ");
			for (int j = 0; j < adjancencyList.get(i).size(); j++) {
				System.out.print(" " + adjancencyList.get(i).get(j));
			}
			System.out.println();
		}
	}
}
