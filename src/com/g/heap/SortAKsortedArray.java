package com.g.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortAKsortedArray {

	public static void main(String[] args) {
		int arr[] = { 6, 5, 3, 2, 8, 10, 9 };
		int k = 3;
		kSort(arr, k);
		System.out.println(Arrays.toString(arr));
	}

	private static void kSort(int[] arr, int k) {
		int index = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((c1, c2) -> {
			return c1 - c2;
		});

		for (int i = 0; i < arr.length; i++) {
			minHeap.add(arr[i]);

			if (minHeap.size() > k) {
				arr[index++] = minHeap.poll();
			}
		}
		while (minHeap.size() > 0) {
			arr[index++] = minHeap.poll();
		}

	}

}
