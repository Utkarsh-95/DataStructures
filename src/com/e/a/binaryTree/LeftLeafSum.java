/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e.a.binaryTree;

import java.util.ArrayList;
import java.util.stream.Collectors;

import a.com.CustomClass.BinaryNode;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class LeftLeafSum {

    BinaryNode root;

    ArrayList<Integer> al = new ArrayList<>();

    int sum = 0;

    void InOrderList(BinaryNode node, BinaryNode parent) {

        if (node == null) {
            return;
        }

        InOrderList(node.getLeft(), node);

        if (parent.getLeft() == node && node.getLeft() == null && node.getRight() == null) {
//                || parent.getRight() == node && node.left == null && node.getRight() == null) {
            al.add(node.getData());
        }
        InOrderList(node.getRight(), node);

    }

    void InOrderListPrint(BinaryNode node) {

        if (node == null) {
            return;
        }

        InOrderListPrint(node.getLeft());
        System.out.print(node.getData() + "  ");
        InOrderListPrint(node.getRight());

    }

    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        LeftLeafSum tree = new LeftLeafSum();
        tree.root = new BinaryNode(4);
        tree.root.setLeft(new BinaryNode(1));
        tree.root.setRight(new BinaryNode(6));
        tree.root.getRight().setLeft(new BinaryNode(5));
        tree.root.getRight().setRight(new BinaryNode(7));
        tree.root.getRight().getRight().setRight(new BinaryNode(8));
        tree.root.getLeft().setLeft(new BinaryNode(9));
        tree.root.getLeft().setRight(new BinaryNode(2));
        tree.root.getLeft().getRight().setRight(new BinaryNode(3));

        tree.InOrderList(tree.root, tree.root);
        System.out.println(tree.al);
        tree.InOrderListPrint(tree.root);
        System.out.println();

//        tree.al.forEach((s) -> {
//            tree.sum += s;
//        });
//        using stream
        Integer sum = tree.al.stream()
                .collect(Collectors.summingInt(Integer::intValue));

        System.out.println(sum);
    }
}
