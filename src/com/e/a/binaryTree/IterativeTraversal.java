package com.e.a.binaryTree;

import java.util.Stack;

import a.com.CustomClass.BinaryNode;
import a.com.CustomClass.Pair;

public class IterativeTraversal {

	public static void main(String[] args) {
		BinaryNode root = new BinaryNode(1);
		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);
		root.left.left = new BinaryNode(4);
		root.right.left = new BinaryNode(5);
		root.right.right = new BinaryNode(6);
		root.right.left.left = new BinaryNode(7);
		root.right.left.right = new BinaryNode(8);

		dfsOrderTraversal(root);
	}

	private static void dfsOrderTraversal(BinaryNode root) {

		Stack<Pair<BinaryNode, Integer>> st = new Stack<>();
		st.push(new Pair<BinaryNode, Integer>(root, 1));

		while (!st.isEmpty()) {
			Pair<BinaryNode, Integer> p = st.pop();
			if (p.getKey() == null || p.getValue() == 4) {
				continue;
			}
			st.push(new Pair<BinaryNode, Integer>(p.getKey(), p.getValue() + 1));

			if (p.getValue() == 1) {// for preOrder
//				st.push(new Pair<BinaryNode, Integer>(p.getKey().left, 1));
				System.out.print(p.getKey().data + " ");
			}
			if (p.getValue() == 2) {// for Inorder
//				System.out.print(p.getKey().data + " ");
				st.push(new Pair<BinaryNode, Integer>(p.getKey().left, 1));
			}
			if (p.getValue() == 3) {// for PostOrder
				st.push(new Pair<BinaryNode, Integer>(p.getKey().right, 1));
			}

		}

	}

}
