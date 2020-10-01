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
public class BSTInsertion {

    // Root of BST 
    TreeNode root;

    BSTInsertion() {
        root = null;
    }

    // Wrapper function to call insertRec
    void insert(int value) {
        root = insertRec(root, value);
    }

    // Function to insert value in BST recursively
    TreeNode insertRec(TreeNode root, int value) {// 20 35

        // returns a new node if it reaches NULL
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        //  Or we can move deeper in the tree
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // Wrapper function to call inOrderRec() 
    void inOrder() {
        inOrderRec(root);
    }

    // Function to print inorder traversal of tree recursively
    void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.value + " ");
            inOrderRec(root.right);
        }
    }

    void preOdrer() {
        preOrderRec(root);
    }

    void preOrderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    void postOdrer() {
        postOrderRec(root);
    }

    void postOrderRec(TreeNode root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    // Driver Program to test above functions 
    public static void main(String[] args) {
        BSTInsertion tree = new BSTInsertion();

        tree.insert(50);//root
        tree.insert(35);
        tree.insert(25);
        tree.insert(40);
        tree.insert(75);
        tree.insert(65);
        tree.insert(85);

        // print inOrder traversal of the BST
        System.out.println("\nInorder Traversal");
        tree.inOrder();
        System.out.println();

        // print preOrder traversal of the BST
        System.out.println("\nPreorder Traversal");
        tree.preOdrer();
        System.out.println();

        // print postOrder traversal of the BST
        System.out.println("\nPostorder Traversal");
        tree.postOdrer();
        System.out.println();
    }
}
