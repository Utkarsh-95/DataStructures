package a.graph.gfgstriv;

import java.util.ArrayList;

public class CycleDetectionDFS {

	public boolean checkCycleDfsHelper(ArrayList<ArrayList<Integer>> adj, int n) {

		boolean vis[] = new boolean[n + 1];

		for (int i = 1; i < n; i++) {
			if (vis[i] == false) {
				if (isCycleDFS(i, -1, vis, adj)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isCycleDFS(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {

		vis[node] = true;
		for (Integer it : adj.get(node)) {
			if (vis[it] == true) {
				if (isCycleDFS(it, node, vis, adj))
					return true;
			} else if (it != parent) {
				return true;
			}
		}

		return false;
	}

}
