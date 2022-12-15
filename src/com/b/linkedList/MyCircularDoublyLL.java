/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b.linkedList;

import a.com.CustomClass.DoubleNode;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class MyCircularDoublyLL {

    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public DoubleNode getHead() {
        return head;
    }

    public void setHead(DoubleNode head) {
        this.head = head;
    }

    public DoubleNode getTail() {
        return tail;
    }

    public void setTail(DoubleNode tail) {
        this.tail = tail;
    }

    public DoubleNode createDoublyLL(int nodeValue) {
        head = new DoubleNode();
        DoubleNode node = new DoubleNode();
        node.setValue(nodeValue);
        node.setNext(node);
        node.setPrev(node);
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertAtAnyPosition(int nodeValue, String location) {
        DoubleNode node = new DoubleNode();
        node.setValue(nodeValue);

        if (head == null) {
            node.setNext(node);
            node.setPrev(node);
            head = tail = node;
        } else if (location.equals("head")) {
            // for newly added node
            node.setPrev(tail);
            node.setNext(head);

            // for previous node head tail 
            head.setPrev(node);
            tail.setNext(node);
            head = node;
        } else if (location.equals("tail")) {
            node.setPrev(tail);
            node.setNext(head);
            head.setPrev(node);
            tail.setNext(node);
            tail = node;
        } else {
            System.out.println("Inserting Value at Specified location = " + location);
            DoubleNode tempNode = head;
            int index = 0;
            while (index < (Integer.parseInt(location) - 1)) {
                tempNode = tempNode.getNext();
                index++;
            }
            node.setPrev(tempNode);
            node.setNext(tempNode.getNext());
            tempNode.setNext(node);
            node.getNext().setPrev(node);
        }
        size++;
    }

    public boolean searchNode(int nodeValue) {
        if (head != null) {
            DoubleNode tempNode = head;
//            traverseLinkedList();
            for (int i = 0; i < size - 1; i++) {
                if (tempNode.getValue() == nodeValue) {
                    System.out.println("\nNode found at position = " + i + " with value " + tempNode.getValue());
                }
                tempNode = tempNode.getNext();
            }
        } else {
            System.out.println("Node not found");
        }

        return false;
    }

    public void deleteLinkedList() {
        if (tail == null) {
            return;
        } else {
            head.setPrev(null);
            tail.setNext(null);
            head = null;
            tail = null;
            System.out.println("Linked List deleted successfully !");
        }
    }

    public void traverseLinkedList() {
        System.out.print("Circular Doubly Linked List = ");
        DoubleNode ptr = head;
        if (head == null) {
            System.out.println("Linked List doesn't Exist");
            return;
        }

        if (head.getNext() == head) {
            System.out.print(head.getValue() + " <-> " + ptr.getValue() + "\n");
            return;
        }
        System.out.print(head.getValue() + " <-> ");
        ptr = head.getNext();
        while (ptr.getNext() != head) {
            System.out.print(ptr.getValue() + " <-> ");
            ptr = ptr.getNext();
        }
        System.out.println(ptr.getValue());
        ptr = ptr.getNext();
    }

    public void traverseLinkedListInReverseOrder() {
        if (head != null) {
            DoubleNode tempNode = tail;
            System.out.println("\nPrinting Linked list in reverse order...");
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.getValue());
                if (i != size - 1) {
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.getPrev();
            }
            System.out.print("\n");
        } else {
            System.out.println("Linked List does not exists !");
        }
    }

}
