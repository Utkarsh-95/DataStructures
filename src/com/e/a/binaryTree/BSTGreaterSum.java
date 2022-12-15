package com.e.a.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import a.com.CustomClass.BinaryNode;

public class BSTGreaterSum {

    BinaryNode root;

    Map<Integer, Integer> hm = new HashMap<>();
    ArrayList<Integer> al = new ArrayList<>();
    int sum = 0;

    private void bstSum(BinaryNode node) {

        if (node == null) {
            return;
        }

        Queue<BinaryNode> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            BinaryNode presentNode = q.poll();
//            System.out.print(presentNode.getValue() + " ");
            presentNode.setData(hm.get(presentNode.getData()));
            if (presentNode.getLeft() != null) {
                q.add(presentNode.getLeft());
            }
            if (presentNode.getRight() != null) {
                q.add(presentNode.getRight());
            }
        }

    }

    void InOrderList(BinaryNode node) {

        if (node == null) {
            return;
        }

        InOrderList(node.getLeft());
        al.add(node.getData());
        InOrderList(node.getRight());

    }

    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        BSTGreaterSum tree = new BSTGreaterSum();
        tree.root = new BinaryNode(4);
        tree.root.setLeft(new BinaryNode(1));
        tree.root.setRight(new BinaryNode(6));
        tree.root.getRight().setLeft(new BinaryNode(5));
        tree.root.getRight().setRight(new BinaryNode(7));
        tree.root.getRight().getRight().setRight(new BinaryNode(8));
        tree.root.getLeft().setLeft(new BinaryNode(0));
        tree.root.getLeft().setRight(new BinaryNode(2));
        tree.root.getLeft().getRight().setRight(new BinaryNode(3));

        tree.InOrderList(tree.root);
        System.out.println(tree.al);

        for (int i = 0; i < tree.al.size(); i++) {
            tree.sum = 0;
            for (int j = i; j < tree.al.size(); j++) {
                tree.sum += tree.al.get(j);
            }
            tree.hm.put(tree.al.get(i), tree.sum);
        }

        tree.bstSum(tree.root);

        tree.hm.keySet().stream().forEach((x) -> System.out.print(x + "  "));
        System.out.println();
        tree.al.clear();
        tree.InOrderList(tree.root);
        System.out.println(tree.al);
    }
}
