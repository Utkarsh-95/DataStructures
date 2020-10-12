/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedList;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class ReverseLinkedList {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Iterative Function to reverse the linked list using three pointers*/
    Node reverseIterative(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    static Node reverseRecursivelys(Node node) {
        Node prev = null;
        Node current = null;
        if (node == null || node.next == null) {
            head = node;
            return node;
        }

        prev = node;
        current = reverseRecursivelys(node.next);
        current.next = prev;
        prev.next = null;

        return prev;
    }


    /* Recursive Function to reverse the linked list using three pointers*/
    static Node reverseRecursively(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        /* reverse the rest list and put the first element at the end */
        Node rest = reverseRecursively(node.next);
        node.next.next = node;

        node.next = null;

        /* fix the head pointer */
        return rest;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);

        System.out.println("Given Linked list");
        list.printList(head);

//        head = list.reverseIterative(head);
//        System.out.println("");
//        System.out.println("Reversed linked list Iteratively");
//        list.printList(head);

//        head = list.reverseRecursively(head);
//        System.out.println("");
//        System.out.println("Reversed linked list Recursively");
//        list.printList(head);
        list.reverseRecursivelys(head);
        System.out.println("");
        System.out.println("Reversed linked list Recursively");
        list.printList(head);
    }
}
