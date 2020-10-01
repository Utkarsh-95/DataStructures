/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarySearchTree;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class BSTImplMain {
    
    public static void main(String[] args) {
        
        BSTImpl tree = new BSTImpl();
        
        System.out.println("Inserting 10 nodes in Tree");
        tree.insert(100);
        tree.insert(80);
        tree.insert(70);
        tree.insert(90);
        tree.insert(50);
        tree.insert(40);
        tree.insert(60);
        tree.insert(150);
        tree.insert(300);
        tree.insert(140);
        tree.insert(290);
        
        System.out.println("\n\nSearching for value on BST...");
        tree.searchForValue(140);
        
        tree.levelOrderTraversal();
        System.out.println("\nPrinting Inorder traversal of Tree...");
        tree.inOrderTraversal(tree.root);
        
        tree.deleteNodeOfBST(150);
        tree.levelOrderTraversal();
        
//        tree.deleteEntire();
        
    }
    
}
