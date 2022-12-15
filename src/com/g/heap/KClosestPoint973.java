package com.g.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

import a.com.CustomClass.Pair;

public class KClosestPoint973 {

	public static void main(String[] args) {
		int arr[][] = { { 1, 3 }, { -2, 2 }, { 4, 3 } };
		int k = 1;
		int temp[][] = kClosest(arr, k);
		System.out.println(temp[0][0] + "," + temp[0][1]);

	}

	public static int[][] kClosest(int[][] points, int k) {

		PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> maxHeap = new PriorityQueue<>((c1, c2) -> {
			return c2.getKey() - c1.getKey();
		});

		/*
		 * calculating distance and taking points from 2d array new Pair(points[i][0] *
		 * points[i][0] + points[i][1] * points[i][1]), new Pair(points[i][0],
		 * points[i][1])
		 */

		int[][] temp = new int[k][2];

		for (int i = 0; i < points.length; i++) {
			maxHeap.add(
					new Pair<Integer, Pair<Integer, Integer>>(points[i][0] * points[i][0] + points[i][1] * points[i][1],
							new Pair<Integer, Integer>(points[i][0], points[i][1])));

			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}

		int index = 0;
		while (maxHeap.size() > 0) {
			Pair<Integer, Integer> p = maxHeap.peek().getValue();

			// making 2d array result
			temp[index++] = new int[] { p.getKey(), p.getValue() };
			maxHeap.poll();
		}

		return temp;
	}

}
