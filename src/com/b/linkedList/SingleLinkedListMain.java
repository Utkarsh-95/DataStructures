package com.b.linkedList;

public class SingleLinkedListMain {

    public static void main(String[] args) {

        SingleLinkedList list = new SingleLinkedList();
        list.createSingleLinkedList(1);
        list.traverseLinkedList();

        list.insertInLinkedList(2, 1);
        list.traverseLinkedList();

        list.insertInLinkedList(3, 2);
        list.traverseLinkedList();

        list.insertInLinkedList(4, 3);
        list.traverseLinkedList();

        list.insertInLinkedList(5, 4);
        list.traverseLinkedList();
        
        System.out.println("----------------------------------------------------");
        list.rotateLinkedList(2);
        list.traverseLinkedList();
        
//
//        System.out.println("\nSearching the node having value 20...");
//        list.searchNode(20);
//
//        System.out.println("\nSearching the node having value 500...");
//        list.searchNode(500);
//
//        System.out.println("\n\nDeleting the node having location = 0: ");
//        System.out.println("Before Deletion:");
//        list.traverseLinkedList();
//        list.deletionOfNode(0);
//        System.out.println("After Deletion:");
//        list.traverseLinkedList();
//        System.out.println();
//
//        System.out.println("\n\nDeleting the node having location = 2: ");
//        System.out.println("Before Deletion:");
//        list.traverseLinkedList();
//        list.deletionOfNode(2);
//        System.out.println("After Deletion:");
//        list.traverseLinkedList();
//        System.out.println();
//
//        System.out.println("\n\nDeleting the node having location = 100: ");
//        System.out.println("Before Deletion:");
//        list.traverseLinkedList();
//        list.deletionOfNode(100);
//        System.out.println("After Deletion:");
//        list.traverseLinkedList();
//        System.out.println();
//
//        list.deleteLinkedList();
//        list.traverseLinkedList();

    }

}
