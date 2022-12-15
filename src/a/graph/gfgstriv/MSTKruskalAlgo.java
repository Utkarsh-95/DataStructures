package a.graph.gfgstriv;

import java.util.ArrayList;
import java.util.Arrays;

public class MSTKruskalAlgo {

	public static void main(String[] args) {
		int V = 5;
		ArrayList<Node> adj = new ArrayList<>();

		adj.add(new Node(0, 1, 2));
		adj.add(new Node(0, 3, 6));
		adj.add(new Node(1, 3, 8));
		adj.add(new Node(1, 2, 3));
		adj.add(new Node(1, 4, 5));
		adj.add(new Node(2, 4, 7));

		KruskalAlgo(adj, V);

	}

	private static void KruskalAlgo(ArrayList<Node> adj, int N) {
		int parent[] = new int[N];
		int rank[] = new int[N];

		// making the set
		for (int i = 0; i < N; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

		System.out.println("Parent : " + Arrays.toString(parent));
		System.out.println("Rank   : " + Arrays.toString(rank));

		int costMst = 0;
		ArrayList<Node> mst = new ArrayList<Node>();
		for (Node it : adj) {
			System.out.println(it.getU() + " " + it.getV());
			if (DisjointSet.findParent(it.getU(), parent) != DisjointSet.findParent(it.getV(), parent)) {
				costMst += it.getWeight();
				mst.add(it);
				// for MST
				DisjointSet.union(it.getU(), it.getV(), parent, rank);
			}
		}
		System.out.println("Minimum cost of spanning tree is : " + costMst);
		System.out.println("MST Graph ");
		for (Node it : mst) {
			System.out.println(it.getU() + " - " + it.getV() + " = " + it.getWeight());
		}
	}

}
