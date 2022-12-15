package testBinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	static TreeNode root;

	public BinarySearchTree() {
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insertBST(100);
		tree.insertBST(80);
		tree.insertBST(200);
		tree.insertBST(70);
		tree.insertBST(90);
		tree.insertBST(150);
		tree.insertBST(300);
		tree.insertBST(50);
		tree.insertBST(85);
		tree.insertBST(140);
		tree.insertBST(250);
		tree.insertBST(400);
		tree.insertBST(40);
		tree.insertBST(60);

		int height = tree.height(root);
		System.out.println("Height of tree :" + height);

		tree.searchBSTHelper(60);
		tree.searchBSTHelper(400);
		tree.searchBSTHelper(700);
		System.out.println("PreOrder Traversal...");
		preOrder(root);

		System.out.println("\nInOrder Traversal...");
		inOrder(root);

		System.out.println("\nPostOrder Traversal...");
		postOrder(root);

		System.out.println("\nLevelOrder Traversal...");
		tree.levelOrder();

		tree.deleteNodeOfBST(60);
		tree.levelOrder();

		tree.deleteNodeOfBST(80);
		tree.levelOrder();

		tree.deleteNodeOfBST(100);
		tree.levelOrder();

		tree.deleteBST();
		tree.levelOrder();
	}

	private int height(TreeNode node) {

		if (node == null) {
			return -1;
		}

		int left = height(node.left);
		int right = height(node.right);

		return Math.max(left, right) + 1;
	}

	public void deleteNodeOfBST(int value) {
		System.out.println("\n\nDeleting " + value + " from BST...");
		deleteNodeOfBST(root, value);
	}

	// Helper Method for delete
	public TreeNode deleteNodeOfBST(TreeNode root, int value) {
		if (root == null) {
			System.out.println("Value not found in BST");
			return null;
		}
		if (value < root.data) {
			root.left = (deleteNodeOfBST(root.left, value));
		} else if (value > root.data) {
			root.right = (deleteNodeOfBST(root.right, value));
		} else { // If currentNode is the node to be deleted

			if (root.left != null && root.right != null) { // if nodeToBeDeleted have both children
				TreeNode temp = root;
				TreeNode minNodeForRight = minimumElement(temp.right);// Finding minimum element from right subtree
				root.data = (minNodeForRight.data); // Replacing current node with minimum node from right
													// subtree
				root.right = (deleteNodeOfBST(root.right, minNodeForRight.data)); // Deleting minimum node
																					// from right now
			} else if (root.left != null) {// if nodeToBeDeleted has only left child
				root = root.left;
			} else if (root.right != null) {// if nodeToBeDeleted has only right child
				root = root.right;
			} else // if nodeToBeDeleted do not have child (Leaf node)
			{
				root = null;
			}
		}
		return root;
	}

	public static TreeNode minimumElement(TreeNode root) {
		if (root.getLeft() == null) {
			return root;
		} else {
			return minimumElement(root.getLeft());
		}
	}

	private void deleteBST() {
		System.out.println("\nDeleting entire Tree...");
		root = null;
		System.out.println("Tree deleted successfully !");
	}

	private void levelOrder() {

		if (root == null) {
			System.out.println("Tree does not exists !");
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		TreeNode tempNode = null;
		while (!queue.isEmpty()) {
			tempNode = queue.remove();
			System.out.print(tempNode.data + " ");
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}

	private static void postOrder(TreeNode node) {
		if (node == null) {
			return;
		}

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}

	private static void inOrder(TreeNode node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	private static void preOrder(TreeNode node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	private void insertBST(int value) {
		root = insertBSTHelper(root, value);

	}

	private TreeNode insertBSTHelper(TreeNode currentNode, int value) {
		if (currentNode == null) {
			System.out.println("Value " + value + " is Inserted in tree");
			TreeNode node = new TreeNode();
			node.data = value;
			return node;
		} else if (value <= currentNode.data) {
			currentNode.left = insertBSTHelper(currentNode.left, value);
		} else {
			currentNode.right = insertBSTHelper(currentNode.right, value);
		}
		return currentNode;
	}

	private void searchBSTHelper(int value) {
		searchForValue(root, value);
	}

	TreeNode searchForValue(TreeNode node, int value) {
		if (node == null) {
			System.out.println("Value: " + value + " not found in BST.");
			return null;
		} else if (node.data == value) {
			System.out.println("Value: " + value + " found in BST.");
			return node;
		} else if (value < node.data) {
			return searchForValue(node.left, value);
		} else {
			return searchForValue(node.right, value);
		}
	}

}
