package com.e.a.binaryTree;

import java.util.*;

import a.com.CustomClass.BinaryNode;


public class BinaryTreeByLinkedList {

	BinaryNode root;
	int deepestlevel;

	// Constructor for creating a blank Binary Tree
	BinaryTreeByLinkedList() {
		this.root = null;
	}

	// inserts a new node at deepest place in Tree
	void insert(int value) {
		BinaryNode node = new BinaryNode();
		node.setData(value);
		if (root == null) {
			root = node;
			System.out.println("Successfully inserted new node at Root !" + node.getData());
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<>();// create q queue
		queue.add(root);// enqueue a root
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();// dequeue a root
			if (presentNode.getLeft() == null) {
				presentNode.setLeft(node);
				System.out.println("Successfully inserted new node at left !" + node.getData());
				break;
			} else if (presentNode.getRight() == null) {
				presentNode.setRight(node);
				System.out.println("Successfully inserted new node at right!" + node.getData());
				break;
			} else {
				queue.add(presentNode.getLeft());
				queue.add(presentNode.getRight());
			} // end of else-if
		} // end of loop
	}// end of method

	// Search for a given value in binary tree
//    do level order traversal first 
	void search(int value) {

		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if (presentNode.getData() == value) {
				System.out.println("Value-" + value + " is found in Tree !");
				return;
			} else {
				if (presentNode.getLeft() != null) {
					queue.add(presentNode.getLeft());
				}
				if (presentNode.getRight() != null) {
					queue.add(presentNode.getRight());
				}
			}
		} // end of loop
		System.out.println("Value-" + value + " is not found in Tree !");
	}// end of method

	// delete node from binary tree
	void deleteNodeOfBinaryTree(int value) {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			// if node is found then copy deepest node here and delete deepest node.
			if (presentNode.getData() == value) {
				presentNode.setData(getDeepestNode().getData());
				System.out.println("Deepest Value " + getDeepestNode().getData());
//                DeleteDeepestNode();
				deleteDeepest(root, 0, null, getDeepestNode().getData());
				System.out.println("Deleted the node !!");
				return;
			} else {
				if (presentNode.getLeft() != null) {
					queue.add(presentNode.getLeft());
				}
				if (presentNode.getRight() != null) {
					queue.add(presentNode.getRight());
				}
			}
		} // end of while loop
		System.out.println("Did not find the node!!");
	}

	public void deleteDeepest(BinaryNode root, int level, BinaryNode parent, int todelete) {
		if (root != null) {
			deleteDeepest(root.getLeft(), level + 1, root, todelete);
			deleteDeepest(root.getRight(), level + 1, root, todelete);
			if (level > deepestlevel && root.getLeft() == null && root.getRight() == null
					&& root.getData() == todelete) {

				if (root == parent.getLeft()) {
					parent.setLeft(null);
				} else {
					parent.setRight(null);
				}

				deepestlevel = level;
			}
		}
	}

	// Delete deepest node
	public void DeleteDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryNode previousNode, presentNode = null;
		while (!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if (presentNode.getLeft() == null) {
				previousNode.setRight(null);// deleting deep node left
				return;
			} else if ((presentNode.getRight() == null)) {
				previousNode.setLeft(null);// deleting deep node right
				return;
			}
			queue.add(presentNode.getLeft());
			queue.add(presentNode.getRight());
		} // end of while loop
	}// end of method

	// get last node of last level of binary tree
	public BinaryNode getDeepestNode() {
		// make an empty queue. Queue is Interface and LinkedList is class
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryNode presentNode = null;
		while (!queue.isEmpty()) {
			presentNode = queue.remove();
			if (presentNode.getLeft() != null) {
				queue.add(presentNode.getLeft());
			}
			if (presentNode.getRight() != null) {
				queue.add(presentNode.getRight());
			}
		}
		return presentNode;
	}// end of method

	// pre-order traversal of binary tree
	void preOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.getData() + " ");
		preOrder(node.getLeft());
		preOrder(node.getRight());
	}// end of method

	// post-order traversal of binary tree
	void postOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		postOrder(node.getLeft());
		postOrder(node.getRight());
		System.out.print(node.getData() + " ");
	}// end of method

	// in-order traversal of binary tree
	void inOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.getLeft());
		System.out.print(node.getData() + " ");
		inOrder(node.getRight());
	}// end of method

	// level order traversal of binary tree
	void levelOrder() {
		// make a queue for level order. Queue is Interface and LinkedList is class
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.getData() + " ");
			if (presentNode.getLeft() != null) {
				queue.add(presentNode.getLeft());
			}
			if (presentNode.getRight() != null) {
				queue.add(presentNode.getRight());
			}
		}
	}// end of method

	// Delete Tree
	void deleteTree() {
		root = null;
		System.out.println("Binary Tree has been deleted successfully");
	}

}// end of class
