/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a.array;

/**
 *
 * @author Utkarsh Pratap Singh
 */
// Java program for reversal algorithm of array rotation 
public class LeftRotateArray {

	/* Function to left rotate arr[] of size n by d */
	static void leftRotate(int arr[], int d, int n) {

		if (d == 0) {
			return;
		}
		revreseArray(arr, 0, d - 1);
//		printArray(arr);System.out.println();
		revreseArray(arr, d, n - 1);
//		printArray(arr);System.out.println();
		revreseArray(arr, 0, n - 1);
	}

	/* Function to reverse arr[] from index start to end */
	static void revreseArray(int arr[], int start, int end) {
		int temp;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	/* function to print an array */
	static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int n = arr.length;
		int d = 3;

		// in case the rotating factor is greater than array length
		d = d % n;
//		System.out.println(3 % 7 + "=" + d);
		leftRotate(arr, d, n); // Rotate array by d
		printArray(arr);
	}
}
