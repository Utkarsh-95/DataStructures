/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryTree;

import testbinarytree.*;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class BinaryTree {

    TreeNode root;

    public static class TreeNode {

        TreeNode left;
        TreeNode right;
        Object data;

        TreeNode(Object data) {
            this.data = data;
            left = right = null;
        }
    }
}
