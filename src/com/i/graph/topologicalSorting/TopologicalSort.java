package com.i.graph.topologicalSorting;

import java.util.ArrayList;
import java.util.Stack;

import a.com.CustomClass.GraphNode;

public class TopologicalSort {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	public TopologicalSort(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}

	Stack<GraphNode> stack = new Stack<>();

	void topologicalSort() {

		for (GraphNode node : nodeList) { // if a node is unvisited then run topologicalSort on it
			if (!node.isVisited())
				topologicalVisit(node, stack);
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().getName() + " ");
		}
	}

	// Topological visit by a source node
	void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {

		for (GraphNode neighbor : node.getNeigbhours()) { // if neighbor is not visited then recursive call to it
			if (!neighbor.isVisited()) {
				topologicalVisit(neighbor, stack);
			}
		}
		node.setVisited(true);
		stack.push(node);
	} // end of method

	// add a directed edge between two nodes
	public void addDirectedEdges(int src, int dest) {
		GraphNode first = nodeList.get(src - 1);
		GraphNode second = nodeList.get(dest - 1);
		first.getNeigbhours().add(second);
	} // end of method

}// end of class