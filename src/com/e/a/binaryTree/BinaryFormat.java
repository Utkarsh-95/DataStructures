package com.e.a.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import a.com.CustomClass.BinaryNode;

public class BinaryFormat {

    BinaryNode root;

    BinaryFormat() {
        this.root = null;
    }

    void insert(int value) {
        BinaryNode node = new BinaryNode();
        node.setData(value);
        if (root == null) {
            root = node;
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.getLeft() == null) {
                presentNode.setLeft(node);
                System.out.println("Successfully inserted new node at left !" + node.getData());
                break;
            } else if (presentNode.getRight() == null) {
                presentNode.setRight(node);
                System.out.println("Successfully inserted new node at right!" + node.getData());
                break;
            } else {
                queue.add(presentNode.getLeft());
                queue.add(presentNode.getRight());
            }
        }
    }

    void levelOrder() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();//1

            System.out.print(presentNode.getData() + " ");
            if (presentNode.getLeft() != null) {
                queue.add(presentNode.getLeft());//enqueuing in childqueue
            }
            if (presentNode.getRight() != null) {
                queue.add(presentNode.getRight());
            }
        }
    }

    void levelOrderinList() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> parentList = new ArrayList<>();
        List<Integer> childList = new ArrayList<>();

        Queue<BinaryNode> queueChild = new LinkedList<>();

        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();//1
            childList.add(presentNode.getData());//1

            System.out.print(presentNode.getData() + " ");
            if (presentNode.getLeft() != null) {
                queueChild.add(presentNode.getLeft());//enqueuing in childqueue
            }
            if (presentNode.getRight() != null) {
                queueChild.add(presentNode.getRight());
            }

//            here is thw whole logic to convert list of list enqueuing or dequeuing
            if (queue.isEmpty()) {
                parentList.add(childList);
                childList = new ArrayList<>();//re initializing the list
                queue.addAll(queueChild);
                queueChild.clear();
            }
        }
        System.out.println();
        System.out.println(parentList.toString());
    }

    void levelOrderZigZag() {

        Stack<BinaryNode> parentstack = new Stack<>();
        parentstack.push(root);

        List<List<Integer>> parentList = new ArrayList<>();
        List<Integer> childList = new ArrayList<>();
        boolean rtol = true;//left child then right child

        Stack<BinaryNode> stackChild = new Stack<>();

        while (!parentstack.isEmpty()) {
            BinaryNode presentNode = parentstack.pop();//1
            childList.add(presentNode.getData());//1

            System.out.print(presentNode.getData() + " ");
            if (presentNode.getLeft() != null && rtol == true) {
                stackChild.push(presentNode.getLeft());
                stackChild.push(presentNode.getRight());
            }
            if (presentNode.getRight() != null && rtol == false) {
                stackChild.push(presentNode.getRight());
                stackChild.push(presentNode.getLeft());
            }

            if (parentstack.isEmpty()) {
                parentList.add(childList);
                childList = new ArrayList<>();//re initializing the list
                parentstack.addAll(stackChild);
                rtol = false;
                stackChild.clear();
            }
        }
        System.out.println();
        System.out.println(parentList.toString());
    }

    void levelOrderinListwithNullList() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        int levelCheck = 1;
        List<List<Integer>> parentList = new ArrayList<>();
        List<Integer> childList = new ArrayList<>();

        Queue<BinaryNode> queueChild = new LinkedList<>();

        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();//1
            childList.add(presentNode.getData());//1

            System.out.print(presentNode.getData() + " ");
            if (presentNode.getLeft() != null) {
                queueChild.add(presentNode.getLeft());//enqueuing in childqueue
            }
            if (presentNode.getRight() != null) {
                queueChild.add(presentNode.getRight());
            }

//            here is thw whole logic to convert list of list enqueuing or dequeuing
            if (queue.isEmpty()) {
                if(levelCheck % 2 == 0){
//                    System.out.println("binaryTree.BinaryFormat.levelOrderinListwithNullList()"+levelCheck);
                    childList.clear();
                    parentList.add(childList);
                }else{
                    parentList.add(childList);
                }
                
                childList = new ArrayList<>();//re initializing the list
                queue.addAll(queueChild);
                queueChild.clear();
                levelCheck++;
            }

        }
        System.out.println();
        System.out.println(parentList.toString());
    }
}
