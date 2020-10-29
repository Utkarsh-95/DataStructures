/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryTree;

import java.util.Stack;
import node.BinaryNode;

/**
 *
 * @author Utkarsh Pratap Singh
 */

/* Class to print the inorder traversal */
public class IterativeBinaryTreeInorder {

    BinaryNode root;

    void inorder() {
        if (root == null) {
            return;
        }

        Stack<BinaryNode> s = new Stack<>();
        BinaryNode curr = root;

        // traverse the tree 
        while (curr != null || s.size() > 0) {

            /* Reach the left most Node of the  curr Node */
            while (curr != null) {
                /* place pointer to a tree node on the stack before traversing the node's left subtree */
                s.push(curr);
                curr = curr.getLeft();
            }
            /* Current must be NULL at this point */
            curr = s.pop();
            System.out.print(curr.getValue() + " ");
            /* we have visited the node and its left subtree. Now, it's right subtree's turn */
            curr = curr.getRight();
        }
    }

    public static void main(String args[]) {

        IterativeBinaryTreeInorder tree = new IterativeBinaryTreeInorder();
        tree.root = new BinaryNode(1);
        tree.root.setLeft(new BinaryNode(2));
        tree.root.setRight(new BinaryNode(3));
        tree.root.getLeft().setLeft(new BinaryNode(4));
        tree.root.getLeft().setRight(new BinaryNode(5));
        tree.inorder();
    }
}
