package com.e.a.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import a.com.CustomClass.BinaryNode;

public class BinaryTreeLL {

	BinaryNode root;
	int maxlevel;

	BinaryTreeLL() {
		this.root = null;
	}

	public static void main(String[] args) {
		BinaryTreeLL tree = new BinaryTreeLL();
		System.out.println("Inserting 5 nodes to tree");
		tree.insert(1 * 10);
		tree.insert(2 * 10);
		tree.insert(3 * 10);
		tree.insert(4 * 10);
		tree.insert(5 * 10);
		tree.insert(6 * 10);
		tree.insert(7 * 10);
		tree.insert(8 * 10);
		tree.insert(9 * 10);
		System.out.println("Level Order Traversal : ");
		levelOrder(tree.root);
		System.out.println();
		int heightofTreeRecursively = tree.heightofTreeRecursively(tree.root);
		System.out.println("Height of the tree is :" + heightofTreeRecursively);

		int heightofTreeIterativly = tree.heightofTreeIterativly(tree.root);
		System.out.println("Height of the tree is :" + heightofTreeIterativly);

		System.out.println("Deleting 40");
		tree.deleteNodeOfBinaryTree(40);

		System.out.println("Level Order Traversal : ");
		levelOrder(tree.root);
		System.out.println("\nPre Order Traversal :");
		preOrder(tree.root);
		System.out.println("\nIn Order Traversal : ");
		inOrder(tree.root);
		System.out.println("\nPost Order Traversal : ");
		postOrder(tree.root);

		tree.searchNode(60);
		tree.searchNode(400);

		tree.deleteTree();
		System.out.println("Level Order Traversal : ");
		levelOrder(tree.root);
	}

	private int heightofTreeRecursively(BinaryNode root) {
		if (root == null) {
			return 0;
		}

		int left = heightofTreeRecursively(root.left);
		int right = heightofTreeRecursively(root.right);
		return Math.max(left, right) + 1;
	}

	private int heightofTreeIterativly(BinaryNode root) {

		if (root == null) {
			return 0;
		}
		int height = 0;
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			height++;

			while (size > 0) {
				BinaryNode treeNode = queue.remove();

				if (treeNode.left != null) {
					queue.add(treeNode.left);
				}
				if (treeNode.right != null) {
					queue.add(treeNode.right);
				}
				size--;
			}
		}

		return height;
	}

	private void searchNode(int value) {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryNode temp = null;
		while (!queue.isEmpty()) {
			temp = queue.remove();
			if (temp.data == value) {
				System.out.println("\n\nValue " + value + " found at node");
			}
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	private static void levelOrder(BinaryNode node) {
		if (node == null) {
			System.out.println("Tree doesn't exist");
		}
		// make a queue for level order. Queue is Interface and LinkedList is class
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			BinaryNode temp_node = queue.remove();// remove() gives exception
			System.out.print(temp_node.data + " ");
			/* Enqueue left child */
			if (temp_node.left != null) {
				queue.add(temp_node.left);
			}

			/* Enqueue right child */
			if (temp_node.right != null) {
				queue.add(temp_node.right);
			}
		}
	}

	private void insert(int val) {
		BinaryNode node = new BinaryNode();
		node.data = val;
		if (root == null) {
			root = node;
			System.out.println("Successfully inserted new node at Root  :" + node.data);
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<>();// dequeue a root
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode tempNode = queue.remove();
			if (tempNode.left == null) {
				tempNode.left = node;
				System.out.println("Successfully inserted new node at left " + node.data);
				break;
			} else if (tempNode.right == null) {
				tempNode.right = node;
				System.out.println("Successfully inserted new node at right " + node.data);
				break;
			} else {
				queue.add(tempNode.left);
				queue.add(tempNode.right);
			}
		}

	}

	private static void preOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	private static void inOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	private static void postOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}

	void deleteNodeOfBinaryTree(int value) {

		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			BinaryNode temp = queue.remove();
			if (temp.data == value) {
				temp.data = getDeepestNode().data;// deepest node
				System.out.println("Deepest node is : " + temp.data);

				// now delete the deepest node
				deleteDeepest(root, 0, null, getDeepestNode().data);
				return;
			} else {
				if (temp.getLeft() != null) {
					queue.add(temp.getLeft());
				}
				if (temp.getRight() != null) {
					queue.add(temp.getRight());
				}
			}

		}
		System.out.println("Did not find the node!!");
	}

	public void deleteDeepest(BinaryNode root, int level, BinaryNode parent, int deleteThisValue) {
		if (root != null) {
			deleteDeepest(root.getLeft(), level + 1, root, deleteThisValue);
			deleteDeepest(root.getRight(), level + 1, root, deleteThisValue);
			if (level > maxlevel //&& root.getLeft() == null && root.getRight() == null
					&& root.data == deleteThisValue) {

				if (root == parent.getLeft()) {
					parent.setLeft(null);
				} else {
					parent.setRight(null);
				}
				maxlevel = level;
			}
		}
	}

	/*
	 * This method returns the deepest node in the tree according to level order
	 * traversal
	 */
	private BinaryNode getDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryNode temp = null;
		while (!queue.isEmpty()) {
			temp = queue.remove();
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}

		return temp;
	}

	void deleteTree() {
		root = null;
		System.out.println("\nBinary Tree has been deleted successfully");
	}
}
