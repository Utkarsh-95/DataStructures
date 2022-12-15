package com.i.graph.dijkstra;

import java.util.ArrayList;
import node.WeightedNode;

public class PathFindingByDijkstraMain {
	public static void main(String[] args) {
		ArrayList<WeightedNode> nodeList = new ArrayList<>();
//		consider		1,2,3,4,5
//		create 5 nodes: A,B,C,D,E
		for (int i = 0; i < 5; i++) {
			nodeList.add(new WeightedNode("" + (char) (65 + i)));
		}

		// Constructor
		PathFindingByDijkstra graph = new PathFindingByDijkstra(nodeList);

//		graph.addWeightedEdge(1, 3, 6); // Add A-> C , weight 6
//		graph.addWeightedEdge(1, 4, 6); // Add A-> D , weight 3
//		graph.addWeightedEdge(2, 1, 3); // Add B-> A , weight 3
//		graph.addWeightedEdge(3, 4, 2); // Add C-> D , weight 2
//		graph.addWeightedEdge(4, 3, 1); // Add D-> C , weight 1
//		graph.addWeightedEdge(4, 2, 1); // Add D-> B , weight 1
//		graph.addWeightedEdge(5, 2, 4); // Add E-> B , weight 4
//		graph.addWeightedEdge(5, 4, 2); // Add E-> D , weight 2

//		Node A, distance: 6, Path: E->D->B->A
//		Node B, distance: 3, Path: E->D->B
//		Node C, distance: 3, Path: E->D->C
//		Node D, distance: 2, Path: E->D
//		Node E, distance: 0, Path: E

//		Node A, distance: 6, Path: E->D->B->A
//		Node B, distance: 3, Path: E->D->B
//		Node C, distance: 3, Path: E->D->C
//		Node D, distance: 2, Path: E->D
//		Node E, distance: 0, Path: E

		graph.addWeightedEdge(0, 2, 6); // Add A-> C , weight 6
		graph.addWeightedEdge(0, 3, 6); // Add A-> D , weight 3
		graph.addWeightedEdge(1, 0, 3); // Add B-> A , weight 3
		graph.addWeightedEdge(2, 3, 2); // Add C-> D , weight 2
		graph.addWeightedEdge(3, 2, 1); // Add D-> C , weight 1
		graph.addWeightedEdge(3, 1, 1); // Add D-> B , weight 1
		graph.addWeightedEdge(4, 1, 4); // Add E-> B , weight 4
		graph.addWeightedEdge(4, 3, 2); // Add E-> D , weight 2

		System.out.println("Printing Dijkstra from source: E : " + nodeList.get(4));
		graph.dijkstra(nodeList.get(4));
	}// end of method

}// end of class