package com.b.linkedList;

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

	/* Iterative Function to reverse the linked list using three pointers */
	Node reverseIteratives(Node node) {
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

	void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		System.out.println("Given Linked list");
		list.printList(head);

		head = list.reverseIterative(head);
		System.out.println("");
		System.out.println("Reversed linked list Recursively");
		list.printList(head);
	}

//	head(prev) -> 1(curr) -> 2(next) -> 3 -> 4 -> 5 -> 6 -> null
//	head(prev) <- 1(curr) <- 2(next) 
	// -> 3 -> 4 -> 5 -> 6 -> null

	private Node reverseIterative(Node node) {

		Node curr = node;
		Node prev = null;
		Node next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;// change the link
			prev = curr;
			curr = next;

		}

		return prev;
	}
}
