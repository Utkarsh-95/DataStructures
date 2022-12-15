package com.e.a.binaryTree;

import a.com.CustomClass.BinaryNode;

public class BinaryTreeDiameter {

    BinaryNode root;

    /* A wrapper over diameter(Node root) */
    int diameter() {
        return diameter(root);
    }

    /* Method to calculate the diameter and return it to main */
    int diameter(BinaryNode root) {
        /* base case if tree is empty */
        if (root == null) {
            return 0;
        }

        /* get the height of left and right sub trees */
        int lheight = height(root.getLeft());
        int rheight = height(root.getRight());

        /* get the diameter of left and right subtrees */
        int ldiameter = diameter(root.getLeft());
        int rdiameter = diameter(root.getRight());

        /* Return max of following three 
		1) Diameter of left subtree 
		2) Diameter of right subtree 
		3) Height of left subtree + height of right subtree + 1 */
        return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));

    }

    /*The function Compute the "height" of a tree. Height is the 
	number f nodes along the longest path from the root node 
	down to the farthest leaf node.*/
    static int height(BinaryNode node) {
        /* base case tree is empty */
        if (node == null) {
            return 0;
        }

        /* If tree is not empty then height = 1 + max of left 
		height and right heights */
        return (1 + Math.max(height(node.getLeft()), height(node.getRight())));
    }

    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        BinaryTreeDiameter tree = new BinaryTreeDiameter();
        tree.root = new BinaryNode(1);
        tree.root.setLeft(new BinaryNode(2));
        tree.root.setRight(new BinaryNode(3));
        tree.root.getLeft().setLeft(new BinaryNode(4));
        tree.root.getLeft().setRight(new BinaryNode(5));

        System.out.println("The diameter of given binary tree is : " + tree.diameter());
    }
}
