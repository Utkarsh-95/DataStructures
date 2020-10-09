/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryTree;

import node.BinaryNode;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class SymmetryBinaryTree {

    BinaryNode root;

    private boolean symmetry(BinaryNode r1, BinaryNode r2) {

        if (r1 == null && r2 == null) {
            return true;
        }

        if (r1 == null || r2 == null) {
            return true;
        }

        return r1.getValue() == r2.getValue() && symmetry(r1.getLeft(), r2.getRight()) && symmetry(r1.getRight(), r2.getLeft());
    }

    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        SymmetryBinaryTree tree = new SymmetryBinaryTree();
        tree.root = new BinaryNode(1);
        tree.root.setLeft(new BinaryNode(2));
        tree.root.setRight(new BinaryNode(2));
        tree.root.getLeft().setLeft(new BinaryNode(3));
        tree.root.getLeft().setRight(new BinaryNode(4));
        tree.root.getRight().setLeft(new BinaryNode(4));
        tree.root.getRight().setRight(new BinaryNode(3));

        System.out.println("The binary tree is Symmetry: " + tree.symmetry(tree.root, tree.root));
    }
}
