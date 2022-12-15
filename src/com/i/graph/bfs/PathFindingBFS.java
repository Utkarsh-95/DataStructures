package com.i.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import node.TestGraphNode;


public class PathFindingBFS {

	static ArrayList<TestGraphNode> nodeList = new ArrayList<>();

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			nodeList.add(new TestGraphNode("V" + i));
		}

		PathFindingBFS graph = new PathFindingBFS();
		graph.addUndirectedEdge(0, 8);
		graph.addUndirectedEdge(8, 2);
		graph.addUndirectedEdge(8, 9);
		graph.addUndirectedEdge(2, 1);
		graph.addUndirectedEdge(9, 1);
		graph.addUndirectedEdge(2, 4);
		graph.addUndirectedEdge(1, 3);
		graph.addUndirectedEdge(1, 7);
		graph.addUndirectedEdge(3, 4);
		graph.addUndirectedEdge(3, 5);
		graph.addUndirectedEdge(7, 6);
		graph.addUndirectedEdge(5, 6);

		System.out.println("Printing BFS from source: 2");
		graph.BFSForSSSP(nodeList.get(2));
	}
	
	private void BFSForSSSP(TestGraphNode node) {

		Queue<TestGraphNode> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
//			System.out.println(queue.peek().getName());
			TestGraphNode parentNode = queue.remove();
			parentNode.setVisited(true);
			System.out.print("Printing path for node " + parentNode.getName() + ": ");
			pathPrint(parentNode);
			System.out.println();
			for (TestGraphNode neighbour : parentNode.getNeigbhours()) {// for each neighbor of parent node
				if (!neighbour.isVisited()) {
					queue.add(neighbour);
					neighbour.setParent(parentNode);
					neighbour.setVisited(true);
				}
			}
		}
	}

	private void pathPrint(TestGraphNode node) {
		if (node.getParent() != null) {
			pathPrint(node.getParent());
		}
		System.out.print(node.getName() + " ");
	}

	private void addUndirectedEdge(int src, int dest) {
		TestGraphNode first = nodeList.get(src);
		TestGraphNode sec = nodeList.get(dest);

		first.getNeigbhours().add(sec);
		sec.getNeigbhours().add(first);
	}

}
