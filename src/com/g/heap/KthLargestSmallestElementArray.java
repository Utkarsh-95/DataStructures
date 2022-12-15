package com.g.heap;

import java.util.PriorityQueue;

public class KthLargestSmallestElementArray {

	public static void main(String[] args) {
		int arr[] = { 7, 10, 4, 3, 20, 15 };
		int k = 3;
		kthLargestElemennt(arr, k);
		kthSmallestElemennt(arr, k);
	}

	private static void kthLargestElemennt(int[] arr, int k) {

		/*
		 * Kth largest element -> create min Heap, check the size of heap is not greater
		 * than k
		 */

//		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((c1, c2) -> {
			return c1 - c2;
		});

		for (int i = 0; i < arr.length; i++) {
			minHeap.add(arr[i]);

			if (minHeap.size() > k) {
				minHeap.poll();
			}

		}

		System.out.println("Kth Largest Element : " + minHeap.peek());

		while (minHeap.size() > 0) {
			System.out.print(minHeap.peek() + " ");
			minHeap.poll();
		}

	}

	private static void kthSmallestElemennt(int[] arr, int k) {

		/*
		 * Kth smallest element -> create max Heap, check the size of heap is not
		 * greater than k
		 */

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((c1, c2) -> {
			return c2 - c1;
		});

		for (int i = 0; i < arr.length; i++) {
			maxHeap.add(arr[i]);

			if (maxHeap.size() > k) {
				maxHeap.poll();
			}

		}

		System.out.println("\nKth Smallest Element : " + maxHeap.peek());

		while (maxHeap.size() > 0) {
			System.out.print(maxHeap.peek() + " ");
			maxHeap.poll();
		}

	}

}
