package com.g.heap;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementFromTheTree {

	private BinaryNode<Integer> root;

	public static class BinaryNode<T> {

		T value;
		BinaryNode<T> left;
		BinaryNode<T> right;

		public BinaryNode(T value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public BinaryNode<T> getLeft() {
			return left;
		}

		public void setLeft(BinaryNode<T> left) {
			this.left = left;
		}

		public BinaryNode<T> getRight() {
			return right;
		}

		public void setRight(BinaryNode<T> right) {
			this.right = right;
		}
	}

	private void kthLargestElement(int k, BinaryNode<Integer> node) {

		if (node == null) {
			return;
		}

		// naturally min heap
		// PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		// custom min heap
		PriorityQueue<Integer> pQueue = new PriorityQueue<>((c1, c2) -> {
			return c1 - c2;
		});

		Queue<BinaryNode<Integer>> q = new LinkedList<>();
		q.add(node);

		while (!q.isEmpty()) {
			BinaryNode<Integer> currentNode = q.poll();
			pQueue.add(currentNode.getValue());

			if (pQueue.size() > k) {
				pQueue.poll();
			}

			if (currentNode.getLeft() != null) {
				q.add(currentNode.getLeft());
			}

			if (currentNode.getRight() != null) {
				q.add(currentNode.getRight());
			}
		}

		System.out.println(pQueue.peek());
	}

	private void kthSmallestElement(int k, BinaryNode<Integer> node) {

		if (node == null) {
			return;
		}

		// custom max heap
		PriorityQueue<Integer> pQueue = new PriorityQueue<>((c1, c2) -> {
			return c2 - c1;
		});

		Queue<BinaryNode<Integer>> q = new LinkedList<>();

		q.add(node);

		while (!q.isEmpty()) {
			BinaryNode<Integer> currentNode = q.poll();
			pQueue.add(currentNode.getValue());

			if (pQueue.size() > k) {
				pQueue.poll();
			}

			if (currentNode.getLeft() != null) {
				q.add(currentNode.getLeft());

			}

			if (currentNode.getRight() != null) {
				q.add(currentNode.getRight());
			}

		}

		System.out.println(pQueue.peek());
	}

	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		KthLargestElementFromTheTree tree = new KthLargestElementFromTheTree();
		tree.root = new BinaryNode<Integer>(1);
		tree.root.setLeft(new BinaryNode<Integer>(2));
		tree.root.setRight(new BinaryNode<Integer>(3));
		tree.root.getRight().setLeft(new BinaryNode<Integer>(4));
		tree.root.getRight().setRight(new BinaryNode<Integer>(5));
		tree.root.getRight().getLeft().setRight(new BinaryNode<Integer>(6));
		tree.root.getRight().getLeft().getRight().setLeft(new BinaryNode<Integer>(7));

		System.out.print("Kth Largest Element in the Tree : ");
		tree.kthLargestElement(2, tree.root);
		System.out.print("Kth Smallest Element in the Tree : ");
		tree.kthSmallestElement(2, tree.root);
	}
}
