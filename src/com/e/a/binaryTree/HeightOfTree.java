package com.e.a.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import a.com.CustomClass.BinaryNode;

public class HeightOfTree {
	
    BinaryNode root;

	public static void main(String[] args) {
		/**
		 * Binary Tree in our example, height = 3 1 (Root) 2 3 (Level 1) 4 5 (Level 2) 6
		 */
		
		HeightOfTree binaryTree = new HeightOfTree();
        
		binaryTree.root = new BinaryNode(1);
		binaryTree.root.left = new BinaryNode(2);
		binaryTree.root.right = new BinaryNode(3);
		binaryTree.root.left.left = new BinaryNode(4);
		binaryTree.root.right.left = new BinaryNode(5);
		binaryTree.root.left.left.left = new BinaryNode(6);

		int heightRecursivelyOfTree = heightRecursively(binaryTree.root);
		System.out.print("Height of Tree : " + heightRecursivelyOfTree);
		int heightIterativelyOfTree = heightIteratively(binaryTree.root);
		System.out.print("\nHeight of Tree : " + heightIterativelyOfTree);
		System.out.println();
	}

	public static int heightIteratively(BinaryNode root) {

		if (root == null) {
			return -1;
		}

		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		int height = -1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			height++;

			while (size > 0) {
				BinaryNode BinaryNode = queue.remove();

				if (BinaryNode.left != null) {
					queue.add(BinaryNode.left);
				}
				if (BinaryNode.right != null) {
					queue.add(BinaryNode.right);
				}
				size--;
			}
		}

		return height;
	}

	public static int heightRecursively(BinaryNode root) {

		if (root == null) {
			return -1;
		}

		int leftHeight = heightRecursively(root.left);
		int rightHeight = heightRecursively(root.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}
}
