package com.e.a.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import a.com.CustomClass.BinaryNode;
import a.com.CustomClass.Pair;

public class TopView {

	BinaryNode root;

	TreeMap<Integer, Integer> tm = new TreeMap<>();

	private void topView(int level, BinaryNode node) {

		if (node == null) {
			return;
		}

		Queue<Pair<Integer, BinaryNode>> q = new LinkedList<>();
		q.add(new Pair<>(level, node));

		while (!q.isEmpty()) {
			Pair<Integer, BinaryNode> presentNode = q.poll();// 1,1 2,2

//            System.out.println(presentNode.getKey() + "-" + presentNode.getValue());
			if (!tm.containsKey(presentNode.getKey())) {
				tm.put(presentNode.getKey(), presentNode.getValue().getData());
			}

			if (presentNode.getValue().getLeft() != null) {
				q.add(new Pair<>(presentNode.getKey() - 1, presentNode.getValue().getLeft()));// 0,2
			}

			if (presentNode.getValue().getRight() != null) {
				q.add(new Pair<>(presentNode.getKey() + 1, presentNode.getValue().getRight()));
			}
		}

	}

	public static void main(String args[]) {
		int level = 1;
		/* creating a binary tree and entering the nodes */
		TopView tree = new TopView();
		tree.root = new BinaryNode(1);
		tree.root.setLeft(new BinaryNode(2));
		tree.root.setRight(new BinaryNode(3));
		tree.root.getRight().setLeft(new BinaryNode(4));
		tree.root.getRight().setRight(new BinaryNode(5));
		tree.root.getRight().getLeft().setRight(new BinaryNode(6));
		tree.root.getRight().getLeft().getRight().setLeft(new BinaryNode(7));

		tree.topView(level, tree.root);

		tree.tm.values().stream().forEach((x) -> System.out.print(x + "  "));
	}
}
