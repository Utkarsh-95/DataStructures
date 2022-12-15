/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e.a.binaryTree;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class N_Ary_Tree {

    static class Node {

        int data;
        Node children[];

        Node(int n, int data) {
            children = new Node[n];
            this.data = data;
        }
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        // Total children count
        int total = node.children.length;
        // All the children except the last
        for (int i = 0; i < total - 1; i++) {
            inOrder(node.children[i]);
        }

        // Print the current node's data
        System.out.print(node.data + " ");

        // Last child
        inOrder(node.children[total - 1]);
    }

    public static void main(String[] args) {
        /* Create the following tree 
                   1
                /  |  \
               2   3   4
             / | \
            5  6  7
        */
        N_Ary_Tree tree = new N_Ary_Tree();
        int n = 3;
        Node root = new Node(n, 1);
        root.children[0] = new Node(n, 2);
        root.children[1] = new Node(n, 3);
        root.children[2] = new Node(n, 4);
        root.children[0].children[0] = new Node(n, 5);
        root.children[0].children[1] = new Node(n, 6);
        root.children[0].children[2] = new Node(n, 7);

        tree.inOrder(root);
    }

}
