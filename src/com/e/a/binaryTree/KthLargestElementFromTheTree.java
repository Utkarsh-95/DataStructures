/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e.a.binaryTree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementFromTheTree {

    private BinaryNode root;

    public static class BinaryNode<T> {

        T value;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public BinaryNode<T> getLeft() {
            return left;
        }

        public void setLeft(BinaryNode<T> left) {
            this.left = left;
        }

        public BinaryNode<T> getRight() {
            return right;
        }

        public void setRight(BinaryNode<T> right) {
            this.right = right;
        }
    }

    private void kthLargestElement(int k, BinaryNode node) {

        if (node == null) {
            return;
        }

//      naturally min heap
//        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
//      custom min heap
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((c1, c2) -> {
            return c1 - c2;
        });

        Queue<BinaryNode> q = new LinkedList<>();

        q.add(node);

        while (!q.isEmpty()) {
            BinaryNode<Integer> currentNode = q.poll();
            pQueue.add(currentNode.getValue());
            if (pQueue.size() > k) {
                pQueue.poll();
            }

            if (currentNode.getLeft() != null) {
                q.add(currentNode.getLeft());

            }

            if (currentNode.getRight() != null) {
                q.add(currentNode.getRight());
            }

        }

        System.out.println(pQueue.peek());
    }
    
    private void kthSmallestElement(int k, BinaryNode node) {

        if (node == null) {
            return;
        }

//      naturally min heap
//        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
//      custom min heap
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((c1, c2) -> {
            return c2 - c1;
        });

        Queue<BinaryNode> q = new LinkedList<>();

        q.add(node);

        while (!q.isEmpty()) {
            BinaryNode<Integer> currentNode = q.poll();
            pQueue.add(currentNode.getValue());
            if (pQueue.size() > k) {
                pQueue.poll();
            }

            if (currentNode.getLeft() != null) {
                q.add(currentNode.getLeft());

            }

            if (currentNode.getRight() != null) {
                q.add(currentNode.getRight());
            }

        }

        System.out.println(pQueue.peek());
    }

    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        KthLargestElementFromTheTree tree = new KthLargestElementFromTheTree();
        tree.root = new BinaryNode(1);
        tree.root.setLeft(new BinaryNode(2));
        tree.root.setRight(new BinaryNode(3));
        tree.root.getRight().setLeft(new BinaryNode(4));
        tree.root.getRight().setRight(new BinaryNode(5));
        tree.root.getRight().getLeft().setRight(new BinaryNode(6));
        tree.root.getRight().getLeft().getRight().setLeft(new BinaryNode(7));

        tree.kthLargestElement(3, tree.root);
        tree.kthSmallestElement(3, tree.root);
    }
}
