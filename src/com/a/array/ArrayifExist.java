package com.a.array;

public class ArrayifExist {
	public static boolean checkIfExist(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				for (int j = 0; j < arr.length; j++) {//14
					if (arr[i] == 2 * arr[j] && i != j) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int arr1[] = { -2, 0, 10, -19, 4, 6, -8 };
		int arr2[] = { 7, 1, 14, 11 };
//		System.out.println(1%2);
//		System.out.println("Array 1 :" + checkIfExist(arr1));
		System.out.println("Array 2 :" + checkIfExist(arr2));
	}
}