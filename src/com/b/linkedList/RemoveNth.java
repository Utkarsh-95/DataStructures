package com.b.linkedList;

public class RemoveNth {// 19 ques of leetcode
	static ListNode head1, head2;

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

	}

	static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null) {
			return null;
		}

		ListNode first = head;
		ListNode sec = head;

		while (n > 0) {
			sec = sec.next;
			if (sec == null)
				return head.next;
			n--;
		}

		while (sec.next != null) {
			first = first.next;
			sec = sec.next;
		}

		first.next = first.next.next;

		return head;

	}

	public static void main(String[] args) {

		head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(4);
		head1.next.next.next.next = new ListNode(5);

		System.out.println();
		ListNode ress = removeNthFromEnd(head1, 2);
		printList(ress);
	}

}
