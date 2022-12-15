package com.i.graph.topologicalSorting;

import java.util.ArrayList;

import a.com.CustomClass.GraphNode;

public class TopologicalSortMain {

	public static void main(String[] args) {

		ArrayList<GraphNode> nodeList = new ArrayList<>();

		// create 10 nodes: v1-v10
		for (int i = 1; i < 11; i++) {
			nodeList.add(new GraphNode("V" + i));
//			nodeList.add(new GraphNode("V",i));
		}

		// Constructor
		TopologicalSort graph = new TopologicalSort(nodeList);

		// add edges following graph in graph.docx
		graph.addDirectedEdges(1, 2);
		graph.addDirectedEdges(1, 4);
		graph.addDirectedEdges(2, 3);
		graph.addDirectedEdges(2, 5);
		graph.addDirectedEdges(3, 6);
		graph.addDirectedEdges(3, 10);
		graph.addDirectedEdges(4, 7);
		graph.addDirectedEdges(5, 8);
		graph.addDirectedEdges(6, 9);
		graph.addDirectedEdges(7, 8);
		graph.addDirectedEdges(8, 9);
		graph.addDirectedEdges(9, 10);

		System.out.println("Printing Topological Sort from source: V1");
		graph.topologicalSort();
		
		/*
		 * Printing DFS from source: V1
		 * V1 V4 V7 V2 V5 V8 V3 V6 V9 V10 
		 * */
	}

}
