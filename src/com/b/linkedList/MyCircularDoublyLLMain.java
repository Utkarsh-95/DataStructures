/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b.linkedList;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class MyCircularDoublyLLMain {

    public static void main(String[] args) {

        MyCircularDoublyLL cdll = new MyCircularDoublyLL();
        cdll.createDoublyLL(9);

        cdll.insertAtAnyPosition(10, "head");
        cdll.insertAtAnyPosition(8, "tail");
        cdll.insertAtAnyPosition(7, "tail");
        cdll.insertAtAnyPosition(6, "tail");
        cdll.insertAtAnyPosition(11, "2");

        cdll.traverseLinkedList();
        cdll.traverseLinkedListInReverseOrder();

        cdll.searchNode(11);

//        cdll.deleteLinkedList();
//        cdll.traverseLinkedList();
    }

}
