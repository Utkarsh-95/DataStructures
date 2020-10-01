/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import node.BinaryNode;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class BSTImpl {

    BinaryNode root;

    public BSTImpl() {
        root = null;
    }

    public BinaryNode getRoot() {
        return root;
    }

    public BinaryNode createNewNode(int value) {
        BinaryNode node = new BinaryNode();
        node.setValue(value);
        return node;
    }

    void insert(int value) {
        root = insert(root, value);
    }

    BinaryNode insert(BinaryNode currentNode, int value) {
        if (currentNode == null) {
            System.out.println("Value is inserted in BST with value " + value);
            return createNewNode(value);
        } else if (value <= currentNode.getValue()) {
            currentNode.setLeft(insert(currentNode.getLeft(), value));
            return currentNode;
        } else {
            currentNode.setRight(insert(currentNode.getRight(), value));
        }
        return currentNode;
    }

    void searchForValue(int value) {
        searchForValue(root, value);
    }

    BinaryNode searchForValue(BinaryNode node, int value) {

        if (node == null) {
            System.out.println("Value: " + value + " not found in BST.");
            return null;
        } else if (node.getValue() == value) {
            System.out.println("Value: " + value + " found in BST.");
            return node;
        } else if (value < node.getValue()) {
            return searchForValue(node.getLeft(), value);
        } else {
            return searchForValue(node.getRight(), value);
        }
    }

    void levelOrderTraversal() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.println("\nPrinting Level order traversal of Tree...");
        if (root == null) {
            System.out.println("Tree does not exists !");
            return;
        }
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.getValue() + " ");
            if (presentNode.getLeft() != null) {
                queue.add(presentNode.getLeft());
            }
            if (presentNode.getRight() != null) {
                queue.add(presentNode.getRight());
            }
        }
    }

    void inOrderTraversal(BinaryNode root) {
        if (root == null) {
            System.out.print("Tree is Empty");
            return;
        }

        // order of exceution 
        if (root.getLeft() != null) {
            inOrderTraversal(root.getLeft());
        }
        System.out.print(root.getValue() + " ");

        if (root.getRight() != null) {
            inOrderTraversal(root.getRight());
        }
    }

    void deleteEntire() {
        System.out.println("\nDeleting Entire tree");
        root = null;
        System.out.println("Deleted");
    }

    public void deleteNodeOfBST(int value) {
        System.out.println("\n\nDeleting " + value + " from BST...");
        deleteNodeOfBST(root, value);
    }

    // Helper Method for delete
    public BinaryNode deleteNodeOfBST(BinaryNode root, int value) {
        if (root == null) {
            System.out.println("Value not found in BST");
            return null;
        }

        if (value < root.getValue()) {
            root.setLeft(deleteNodeOfBST(root.getLeft(), value));
        } else if (value > root.getValue()) {
            root.setRight(deleteNodeOfBST(root.getRight(), value));
        } else {// if current node to be deleted 
            if (root.getLeft() != null && root.getRight() != null) {
                BinaryNode tempNode = root;
                BinaryNode deepestNode = deepestElement(tempNode.getRight());// Finding minimum element from right subtree
                root.setValue(deepestNode.getValue());// replace root node with deepest leaf node from right subtree
                System.out.println(deleteNodeOfBST(root.getRight(), deepestNode.getValue()).getValue() + "------");
                deleteNodeOfBST(root.getRight(), deepestNode.getValue());  // Deleting minimum node from right now
            } else if (root.getLeft() != null && root.getRight() == null) {
                root = root.getLeft();
            } else if (root.getRight() != null && root.getLeft() == null) {
                root = root.getRight();
            } else { // if nodeToBeDeleted do not have child (Leaf node)
                root = null;
            }
        }
        return root;
    }

    public BinaryNode deepestElement(BinaryNode root) {
        if (root.getLeft() == null) {
            return root;
        } else {
            return deepestElement(root.getLeft());
        }
    }

}
