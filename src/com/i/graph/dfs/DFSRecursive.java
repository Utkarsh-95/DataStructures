package com.i.graph.dfs;
import java.util.ArrayList;

import a.com.CustomClass.GraphNode;

public class DFSRecursive {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	
	public DFSRecursive(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	
	void dfs() {
		//if a node is unvisited then run dfs on it
		for(GraphNode node: nodeList) {
			if(!node.isVisited())
				dfsVisit(node);
		}
	}
	
	
	//dfs traversal by a source node
	void dfsVisit(GraphNode node) {
		//mark node as visited
		node.setVisited(true);
		//print the node
		System.out.print(node.getName()+" ");
		//for each neighbor of present node
		for(GraphNode neighbor: node.getNeigbhours()) {
			//if neighbor is not visited 
			if(!neighbor.isVisited()) {
				//recursive call to dfs function
				dfsVisit(neighbor);
			}
		}
	}
	
	// add an undirected edge between two nodes
	public void addUndirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i-1);
		GraphNode second = nodeList.get(j-1);
		first.getNeigbhours().add(second);
		second.getNeigbhours().add(first);
	}
	
}
