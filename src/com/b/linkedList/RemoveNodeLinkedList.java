package com.b.linkedList;

public class RemoveNodeLinkedList {

	static Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node removeIterative(Node head, int val) {

		while (head != null && head.data == val) {
			head = head.next;
		}

		Node curr = head;// temp node
		while (curr != null && curr.next != null) {
			if (curr.next.data == val) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}

		return head;
	}

	void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		RemoveNodeLinkedList list = new RemoveNodeLinkedList();
		head = new Node(3);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(3);
		head.next.next.next.next.next = new Node(6);
		// op = head -> 2 -> 4 -> 6

		System.out.println("Given Linked list");
		list.printList(head);

		head = list.removeIterative(head, 3);
		System.out.println("");
		list.printList(head);
	}
}
