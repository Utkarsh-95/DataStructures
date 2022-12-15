package a.graph.gfgstriv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MSTPrimsAlgo {

	private static int[] primsAlgo(ArrayList<ArrayList<PairNode>> adjList, int N) {

		int[] key = new int[N];// store distance/weight
		boolean[] visited = new boolean[N];
		int[] parent = new int[N];
		Arrays.fill(key, Integer.MAX_VALUE);
		Arrays.fill(visited, false);
		Arrays.fill(parent, -1);

		// minheap N, new PairNode() for comparable
		PriorityQueue<PairNode> pq = new PriorityQueue<PairNode>(N, new PairNode());
		key[0] = 0;
		pq.add(new PairNode(0, key[0]));

		int costMST = 0;
//		for(int i=0;i< N-1;i++) {
		while (!pq.isEmpty()) {
			int u = pq.poll().getV();
			visited[u] = true;

			for (PairNode it : adjList.get(u)) {// it -> 1, 3
				if (visited[it.getV()] == false && it.getWeight() < key[it.getV()]) {
					costMST += it.getWeight();
					parent[it.getV()] = u;// 0
					key[it.getV()] = it.getWeight();
					pq.add(new PairNode(it.getV(), key[it.getV()]));
				}
			}

		}
		System.out.println("Minimum Cost : " + costMST);
		System.out.println("Key : " + Arrays.toString(key));
		System.out.println("VisitedMST : " + Arrays.toString(visited));
		System.out.println("Parent : " + Arrays.toString(parent));

		return parent;
	}

	public static void main(String[] args) {

		int V = 5;
		ArrayList<ArrayList<PairNode>> adjList = new ArrayList<ArrayList<PairNode>>();

		for (int i = 0; i < V; i++)
			adjList.add(new ArrayList<PairNode>());

		adjList.get(0).add(new PairNode(1, 2));
		adjList.get(0).add(new PairNode(3, 6));
		adjList.get(1).add(new PairNode(0, 2));
		adjList.get(1).add(new PairNode(3, 8));
		adjList.get(1).add(new PairNode(4, 5));
		adjList.get(1).add(new PairNode(2, 3));
		adjList.get(2).add(new PairNode(1, 3));
		adjList.get(2).add(new PairNode(4, 7));
		adjList.get(3).add(new PairNode(0, 6));
		adjList.get(3).add(new PairNode(1, 8));
		adjList.get(4).add(new PairNode(1, 5));
		adjList.get(4).add(new PairNode(2, 7));

		printGraph(adjList);
		int[] mstPrims = primsAlgo(adjList, V);
		System.out.println("MST of Graph : ");
		for (int i = 0; i < mstPrims.length; i++) {
			System.out.println(" : " + mstPrims[i] + " - " + i);
		}

	}

	private static void printGraph(ArrayList<ArrayList<PairNode>> adjList) {

		System.out.println("Adjacency List of Graph ");
		for (int i = 0; i < adjList.size(); i++) {
			System.out.print("V" + i + " = ");
			for (int j = 0; j < adjList.get(i).size(); j++) {
				System.out.print(adjList.get(i).get(j).getV() + "," + adjList.get(i).get(j).getWeight() + " ");
			}
			System.out.println();
		}

	}

}
