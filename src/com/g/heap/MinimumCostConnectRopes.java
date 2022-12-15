package com.g.heap;

import java.util.PriorityQueue;

public class MinimumCostConnectRopes {

	// https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
//	Time Complexity: O(nLogn), assuming that we use a O(nLogn) sorting algorithm. 
//	Note that heap operations like insert and extract take O(Logn) time.
//	Auxiliary Complexity: O(n). 
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int n = arr.length;

		System.out.println(minimumCost(arr, n));

	}

	private static int minimumCost(int[] arr, int n) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			minHeap.add(arr[i]);
		}

		int totalCost = 0;

		while (minHeap.size() >= 2) {
			int first = minHeap.poll();
			int sec = minHeap.poll();

			totalCost += first + sec;

			minHeap.add(first + sec);
		}
		return totalCost;

	}

}
