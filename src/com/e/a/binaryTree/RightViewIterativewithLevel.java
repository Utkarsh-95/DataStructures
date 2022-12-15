package com.e.a.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import a.com.CustomClass.BinaryNode;
import a.com.CustomClass.Pair;

public class RightViewIterativewithLevel {

	BinaryNode root;

	TreeMap<Integer, Integer> tm = new TreeMap<>();

	private void rightView(int level, BinaryNode node) {

		if (node == null) {
			return;
		}

		Queue<Pair<Integer, BinaryNode>> q = new LinkedList<>();
		q.add(new Pair<>(level, node));

		while (!q.isEmpty()) {
			Pair<Integer, BinaryNode> currentNode = q.poll();

			if (!tm.containsKey(currentNode.getKey())) {
				tm.put(currentNode.getKey(), currentNode.getValue().getData());
			}

			if (currentNode.getValue().getRight() != null) {
				q.add(new Pair<>(currentNode.getKey() + 1, currentNode.getValue().getRight()));
			}

			if (currentNode.getValue().getLeft() != null) {
				q.add(new Pair<>(currentNode.getKey() + 1, currentNode.getValue().getLeft()));
			}
		}
	}

	public static void main(String args[]) {
		int level = 1;
		/* creating a binary tree and entering the nodes */
		RightViewIterativewithLevel tree = new RightViewIterativewithLevel();
		tree.root = new BinaryNode(1);
		tree.root.setLeft(new BinaryNode(2));
		tree.root.setRight(new BinaryNode(3));
		tree.root.getRight().setLeft(new BinaryNode(4));
		tree.root.getRight().setRight(new BinaryNode(5));
		tree.root.getRight().getLeft().setRight(new BinaryNode(6));
		tree.root.getRight().getLeft().getRight().setLeft(new BinaryNode(7));

		tree.rightView(level, tree.root);

		// tree.tm.entrySet().stream().forEach(x -> {
		// System.out.print(" " + x.getKey() + "," + x.getValue() + " ");
		// });
		tree.tm.values().stream().forEach(x -> {
			System.out.print(x + " ");
		});
	}
}
