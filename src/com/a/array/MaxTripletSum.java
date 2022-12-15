/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a.array;

import java.util.Arrays;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class MaxTripletSum {

	// Time complexity : O(n^3)
	// Space complexity : O(1)
	static int maxTripletSum(int arr[], int n) {
		int sum = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (sum < arr[i] + arr[j] + arr[k]) {
						sum = arr[i] + arr[j] + arr[k];
					}
				}
			}
		}
		return sum;
	}

//    Time complexity : O(nlogn)
//    Space complexity : O(1)
	static int maxTripletSumWithSort(int arr[], int n) {
		Arrays.sort(arr);

		// After sorting the array.
		// Add last three element of the given array
		return arr[n - 1] + arr[n - 2] + arr[n - 3];
	}

//    Time complexity : O(n)
//    Space complexity : O(1)
	// This function assumes that there are at least three elements in arr[].
	static int maxTripletSumEfficient(int arr[], int n) {
		// Initialize Maximum, second maximum and third maximum element
		int maxA = Integer.MIN_VALUE;
		int maxB = Integer.MIN_VALUE;
		int maxC = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {

			// Update Maximum, second maximum and third maximum element
			if (arr[i] > maxA) {
				maxC = maxB;
				maxB = maxA;
				maxA = arr[i];
			} // Update second maximum and third maximum
				// element
			else if (arr[i] > maxB) {
				maxC = maxB;
				maxB = arr[i];
			} // Update third maximum element
			else if (arr[i] > maxC) {
				maxC = arr[i];
			}
		}

		return (maxA + maxB + maxC);
	}

	public static void main(String args[]) {
		int arr[] = { 1, 0, 8, 6, 4, 2 };
		int n = arr.length;
		System.out.println(maxTripletSum(arr, n));
		System.out.println(maxTripletSumWithSort(arr, n));
		System.out.println(maxTripletSumEfficient(arr, n));
	}
}
