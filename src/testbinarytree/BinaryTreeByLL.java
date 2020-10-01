/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbinarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class BinaryTreeByLL {

    BinaryNode root;

//    Creating a Binary Tree
    public BinaryTreeByLL() {
        this.root = null;
    }

//    Inserting a value in Binary Tree
    void insertNodeInBinaryTree(int value) {

        BinaryNode node = new BinaryNode();
        node.setValue(value);
        if (root == null) {
            root = node;
            System.out.println("Successfully inserted a new node at Root " + node.getValue());
            return;
        }

//        Level Order Traversal
        Queue<BinaryNode> queue = new LinkedList<>();// Creating q queue
        queue.add(root);//enqueue a root

        while (!queue.isEmpty()) {//queue is not empty
            BinaryNode presentNode = queue.remove();//dequeue
//            then enqueue the child of first element in present node then enqueue in Queue
            if (presentNode.getLeft() == null) {
                presentNode.setLeft(node);
                System.out.println("Successfully inserted new node at left !" + node.getValue());
                break;
            } else if (presentNode.getRight() == null) {
                presentNode.setRight(node);
                System.out.println("Successfully inserted new node at right !" + node.getValue());
                break;
            }
//            enqueue in Queue
            queue.add(presentNode.getLeft());
            queue.add(presentNode.getRight());
        }

    }

    void searchingNodeInBinaryTree(int value) {
        if (root == null) {
            System.out.println("Tree is Empty");
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();//dequeue everytime when checking the queue is not empty
            if (presentNode.getValue() == value) {
                System.out.println("Value : " + value + " is found in Tree");
                return;
            } else {
                if (presentNode.getLeft() != null) {
                    queue.add(presentNode.getLeft());
                }
                if (presentNode.getRight() != null) {
                    queue.add(presentNode.getRight());
                }
            }
        }
        System.out.println("Value : " + value + " is not found in Tree");
    }

    void preOrderTraversal(BinaryNode node) {

        if (node == null) {
            System.out.print("Tree is Empty");
            return;
        }
        System.out.print(node.getValue() + " ");
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }

    void inOrderTraversal(BinaryNode node) {

        if (node == null) {
            System.out.print("Tree is Empty");
            return;
        }

        inOrderTraversal(node.getLeft());
        System.out.print(node.getValue() + " ");
        inOrderTraversal(node.getRight());
    }

    void postOrderTraversal(BinaryNode node) {

        if (node == null) {
            System.out.print("Tree is Empty");
            return;
        }

        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        System.out.print(node.getValue() + " ");
    }

//    Deleting Entire Tree
    void deleteEntireTree() {
        root = null;
        System.out.println("Entire Tree is Deleted");
    }

}
