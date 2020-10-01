/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedList;

import java.util.*;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class DetectLoopLinkedList {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
				Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    // Returns true if there is a loop in linked list else returns false.
    static boolean detectLoop(Node h) {
        HashSet<Node> hs = new HashSet<>();
        while (h != null) {
            // If we have already has this node in hashmap it means their is a cycle
            // (Because you we encountering the node second time).
            if (hs.contains(h)) {
                return true;
            }

            // If we are seeing the node for the first time, insert it in hashset
            hs.add(h);

            h = h.next;
        }

        return false;
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        DetectLoopLinkedList llist = new DetectLoopLinkedList();

        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);
        llist.push(5);

        /*Create loop for testing */
        DetectLoopLinkedList.head.next.next = DetectLoopLinkedList.head;

        if (detectLoop(head)) {
            System.out.println("Loop found");
        } else {
            System.out.println("No Loop");
        }
    }
}
