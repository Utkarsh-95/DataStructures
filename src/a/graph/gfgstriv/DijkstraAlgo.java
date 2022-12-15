package a.graph.gfgstriv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgo {

	private static int[] shortestPath(ArrayList<ArrayList<PairNode>> adjList, int src, int N) {

		int[] dist = new int[N + 1];
		PriorityQueue<PairNode> pq = new PriorityQueue<>(N, new PairNode());// minheap
		// N, new PairNode() for comparable

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		pq.add(new PairNode(src, 0));

		// extract from minheap then check the neighbors untill minheap is not empty
		while (!pq.isEmpty()) {
			PairNode node = pq.poll();
			// destination is node(Vertex - V)
			// dist is weight

//			int destination = node.getV();
//			int weight = node.getWeight();

			for (PairNode it : adjList.get(node.getV())) {
//				if (dist[node.getV()] + it.getWeight() < dist[it.getV()]) {
				if (dist[it.getV()] > dist[node.getV()] + it.getWeight()) {
					// for node 4
					// dist[4] = 1
					// it.getWeight() = 3
					// 4 < Integer.MAX_VALUE then update
					dist[it.getV()] = dist[node.getV()] + it.getWeight();
					pq.add(new PairNode(it.getV(), dist[node.getV()]));
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) {

		int V = 5;
		ArrayList<ArrayList<PairNode>> adjList = new ArrayList<ArrayList<PairNode>>();

		for (int i = 0; i <= V; i++)
			adjList.add(new ArrayList<PairNode>());

		// undirected u-v and v-u
		// src -> destination, weight(edge)
		adjList.get(1).add(new PairNode(2, 2));
		adjList.get(1).add(new PairNode(4, 1));
		adjList.get(2).add(new PairNode(1, 2));
		adjList.get(2).add(new PairNode(3, 4));
		adjList.get(2).add(new PairNode(5, 5));
		adjList.get(3).add(new PairNode(2, 4));
		adjList.get(3).add(new PairNode(4, 3));
		adjList.get(3).add(new PairNode(5, 1));
		adjList.get(4).add(new PairNode(1, 1));
		adjList.get(4).add(new PairNode(3, 3));
		adjList.get(5).add(new PairNode(2, 5));
		adjList.get(5).add(new PairNode(3, 1));

		printGraph(adjList);
		int src = 1;
		int[] totalDistanceFromSource = shortestPath(adjList, src, V);
		System.out.println("Total Distance : " + Arrays.toString(totalDistanceFromSource));
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
