/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbinarytree;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class BinaryTreeUsingArray {

    int arr[];
    int lastUsedIndex;

    public BinaryTreeUsingArray(int size) {
        arr = new int[size + 1];
        lastUsedIndex = 0;
        System.out.println("Blank Tree of size " + size + " is created");
    }

    boolean isTreeFull() {
        if (arr.length - 1 == lastUsedIndex) {
            return true;
        } else {
            return false;
        }
    }

    void insertNode(int value) {

        if (!isTreeFull()) {
            arr[lastUsedIndex + 1] = value;
            lastUsedIndex++;
            System.out.println("Successfully inserted in array with value " + value);
        } else {
            System.out.println("Can't insert bcz Array is full ");
        }
    }

    public void levelOrder() {
        for (int i = 1; i <= lastUsedIndex; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    void inOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        } else {
            inOrder(index * 2);
            System.out.print(arr[index] + " ");
            inOrder(index * 2 + 1);
        }
    }

    void preOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        } else {
            System.out.print(arr[index] + " ");
            preOrder(index * 2);
            preOrder(index * 2 + 1);
        }
    }

    void postOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        } else {
            postOrder(index * 2);
            postOrder(index * 2 + 1);
            System.out.print(arr[index] + " ");
        }
    }

    public int search(int value) {
        for (int i = 0; i <= lastUsedIndex; i++) {
            if (arr[i] == value) {
                System.out.print(value + " exists in the Tree! ");
                System.out.println("It is at the location: " + i);
                return i;
            }
        }
        System.out.println(value + " does not exists in Tree !");
        System.out.println();
        return -1;
    }

    public void delete(int value) {
        int location = search(value);
        //if Value does not exists in Array
        if (location == -1) {
            return;
        } else {
            //insert last element of the Tree into current location
            arr[location] = arr[lastUsedIndex];
            lastUsedIndex--;
            System.out.println("Successfully deleted " + value + " from the Tree !");
        }
    }

    public void deleteTree() {
        try {
            arr = null;
            System.out.println("Tree has been deleted successfully");
        } catch (Exception e) {
            System.out.println("There was an error deleting the tree.");
        }
    }

}
