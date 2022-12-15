package com.g.heap;

import java.util.PriorityQueue;

import a.com.CustomClass.Pair;


public class KClosestElement {

	public static void main(String[] args) {
		// int K = 4, X = 35;
		// int arr[] = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
		int K = 3, X = 7;
		int arr[] = { 5, 6, 7, 8, 9 };
		kClosestElement(arr, K, X);
	}

	private static void kClosestElement(int[] arr, int k, int x) {
		PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<Pair<Integer, Integer>>((c1, c2) -> {
			return c2.getKey() - c1.getKey();
		});
		
//		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((c1, c2) -> {
//			return Math.abs(x - c1) - Math.abs(x - c2);
//		});
		
		

		for (int i = 0; i < arr.length; i++) {
			maxHeap.add(new Pair<Integer, Integer>(Math.abs(arr[i] - x), arr[i]));
			
//			maxHeap.add(arr[i]);

			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		while (maxHeap.size() > 0) {
			System.out.print(maxHeap.peek().getValue() + " ");
			maxHeap.poll();
		}
	}

}
