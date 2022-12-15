package com.e.a.binaryTree;

import java.util.ArrayList;

import a.com.CustomClass.BinaryNode;

public class TreePathFromRootToLeave {

    private BinaryNode root;

    private void treePathtoLeave(BinaryNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        postOrder_helper(root, new ArrayList<>(), result);
        System.out.println(result);
    }

    private void postOrder_helper(BinaryNode root, ArrayList<Integer> l, ArrayList<ArrayList<Integer>> result) {

        if (root == null) {
            return;
        }

        l.add(root.getData());

        if (root.getLeft() == null && root.getRight() == null) {
//            System.out.print(root.getValue() + " ");
            result.add(l);
        }

        postOrder_helper(root.getLeft(), new ArrayList<>(l), result);
        postOrder_helper(root.getRight(), new ArrayList<>(l), result);
    }

    public static void main(String[] args) {
        /* creating a binary tree and entering the nodes */
        TreePathFromRootToLeave tree = new TreePathFromRootToLeave();
        tree.root = new BinaryNode(6);
        tree.root.setLeft(new BinaryNode(3));
        tree.root.getLeft().setLeft(new BinaryNode(2));
        tree.root.getLeft().setRight(new BinaryNode(5));
        tree.root.getLeft().getRight().setLeft(new BinaryNode(7));
        tree.root.getLeft().getRight().setRight(new BinaryNode(8));
        tree.root.setRight(new BinaryNode(5));
        tree.root.getRight().setRight(new BinaryNode(4));

        tree.treePathtoLeave(tree.root);
    }

}
