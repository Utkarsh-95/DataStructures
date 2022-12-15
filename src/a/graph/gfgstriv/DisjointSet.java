package a.graph.gfgstriv;

public class DisjointSet {

	static int findParent(int u, int[] parent) {

		if (u == parent[u]) {
			return u;
		}
		return parent[u] = findParent(parent[u], parent); // path compressed
	}

	static void union(int u, int v, int[] parent, int[] rank) {
		u = findParent(u, parent);
		v = findParent(v, parent);
		System.out.println("Rank : " + u + " " + v);
		if (rank[u] < rank[v]) {
			parent[u] = v;
		} else if (rank[v] < rank[u]) {
			parent[v] = u;
		} else {
			parent[v] = u;
			rank[u]++;
		}
	}
}
