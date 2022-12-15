package com.e.a.binaryTree;

import a.com.CustomClass.BinaryNode;

public class SymmetryIdenticalBinaryTree {
	
	//https://www.techiedelight.com/check-if-two-binary-trees-are-identical-not-iterative-recursive/

	BinaryNode root;

	private boolean symmetry(BinaryNode r1, BinaryNode r2) {

		if (r1 == null && r2 == null) {
			return true;
		}

		if (r1 == null || r2 == null) {
			return true;
		}

		return r1.getData() == r2.getData() && symmetry(r1.getLeft(), r2.getRight())
				&& symmetry(r1.getRight(), r2.getLeft());
	}

	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		SymmetryIdenticalBinaryTree tree = new SymmetryIdenticalBinaryTree();
		tree.root = new BinaryNode(1);
		tree.root.setLeft(new BinaryNode(2));
		tree.root.setRight(new BinaryNode(2));
		tree.root.getLeft().setLeft(new BinaryNode(3));
		tree.root.getLeft().setRight(new BinaryNode(4));
		tree.root.getRight().setLeft(new BinaryNode(4));
		tree.root.getRight().setRight(new BinaryNode(3));

		System.out.println("The binary tree is Symmetry: " + tree.symmetry(tree.root, tree.root));
	}
}
