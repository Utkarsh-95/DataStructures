package com.g.heap;

import java.util.PriorityQueue;

public class SumOfElementsbetK1K2 {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 12, 5, 15, 11 };
		int n = arr.length;
		int k1 = 3;
		int k2 = 6;
		System.out.println(sumofElements(arr, n, k1, k2));
	}

	private static int sumofElements(int[] arr, int n, int k1, int k2) {

		int sum = 0;

		int first = kthsmallest(arr, k1);
		int sec = kthsmallest(arr, k2);

		System.out.println(first + "-" + sec);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > first && arr[i] < sec) {
				sum += arr[i];
			}
		}

		return sum;
	}

	private static int kthsmallest(int[] arr, int k) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((c1, c2) -> {
			return c2 - c1;
		});

		for (int i = 0; i < arr.length; i++) {
			maxHeap.add(arr[i]);

			if (maxHeap.size() > k) {
				maxHeap.poll();
			}

		}

		return maxHeap.peek();
	}

}
