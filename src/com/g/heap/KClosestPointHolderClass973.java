package com.g.heap;

import java.util.PriorityQueue;

public class KClosestPointHolderClass973 {

	static class Holder {
		int x;
		int y;
		int distance;

		public Holder(int x, int y, int distance) {
			super();
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 2 }, { 1, 3 }, { -2, 4 } };
//		int arr[][] = { { 1, 3 }, { -2, 2 }, { 4, 3 } };
		int k = 1;
		int temp[][] = kClosest(arr, k);
		System.out.println(temp[0][0] + "," + temp[0][1]);

	}

	public static int[][] kClosest(int[][] points, int k) {
		
		if(points == null || points.length == 0) {
			return null;
		}

		PriorityQueue<Holder> maxHeap = new PriorityQueue<>((c1, c2) -> {
			return c2.distance - c1.distance;
		});

		for (int i = 0; i < points.length; i++) {

			int x = points[i][0];
			int y = points[i][1];
			int distance = x * x + y * y;

			maxHeap.add(new Holder(x, y, distance));

			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}

		int index = 0;
		int[][] output = new int[maxHeap.size()][2];
		while (maxHeap.size() > 0) {
			Holder h = maxHeap.peek();

			// making 2d array result
//			temp[index++] = new int[] { p.getKey(), p.getValue() };

			output[index][0] = h.x;
			output[index][1] = h.x;

			maxHeap.poll();
		}

		return output;
	}

}
