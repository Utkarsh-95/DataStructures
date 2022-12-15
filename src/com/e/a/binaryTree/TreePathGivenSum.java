package com.e.a.binaryTree;

import java.util.ArrayList;
import java.util.List;

import a.com.CustomClass.BinaryNode;

public class TreePathGivenSum {

	BinaryNode root;
	int sumRootToLeave = 0;

	private void treePathwithGivenSum(int sum, BinaryNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		postOrder_helper(root, sum, new ArrayList<>(), result);
		System.out.println(result);
	}

	private void postOrder_helper(BinaryNode root, int sum, List<Integer> l, ArrayList<ArrayList<Integer>> result) {

		if (root == null) {
			return;
		}

		l.add(root.getData());

		if (sum - root.getData() == 0 && root.getLeft() == null && root.getRight() == null) {
//            System.out.print(root.getValue() + " ");
			result.add((ArrayList<Integer>) l);
		}

		postOrder_helper(root.getLeft(), sum - root.getData(), new ArrayList<>(l), result);
		postOrder_helper(root.getRight(), sum - root.getData(), new ArrayList<>(l), result);
	}

	public static void main(String[] args) {
		/* creating a binary tree and entering the nodes */
		TreePathGivenSum tree = new TreePathGivenSum();
		tree.root = new BinaryNode(1);
		tree.root.setLeft(new BinaryNode(2));
		tree.root.setRight(new BinaryNode(3));
		tree.root.getRight().setLeft(new BinaryNode(4));
		tree.root.getRight().setRight(new BinaryNode(17));
		tree.root.getRight().getLeft().setRight(new BinaryNode(6));
		tree.root.getRight().getLeft().getRight().setLeft(new BinaryNode(7));

		tree.treePathwithGivenSum(21, tree.root);
	}

}
