/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e.a.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import a.com.CustomClass.BinaryNode;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class RightViewIterative {

	BinaryNode root;

	TreeMap<Integer, Integer> tm = new TreeMap<>();

	private static void leftView(BinaryNode root) {
		if (root == null) {
			return;
		}

		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			// number of nodes at current level
			int n = queue.size();

			for (int i = 1; i <= n; i++) {
				BinaryNode currentNode = queue.poll();

				// Print the left most element at the level
				if (i == 1) {
					System.out.print(currentNode.getData() + " ");
				}

				// Add left node to queue
				if (currentNode.getLeft() != null) {
					queue.add(currentNode.getLeft());
				}

				// Add right node to queue
				if (currentNode.getRight() != null) {
					queue.add(currentNode.getRight());
				}
			}
		}
	}

	private static void rightView(BinaryNode root) {
		if (root == null) {
			return;
		}

		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			// number of nodes at current level
			int n = queue.size();

			// Traverse all nodes of current level
			for (int i = 1; i <= n; i++) {
				BinaryNode currentNode = queue.poll();

				// Print the right most element at the level
				if (i == n) {
					System.out.print(currentNode.getData() + " ");
				}

				// Add left node to queue
				if (currentNode.getLeft() != null) {
					queue.add(currentNode.getLeft());
				}

				// Add right node to queue
				if (currentNode.getRight() != null) {
					queue.add(currentNode.getRight());
				}
			}
		}
	}

	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		RightViewIterative tree = new RightViewIterative();
		tree.root = new BinaryNode(1);
		tree.root.setLeft(new BinaryNode(2));
		tree.root.setRight(new BinaryNode(3));
		tree.root.getRight().setLeft(new BinaryNode(4));
		tree.root.getRight().setRight(new BinaryNode(5));
		tree.root.getRight().getLeft().setRight(new BinaryNode(6));
		tree.root.getRight().getLeft().getRight().setLeft(new BinaryNode(7));

		System.out.println("Left View ");
		leftView(tree.root);
		System.out.println("\nRight View ");
		rightView(tree.root);

		tree.tm.values().stream().forEach((x) -> System.out.print(x + "  "));
	}
}
