package com.i.graph.dijkstra;

import java.util.*;

import node.*;

public class PathFindingByDijkstra {
	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

	// Constructor
	public PathFindingByDijkstra(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}

	// Dijkstra from a Source Node
	/*Algo
	 * 1. set all vertices as infinite & source as 0
	 * 2. save all vertices in minheap
	 * 3. do untill when minheap is not empty
	 * 4. remove node with minimum distance from queue, extract from minheap
	 * 5. for each neighbor of current vertex
	 * 6. if 'known distance' of neighbor is greater than new path 
	 * 		then, update 'distance' of neighbor and also new parent as presentNode 
	 * 
	 */
	void dijkstra(WeightedNode node) {//4
		//PriorityQueue is used for not revisiting the nodes/vertex
		PriorityQueue<WeightedNode> minheap = new PriorityQueue<>();// minheap

//		PriorityQueue<WeightedNode> queue = new PriorityQueue<>((c1, c2) -> {
//			return c2.getDistance() - c1.getDistance();
//		});

		// This will make sure that we start from this vertex in priority queue as
		// distance is min
		// set all vertices as infinite & source as 0
		node.setDistance(0);
		// save all vertices in minheap
		minheap.addAll(nodeList);
//		System.out.println("Minheap : " + minheap);

		// do untill minheap is not empty
		while (!minheap.isEmpty()) {
			System.out.println("Extract from minheap :" + minheap.peek());
			WeightedNode presentNode = minheap.remove(); // remove node with minimum distance from queue, extract from
															// minheap
			for (WeightedNode neighbor : presentNode.getNeighbors()) { // for each neighbor of current vertex
				
				// here we can use also isVisited flag
				
				if (minheap.contains(neighbor)) { // if neighbor is not visited
					// if 'known distance' of neighbor is greater than new path then,
					// update 'distance' of neighbor
					// and also new parent as presentNode
					System.out.println("Neigh " + presentNode.getWeightMap().get(neighbor));
					if (neighbor.getDistance() > (presentNode.getDistance() + presentNode.getWeightMap().get(neighbor))) {
						
						neighbor.setDistance((presentNode.getDistance() + presentNode.getWeightMap().get(neighbor)));
						neighbor.setParent(presentNode);
						
						// Refresh the Priority Queue
						minheap.remove(neighbor);
						minheap.add(neighbor);
					} // end of if block
				} // end of if block
			} // end of for loop
		} // end of while loop

		// print table of node with minimum distance and shortest path from source
		for (WeightedNode nodeToCheck : nodeList) {
			System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.getDistance() + ", Path: ");
			pathPrint(nodeToCheck);
			System.out.println();
		}
	}// end of method

	private static void pathPrint(WeightedNode node) {
		if (node.getParent() != null) {
			pathPrint(node.getParent());
			System.out.print("->" + node);
		} else
			System.out.print(node);
	}// end of method

	// add a weighted directed edge between two nodes
	public void addWeightedEdge(int i, int j, int d) {// 1, 3, 6
		WeightedNode first = nodeList.get(i);// 0
		WeightedNode second = nodeList.get(j);// 2
		first.getNeighbors().add(second);
		first.getWeightMap().put(second, d);// 2 = C, 6
		System.out.println(first.getWeightMap());
	}// end of method

}// end of class
