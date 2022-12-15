package a.graph.gfgstriv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraphTraversal {

	public ArrayList<Integer> bfsHelper(ArrayList<ArrayList<Integer>> adj, int n) {

		ArrayList<Integer> resultBfs = new ArrayList<Integer>();
		boolean[] vis = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			if (vis[i] == false) {

				Queue<Integer> queue = new LinkedList<>();
				queue.add(i);
				vis[i] = true;

				while (!queue.isEmpty()) {

					Integer node = queue.poll();
					resultBfs.add(node);

					for (Integer it : adj.get(node)) {
						if (vis[it] == false) {
							System.out.println(i + " = " + Arrays.toString(vis));
							vis[it] = true;
							queue.add(it);
						}
					}
				}
			}
		}

		return resultBfs;

	}

}
