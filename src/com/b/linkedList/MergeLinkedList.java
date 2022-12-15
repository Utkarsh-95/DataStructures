package com.b.linkedList;

import a.com.CustomClass.SingleNode;

public class MergeLinkedList {

	static SingleNode head1;
	static SingleNode head2;

	// Function to merge two sorted linked list.
	static SingleNode sortedMerge(SingleNode head1, SingleNode head2) {

		// creating a dummy first node to hang the result on.
		SingleNode dummyNode = new SingleNode(0);

		// a pointer, tail is used to store the resultant list after merging.
		SingleNode tail = dummyNode;
		while (true) {
			// if either list runs out, we store all the nodes of
			// other list in link part of tail node.
			if (head1 == null) {
				tail.setNext(head2);
				break;
			}
			if (head2 == null) {
				tail.setNext(head1);
				break;
			}
			// comparing the data of the two lists and storing the node
			// with smaller data in link part of the tail node.
			if (head1.getValue() <= head2.getValue()) {
				tail.setNext(head1);
				// if data in first list is smaller, we move to
				// the next node in it.
				head1 = head1.getNext();
			} else {
				tail.setNext(head2);
				// if data in second list is smaller, we move to
				// the next node in it.
				head2 = head2.getNext();
			}

			// moving to the next node.
			tail = tail.getNext();
		}
		// returning the merged list attached to dummy.
		return dummyNode.getNext();
	}

	public static SingleNode SortedMerge(SingleNode A, SingleNode B) {
		/*
		 * Time Complexity: Since we are traversing through the two lists fully. So, the
		 * time complexity is O(m+n) where m and n are the lengths of the two lists to
		 * be merged.
		 */
		if (A == null)
			return B;
		if (B == null)
			return A;

		if (A.getValue() < B.getValue()) {
			A.next = SortedMerge(A.next, B);
			return A;
		} else {
			B.next = SortedMerge(A, B.next);
			return B;
		}

	}

	static void printList() {
		SingleNode temp = head2;
		while (temp != null) {
			System.out.print(temp.getValue() + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		head1 = new SingleNode(5);
		head1.next = new SingleNode(10);
		head1.next.next = new SingleNode(15);
		head1.next.next.next = new SingleNode(40);

		head2 = new SingleNode(2);
		head2.next = new SingleNode(3);
		head2.next.next = new SingleNode(20);

		// sortedMerge(head1, head2);
		SortedMerge(head1, head2);
		printList();
	}
}
