package testLinkedList;

public class DoubleLinkedList {

	static DoubleNode head;
	static DoubleNode tail;
	static int size;

	public static void main(String[] args) {
		// 5 -> 10 - 15 -> 20 -> NULL
		createDoubleLinkedList(5);
		insertDoubleLinkedList(10, 1);
		insertDoubleLinkedList(20, 2);
		insertDoubleLinkedList(30, 3);
		insertDoubleLinkedList(40, 4);
		traverseDoubleLinkedList(head);
		System.out.println("\nReversing");
		reverseDoubleLinkedList(tail);
		System.out.println("\nSize of the doubly linked list :" + getSize());
		searchingNodeDoubleLinkedList(20);
		System.out.println("Deleting Entire Linked List");
		deleteEntireLinkedList();
		traverseDoubleLinkedList(head);
	}

	private static void createDoubleLinkedList(int nodeValue) {
		DoubleNode node = new DoubleNode();
		node.value = nodeValue;
		head = node;
		tail = node;
		node.next = node.prev = null;
		size = 1;
	}

	private static void traverseDoubleLinkedList(DoubleNode head) {
		if (head == null) {
			System.out.println("Linked List doesn't exists");
			return;
		}
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}

	private static void reverseDoubleLinkedList(DoubleNode tail) {
		if (head == null) {
			System.out.println("Linked List doesn't exists");
			return;
		}
		while (tail != null) {
			System.out.print(tail.value + " ");
			tail = tail.prev;
		}
	}

	private static void insertDoubleLinkedList(int nodeValue, int location) {
		DoubleNode node = new DoubleNode();
		node.value = nodeValue;
		if (head == null) {
			System.out.println("Linked List doesn't exists");
			return;
		} else if (location == 0) {
			node.next = head;
			node.prev = null;
			head.prev = node;
			head = node;
		} else if (location >= size) {
			node.next = null;
			node.prev = tail;
			tail.next = node;
			tail = node;
		} else {
			System.out.println("Inserting at 4 pos");
			DoubleNode tempNode = head;
			int index = 0;
			while (index < location - 1) {
				node.next = tempNode.next;
				node.prev = tempNode;
				tempNode.next = node;
				node.next.prev = node;
				index++;
			}
		}
		setSize(getSize() + 1);
	}

	private static void searchingNodeDoubleLinkedList(int nodeValue) {
		if (head == null) {
			System.out.println("Linked List doesn't exists");
			return;
		} else {
			DoubleNode tempNode = head;
			for (int i = 0; i < getSize(); i++) {
				if (tempNode.value == nodeValue) {
					System.out.println("Value " + nodeValue + " found in Linked List at Node : " + i);
					return;
				}
				tempNode = tempNode.next;
			}
			System.out.println("Value doesn't exists in Linked List");
		}
	}

	private static void deleteEntireLinkedList() {
		DoubleNode tempNode = head;
		for (int i = 0; i < getSize(); i++) {
			tempNode.prev = null;
			head = tail = null;
		}
	}

	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		DoubleLinkedList.size = size;
	}

}
