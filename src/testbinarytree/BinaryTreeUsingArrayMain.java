/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbinarytree;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class BinaryTreeUsingArrayMain {

    public static void main(String[] args) {

        System.out.println("Creating a blank array of size 10");
        BinaryTreeUsingArray tree = new BinaryTreeUsingArray(10);

        System.out.println("Inserting 10 value in an Array");
        for (int i = 1; i <= 10; i++) {
            tree.insertNode(i * 10);
        }

        System.out.println("Level Order Traversal Using array");
        tree.levelOrder();

        System.out.println("\nInOrder Traversal Using array");
        tree.inOrder(1);

        System.out.println("\nPreOrder Traversal Using array");
        tree.preOrder(1);

        System.out.println("\nPostOrder Traversal Using array");
        tree.postOrder(1);

        System.out.println("\nSearch 50 in array");
        tree.search(50);

        System.out.println("Delete a node from Binary Tree Using array");
        tree.delete(50);

        System.out.println("Level Order Traversal Using array");
        tree.levelOrder();

        System.out.println("\nDeleting Binary Tree");
        tree.deleteTree();
    }

}
