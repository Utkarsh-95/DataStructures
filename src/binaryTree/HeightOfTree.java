/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryTree;

import binaryTree.BinaryTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Utkarsh Pratap Singh
 */

public class HeightOfTree {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        /**
         * Binary Tree in our example, height = 3 1	(Root) 2	3	(Level 1) 4 5
         * (Level 2) 6
         */
        binaryTree.root = new TreeNode(1);
        binaryTree.root.left = new TreeNode(2);
        binaryTree.root.right = new TreeNode(3);
        binaryTree.root.left.left = new TreeNode(4);
        binaryTree.root.right.left = new TreeNode(5);
        binaryTree.root.left.left.left = new TreeNode(6);

        int heightOfTree = heightRecursively(binaryTree.root);
//        int heightOfTree = heightIteratively(binaryTree.root);
        System.out.print("Height of Tree : " + heightOfTree);
        System.out.println();
    }

    public static int heightIteratively(TreeNode root) {

        if (root == null) {
            return -1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;

            while (size > 0) {
                TreeNode treeNode = queue.remove();

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                size--;
            }
        }

        return height;
    }

    public static int heightRecursively(TreeNode root) {

        if (root == null) {
            return -1;
        }

        int leftHeight = heightRecursively(root.left);
        int rightHeight = heightRecursively(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
