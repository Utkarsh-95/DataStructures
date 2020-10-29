/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import node.BinaryNode;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class TreePruning {

    BinaryNode root;

    private static BinaryNode pruningTree(BinaryNode node) {

        if (node == null) {
            return null;
        }

        node.setLeft(pruningTree(node.getLeft()));
        node.setRight(pruningTree(node.getRight()));

        if (node.getValue() == 0 && node.getLeft() == null && node.getRight() == null) {
            node = null;
        }

        return node;
    }

    void levelOrder() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
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

    public static void main(String[] args) {
        TreePruning tree = new TreePruning();
        tree.root = new BinaryNode(1);
        tree.root.setLeft(new BinaryNode(0));
        tree.root.getLeft().setLeft(new BinaryNode(0));
        tree.root.setRight(new BinaryNode(0));
        tree.root.getRight().setLeft(new BinaryNode(1));
        tree.root.getRight().setRight(new BinaryNode(0));

        TreePruning.pruningTree(tree.root);
        tree.levelOrder();

//        int coreCount = Runtime.getRuntime().availableProcessors();
//        System.out.println(coreCount);
    }

}
