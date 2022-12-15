package testLinkedList;

public class CircularDoubleLinkedList {

	public static DoubleNode head;
	public static DoubleNode tail;
	public static int size;

	public static void main(String[] args) {
		createCDLL(10);
		insertCDLL(20, 1);
		insertCDLL(30, 2);
		insertCDLL(40, 3);
		insertCDLL(50, 4);
		System.out.println("Size : " + getSize());
		traverseCDLL(head);
		reverseCDLL(tail);
		System.out.println();
		searchNodeCDLL(20);
		searchNodeCDLL(200);
		deleteEntireCDLL();
		traverseCDLL(head);
	}

	private static void deleteEntireCDLL() {
		System.out.println("Deleting Linked List...");
		if (tail == null) {
			System.out.println("Linked List is already deleted, nothing to delete anymore !");
			return;
		} else {
			head.setPrev(null);
			tail.setNext(null);
			head = null;
			tail = null;
			System.out.println("Linked List deleted successfully !");
		}
	}

	private static void searchNodeCDLL(int nodeValue) {
		if (head == null) {
			System.out.println("Linked List doesn't exists");
			return;
		}
		DoubleNode tempNode = head;
		for (int i = 0; i < getSize(); i++) {
			if (tempNode.value == nodeValue) {
				System.out.println("Value " + nodeValue + " found at : Node " + i);
				return;
			}
			tempNode = tempNode.next;
		}
		System.out.println("Value " + nodeValue + " doesn't exist");
	}

	private static void insertCDLL(int nodeValue, int location) {
		DoubleNode node = new DoubleNode();
		node.value = nodeValue;
		if (head == null) {
			System.out.println("Linked List doesn't exits");
			return;
		} else if (location == 0) {
			node.next = head;
			node.prev = tail;
			head.prev = node;
			head = node;
			tail.next = node;
		} else if (location >= size) {
			node.next = head;
			node.prev = tail;
			head.prev = node;
			tail.next = node;
			tail = node;
		} else {
			DoubleNode tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				node.next = tempNode.next;
				node.prev = tempNode;
				tempNode.next = node;
				node.next.prev = node;
			}
		}

		setSize(getSize() + 1);
	}

	private static void createCDLL(int nodeValue) {
		DoubleNode node = new DoubleNode();
		node.value = nodeValue;
		node.setNext(node);
		node.setPrev(node);
		head = node;
		tail = node;
		size = 1;
	}

	private static void traverseCDLL(DoubleNode node) {
		if (head == null) {
			System.out.println("Linked List doesn't exits");
			return;
		}
		DoubleNode tempNode = head;
		for (int i = 0; i < getSize(); i++) {
			System.out.print(tempNode.value + " ");
			if (i != getSize() - 1) {
				System.out.print(" -> ");
			}
			tempNode = tempNode.next;
		}
	}

	private static void reverseCDLL(DoubleNode node) {
		if (head == null) {
			System.out.println("Linked List doesn't exits");
			return;
		}
		DoubleNode tempNode = tail;
		System.out.println("\nPrinting Linked list in reverse order...");
		for (int i = 0; i < getSize(); i++) {
			System.out.print(tempNode.value);
			if (i != getSize() - 1) {
				System.out.print(" <- ");
			}
			tempNode = tempNode.prev;
		}
	}

	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		CircularDoubleLinkedList.size = size;
	}

}
