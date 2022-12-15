package com.e.a.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import a.com.CustomClass.BinaryNode;

public class LeavesNodeCount {

    BinaryNode root;

    private int getLeafCount() {
        return getLeafCount_helper_Iterative(root);
    }

    private int getLeafCount_helper_Recursive(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        } else {
            return getLeafCount_helper_Recursive(node.getLeft()) + getLeafCount_helper_Recursive(node.getRight());
        }
    }

    private int getLeafCount_helper_Iterative(BinaryNode root) {

        int sum = 0;

        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BinaryNode currentNode = q.poll();

            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                sum++;
            }

            if (currentNode.getLeft() != null) {
                q.add(currentNode.getLeft());
            }

            if (currentNode.getRight() != null) {
                q.add(currentNode.getRight());
            }
        }

        return sum;
    }

    public static void main(String args[]) {

        LeavesNodeCount tree = new LeavesNodeCount();
        tree.root = new BinaryNode(1);
        tree.root.setLeft(new BinaryNode(2));
        tree.root.setRight(new BinaryNode(3));
        tree.root.getLeft().setLeft(new BinaryNode(4));
        tree.root.getLeft().setRight(new BinaryNode(5));

        System.out.println("The leaf count of binary tree is : " + tree.getLeafCount());
    }
}
