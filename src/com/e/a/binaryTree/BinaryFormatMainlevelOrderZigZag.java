package com.e.a.binaryTree;

public class BinaryFormatMainlevelOrderZigZag {

    public static void main(String[] args) {

        BinaryFormat tree = new BinaryFormat();
        System.out.println("Inserting nodes to tree");
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);
        tree.insert(11);
        tree.insert(12);
        tree.insert(13);
        tree.insert(14);
        tree.insert(15);
        tree.insert(16);

//        System.out.println("Level Order Traversal");
//        tree.levelOrder();
//
//        System.out.println("\nLevel Order Traversal in List");
//        tree.levelOrderinList();

        System.out.println("Zig Zag Level Order Traversal");
        tree.levelOrderZigZag();

//        System.out.println("NullList Level Order Traversal");
//        tree.levelOrderinListwithNullList();

    }

}
/*
 * Using Queue
 * Zig Zag Level Order Traversal
1 2 3 5 4 7 6 11 10 9 8 15 14 13 12 
[[1], [2, 3], [5, 4, 7, 6], [11, 10, 9, 8, 15, 14, 13, 12]]

Using Stack
Zig Zag Level Order Traversal
1 3 2 4 5 6 7 14 15 12 13 10 11 8 9 
[[1], [3, 2], [4, 5, 6, 7], [14, 15, 12, 13, 10, 11, 8, 9]]

 * */