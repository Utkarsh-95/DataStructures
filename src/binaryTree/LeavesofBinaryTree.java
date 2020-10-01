/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryTree;

import java.util.ArrayList;
import java.util.List;
import node.BinaryNode;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class LeavesofBinaryTree {

    BinaryNode root;

    public List<List<Integer>> findLeaves(BinaryNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, root);
        return result;
    }

// traverse the tree bottom-up recursively approach
    private int helper(List<List<Integer>> list, BinaryNode root) {
        if (root == null) {
            return -1;
        }

        int left = helper(list, root.left);
        int right = helper(list, root.getRight());
        int currentNode = Math.max(left, right) + 1;

        // the first time this code is reached is when curr==0,
        //since the tree is bottom-up processed.
        if (list.size() <= currentNode) {
            list.add(new ArrayList<>());
        }

        list.get(currentNode).add(root.getValue());

        return currentNode;
    }

    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        LeavesofBinaryTree tree = new LeavesofBinaryTree();
        tree.root = new BinaryNode(1);
        tree.root.left = new BinaryNode(2);
        tree.root.setRight(new BinaryNode(3));
        tree.root.left.left = new BinaryNode(4);
        tree.root.left.setRight(new BinaryNode(5));

        System.out.println("The leaves of given binary tree is : " + tree.findLeaves(tree.root));
    }
}
