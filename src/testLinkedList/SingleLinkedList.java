package testLinkedList;

public class SingleLinkedList {

	private static Node head;
	private static Node tail;
	private static int size;

	public static void main(String[] args) {
		createSingleLL(5);
		insertSingleLL(10, 1);
		insertSingleLL(20, 2);
		insertSingleLL(30, 3);
		insertSingleLL(40, 4);

		System.out.println("Linked List : " + head.next);
		traverseSingleLL(head);
		System.out.println("\nSize of the Linked List : " + getSize());
		searchNode(40);
		deleteEntireSingleLL();
		traverseSingleLL(head);
	}

	private static Node createSingleLL(int nodeValue) {

		Node node = new Node();
		node.value = nodeValue;
		node.next = null;
		head = node;
		tail = node;
		size = 1;
		return head;
	}

	private static void insertSingleLL(int nodeValue, int location) {
		Node node = new Node();
		node.value = nodeValue;

		if (head == null) {
			System.out.println("Linked List doesn't exists");
			return;
		} else if (location == 0) {// insert at start
			node.next = head;
			head = node;
		} else if (location >= size) {// insert at last
			node.next = null;
			tail.next = node;
			tail = node;
		} else {
			Node tempNode = head;
			int index = 0;
			while (index < location - 1) {
				node.next = tempNode.next;
				tempNode.next = node;
				index++;
			}
		}
		setSize(getSize() + 1);

	}

	private static void traverseSingleLL(Node node) {

		if (node == null) {
			System.out.println("Linked List doesn't exists");
			return;
		}
		/*while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}*/
		for(int i=0;i<size;i++) {
			System.out.print(node.value);
			if(i != size -1) {
				System.out.print(" -> ");
			}
			node = node.getNext();
		}

	}

	private static void searchNode(int nodeValue) {
		if (head == null) {
			System.out.println("Linked List doesn't exists");
			return;
		}
		Node tempNode = head;
		for (int i = 0; i < getSize(); i++) {
			if (tempNode.value == nodeValue) {
				System.out.print("Found the node " + nodeValue + " at location: " + i + "\n");
				return;
			}
			tempNode = tempNode.getNext();
		}
		System.out.println("Value doesn't Exists : ");
		return;
	}

	private static void deleteEntireSingleLL() {
		head = null;
		tail = null;
		System.out.println("Deleting the entire linked list");
	}

	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		SingleLinkedList.size = size;
	}

}
