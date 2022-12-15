package testLinkedList;

public class SingleCircularLinkedList {

	private static Node head;
	private static Node tail;
	private static int size;

	public static void main(String[] args) {
		createSingleCircularLinkedList(5);
		// traverseSingleCircularLinkedList(head);
		// System.out.println();
		insertNodeSingleCircularLinkedList(10, 1);
		insertNodeSingleCircularLinkedList(20, 2);
		insertNodeSingleCircularLinkedList(30, 3);
		insertNodeSingleCircularLinkedList(40, 4);
		insertNodeSingleCircularLinkedList(50, 5);
		traverseSingleCircularLinkedList(head);
		searchSingleCircularLinkedList(40);
		searchSingleCircularLinkedList(60);
		searchSingleCircularLinkedList(10);
		System.out.println("Size of an linked list : " + getSize());
		deleteNodeSingleCircularLinkedList(5);
		traverseSingleCircularLinkedList(head);
		deleteEntireSingleCircularLinkedList();
		traverseSingleCircularLinkedList(head);
	}

	private static Node createSingleCircularLinkedList(int nodeValue) {
		Node node = new Node();
		node.setValue(nodeValue);
		node.setNext(node);
		head = node;
		tail = node;
		size = 1;
		return head;
	}

	private static void traverseSingleCircularLinkedList(Node node) {
		if (node == null) {
			System.out.println("Linked List doesn't exists");
			return;
		}

		for (int i = 0; i < size; i++) {
			System.out.print(node.value + " ");
			if (i != size - 1) {
				System.out.print(" -> ");
			}
			node = node.next;
		}
	}

	private static void insertNodeSingleCircularLinkedList(int nodeValue, int location) {
		Node node = new Node();
		node.value = nodeValue;
		if (head == null) {
			System.out.println("Linked List doesn't exists");
			return;
		} else if (location == 0) {
			node.next = head;
			head = node;
			tail.next = head;
		} else if (location >= size) {
			node.next = head;
			tail.next = node;
			tail = node;
		} else {
			Node tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				node.next = tempNode.next;
				tempNode.next = node;
			}
		}
		setSize(getSize() + 1);
	}

	private static void searchSingleCircularLinkedList(int nodeValue) {
		if (head == null) {
			System.out.println("Linked List doesn't exists");
			return;
		}
		Node tempNode = head;
		for (int i = 0; i < getSize(); i++) {
			if (tempNode.value == nodeValue) {
				System.out.println("\nValue " + nodeValue + " found in linked list at node " + i);
				return;
			}
			tempNode = tempNode.next;// moving cursor
		}
		System.out.println("\nValue doesn't found in linked list");
		return;
	}

	private static void deleteEntireSingleCircularLinkedList() {
		if (tail == null) {
			System.out.println("Linked List is already deleted, nothing to delete !");
			return;
		} else {
			head = null;
			tail.next = null;
			tail = null;
			System.out.println("\nEntire linked list is deleted............");
		}
	}

	private static void deleteNodeSingleCircularLinkedList(int location) {
		if (head == null) {
			System.out.println("Linked list doesn't exist");
			return;
		} else if (location == 0) {// we want to delete first element
			head = head.next;
			tail.next = head;
			setSize(getSize() - 1);
			// corner case
			if (getSize() == 0) {
				System.out.println("only one node in CLL");
				head = tail = null;
			}
		} else if (location >= getSize()) {
			System.out.println("Deleting last node of CLL");
			Node tempNode = head;
			for (int i = 0; i < getSize() - 1; i++) {
				tempNode = tempNode.next;
			}
			if (tempNode == head) { // if this is the only element in the list
				System.out.println("if this is the only element in the list");
				tail = head = null;
				setSize(getSize() - 1);
				return;
			}
			tempNode.next = head;
			tail = tempNode;
			setSize(getSize() - 1);
		} else {
			System.out.println("Delete node anywhere in CLL");
			Node tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.next;
			}
			tempNode.next = tempNode.next.next;
			setSize(getSize() - 1);
		}
	}

	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		SingleCircularLinkedList.size = size;
	}

}
