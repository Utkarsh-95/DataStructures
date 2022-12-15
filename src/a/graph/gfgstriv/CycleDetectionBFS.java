package a.graph.gfgstriv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionBFS {

	static class Node {
		int first;
		int sec;

		public Node(int first, int sec) {
			this.first = first;
			this.sec = sec;
		}
	}

	public boolean checkCycleBfsHelper(ArrayList<ArrayList<Integer>> adj, int n) {

		boolean vis[] = new boolean[n + 1];
		Arrays.fill(vis, false);

		for (int i = 1; i <= n; i++) {
			if (vis[i] == false) {
				if (isCycleBFS(i, vis, adj)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isCycleBFS(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {

		Queue<Node> q = new LinkedList<>();// BFS
		q.add(new Node(node, -1));
		vis[node] = true;

		while (!q.isEmpty()) {
			int nodes = q.peek().first;
			int parent = q.peek().sec;
			q.poll();

			for (Integer it : adj.get(nodes)) {
				if (vis[it] == false) {
					q.add(new Node(it, nodes));
					vis[it] = true;
				} else if (parent != it) {
					return true;
				}
			}
		}

		return false;
	}

}
