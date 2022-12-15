/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e.a.binaryTree;

import java.util.TreeMap;

import a.com.CustomClass.BinaryNode;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class RightViewRecursive {

    BinaryNode root;

    TreeMap<Integer, Integer> tm = new TreeMap<>();

    private void rightView(int level, BinaryNode node) {

        if (node == null) {
//            System.out.println(node + "_" + level);
            return;
        }

        if (!tm.containsKey(level)) {
            tm.put(level, node.getData());//1,1
        }
//        for right view
        rightView(level + 1, node.getRight());//2,3 - 3,4 - 4,6
        rightView(level + 1, node.getLeft());//5,7

        //for left view 
//        rightView(level + 1, node.getLeft());//5,7
//        rightView(level + 1, node.getRight());//2,3 - 3,4 - 4,6
    }

    public static void main(String args[]) {
        int level = 1;
        /* creating a binary tree and entering the nodes */
        RightViewRecursive tree = new RightViewRecursive();
        tree.root = new BinaryNode(1);
        tree.root.setLeft(new BinaryNode(2));
        tree.root.setRight(new BinaryNode(3));
        tree.root.getRight().setLeft(new BinaryNode(4));
        tree.root.getRight().setRight(new BinaryNode(5));
        tree.root.getRight().getLeft().setRight(new BinaryNode(6));
        tree.root.getRight().getLeft().getRight().setLeft(new BinaryNode(7));

        tree.rightView(level, tree.root);

        tree.tm.entrySet().stream().forEach(x -> {
            System.out.print(" " + x.getKey() + "," + x.getValue() + " ");
        });

        System.out.println();

        tree.tm.values().stream().forEach(x -> {
            System.out.print(x + " ");
        });
    }
}
