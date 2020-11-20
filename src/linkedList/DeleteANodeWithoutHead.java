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
public class DeleteANodeWithoutHead {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    private static void deleteNode(Node node) {
        if (node == null) {
            return;
        }

        Node temp = node.next;//4
        node.data = node.next.data;//4
        node.next = temp.next;
    }

    public static void main(String[] args) {
        DeleteANodeWithoutHead llist = new DeleteANodeWithoutHead();

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        for (Node temp = head; temp != null;) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        deleteNode(head.next.next);
        System.out.println();

        for (Node temp = head; temp != null;) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }
}
