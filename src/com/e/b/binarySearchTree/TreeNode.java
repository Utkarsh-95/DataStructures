/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e.b.binarySearchTree;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int item) {
        this.value = item;
        this.left = null;
        this.right = null;
    }

    public int getVal() {
        return value;
    }

    public void setVal(int val) {
        this.value = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
