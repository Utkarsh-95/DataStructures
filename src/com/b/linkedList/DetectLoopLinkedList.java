package com.b.linkedList;

import java.util.*;

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
		/* 1 & 2: Allocate the Node & Put in the data */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	// Returns true if there is a loop in linked list else returns false.
	static boolean detectLoop(Node node) {
		HashSet<Node> hs = new HashSet<>();
		while (node != null) {
			// If we have already has this node in hashmap it means their is a cycle
			// (Because you we encountering the node second time).
			if (hs.contains(node)) {
				System.out.println(node.data);
				return true;
			}

			// If we are seeing the node for the first time, insert it in hashset
			hs.add(node);
			node = node.next;
		}

		return false;
	}

	static Node detectCycle(Node head) {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				slow = head;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}

		return null;
	}

	public static void main(String[] args) {
		DetectLoopLinkedList llist = new DetectLoopLinkedList();
		
		// 3->2->0->4

		llist.push(-4);
		llist.push(0);
		llist.push(2);
		llist.push(3);

		/*while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}*/

		/* Create loop for testing */
		DetectLoopLinkedList.head.next.next.next = DetectLoopLinkedList.head.next;

		if (detectLoop(head)) {
			System.out.println("Loop found");
		} else {
			System.out.println("No Loop");
		}

		Node temp = detectCycle(head);
		System.out.println(temp.data);
	}
}
