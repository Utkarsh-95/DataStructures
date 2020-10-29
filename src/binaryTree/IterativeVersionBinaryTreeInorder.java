/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryTree;

import java.util.Stack;
import javafx.util.Pair;
import node.BinaryNode;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class IterativeVersionBinaryTreeInorder {

    BinaryNode root;

    private void iterativeVersionBinaryTreeInorder(BinaryNode root) {

        Stack<Pair<BinaryNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));

        while (!stack.isEmpty()) {
            Pair<BinaryNode, Integer> p = stack.pop();
            if (p.getKey() == null || p.getValue() >= 4) {
                continue;
            }

            stack.push(new Pair<>(p.getKey(), p.getValue() + 1));

            if (p.getValue() == 1) {
                stack.push(new Pair<>(p.getKey().getLeft(), 0));
            }

            if (p.getValue() == 2) {
                System.out.print(p.getKey().getValue() + " ");
            }

            if (p.getValue() == 3) {
                stack.push(new Pair<>(p.getKey().getRight(), 0));
            }

        }

    }

    public static void main(String[] args) {
        IterativeVersionBinaryTreeInorder tree = new IterativeVersionBinaryTreeInorder();
        tree.root = new BinaryNode(1);
        tree.root.setLeft(new BinaryNode(2));
        tree.root.setRight(new BinaryNode(3));
        tree.root.getLeft().setLeft(new BinaryNode(4));
        tree.root.getLeft().setRight(new BinaryNode(5));

        tree.iterativeVersionBinaryTreeInorder(tree.root);
    }

}
