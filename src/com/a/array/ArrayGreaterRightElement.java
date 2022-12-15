package com.a.array;

import java.util.Stack;

public class ArrayGreaterRightElement {

	public static void main(String[] args) {
		int arr[] = { 10, 4, 6, 3, 5 };
//		System.out.println(arr.length);
//		checkArray(arr);
		checkArraywithoutStack(arr);
	}

	private static void checkArray(int[] arr) {
		Stack<Integer> st = new Stack<>();

		for (int value : arr) {
			if (!st.isEmpty() && st.peek() < value) {
				st.pop();
			}
			st.push(value);

		}

		while (!st.isEmpty()) {
			System.out.print(st.peek() + " ");
			st.pop();
		}

	}

	private static void checkArraywithoutStack(int[] arr) {

		int max_range = Integer.MIN_VALUE;

		for (int i = arr.length - 1; i >= 0; i--) {

			if (arr[i] > max_range) {
				max_range = arr[i];
				System.out.print(max_range + " ");
			}
		}
	}

}
