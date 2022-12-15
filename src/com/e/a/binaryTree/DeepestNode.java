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
public class DeepestNode {

    int deepestlevel;
    int value;

    public int Deep(Node root) {
        find(root, 0);
        return value;
    }

    public void find(Node root, int level) {
        if (root != null) {
            find(root.left, ++level);
            if (level > deepestlevel) {
                value = root.data;
                deepestlevel = level;
            }
            find(root.right, level);
        }
    }

    public void deleteDeepest(Node root, int level, Node parent) {
        if (root != null) {
            deleteDeepest(root.left, ++level, root);
            if (level > deepestlevel && root.left == null && root.right == null) {
                value = root.data;

                if (root == parent.left) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }

                deepestlevel = level;
            }
            deleteDeepest(root.right, level, root);
        }
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);

        DeepestNode dp = new DeepestNode();
        System.out.println("Deepest child is: " + dp.Deep(root));

    }
}

class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
