/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b.linkedList;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class CollectionLinkedList {

    public static void main(String args[]) {
        // Creating object of class linked list 
        LinkedList<String> object = new LinkedList<>();

        // Adding elements to the linked list 
        object.add("A");
        object.add("B");
        object.addLast("C");
        object.addFirst("D");
        object.add(2, "E");
        object.add("F");
        object.add("G");
        System.out.println("Linked list : " + object);

        Iterator<String> itr = object.iterator();
        int count = 1;
        while (itr.hasNext()) {
            System.out.println(count++ + "-" + itr.next());
        }

        //Traversing the list of elements in reverse order  
        System.out.println("Traversing the list in Reverse Order");
        Iterator i = object.descendingIterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        // Removing elements from the linked list 
        object.remove("B");
        object.remove(3);
        object.removeFirst();
        object.removeLast();
        System.out.println("Linked list after deletion: " + object);

        // Finding elements in the linked list 
        boolean status = object.contains("E");

        if (status) {
            System.out.println("List contains the element 'E' ");
        } else {
            System.out.println("List doesn't contain the element 'E'");
        }

        // Number of elements in the linked list 
        int size = object.size();
        System.out.println("Size of linked list = " + size);

        // Get and set elements from linked list 
        Object element = object.get(2);
        System.out.println("Element returned by get() : " + element);
        object.set(2, "Y");
//        object.removeFirst();
        System.out.println("Linked list after change : " + object);

        System.out.println("PEEKING--" + object.peekLast());
    }
}
