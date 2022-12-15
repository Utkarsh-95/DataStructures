package com.i.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;

import a.com.CustomClass.GraphNode;

public class BFSByLinkedList {

	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	// Constructor
	public BFSByLinkedList(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}// end of method

	// BFS Algorithm
	void bfs() {
		// if a node is unvisited then run bfs on it
		for (GraphNode node : nodeList) {
			if (!node.isVisited())
				bfsVisit(node);
		}
	}// end of method

	// BFS internal method
	void bfsVisit(GraphNode node) {
		LinkedList<GraphNode> queue = new LinkedList<>();
		queue.add(node); // add source node to queue
		while (!queue.isEmpty()) {
			GraphNode presentNode = queue.remove();
			presentNode.setVisited(true);
			System.out.print(presentNode.getName() + " ");
			for (GraphNode neighbor : presentNode.getNeigbhours()) { // for each neighbor of present node
				if (!neighbor.isVisited()) { // if neighbor is not visited then add it to queue
					queue.add(neighbor);
					neighbor.setVisited(true);
				}
			} // end of for loop
		} // end of while loop
	}// end of method

	// Add an undirected edge between two nodes
	public void addUndirectedEdge(int src, int dest) {// 1,2
		GraphNode first = nodeList.get(src - 1);//0
		GraphNode second = nodeList.get(dest - 1);//1
		first.getNeigbhours().add(second);// Neighbour of first is second. Store it.
		second.getNeigbhours().add(first);// Neighbour of second is first. Store it.
	}// end of method

}// end of class
