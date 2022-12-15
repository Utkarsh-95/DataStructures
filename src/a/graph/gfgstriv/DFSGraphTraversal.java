package a.graph.gfgstriv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DFSGraphTraversal {

	public ArrayList<Integer> dfsHelper(ArrayList<ArrayList<Integer>> adj, int n) {

		ArrayList<Integer> resultDfs = new ArrayList<Integer>();
		boolean[] vis = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			if (vis[i] == false) {

				Stack<Integer> stack = new Stack<>();
				stack.push(i);
				vis[i] = true;

				while (!stack.isEmpty()) {

					Integer node = stack.pop();
					resultDfs.add(node);

					for (Integer it : adj.get(node)) {
						if (vis[it] == false) {
							System.out.println(i + " = " + Arrays.toString(vis));
							vis[it] = true;
							stack.push(it);
						}
					}
				}
			}
		}

		return resultDfs;
	}

}
