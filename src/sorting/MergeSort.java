package sorting;

public class MergeSort {

	public static void mergeSort(int[] Array, int start, int end) {
		if (start < end) {
			// find the middle of the array
			int middle = (start + end) / 2;

			// sort left half
			mergeSort(Array, start, middle);

			// sort right half
			mergeSort(Array, middle + 1, end);

			// merge the two halves together
			merge(Array, start, middle, end);
		}
	}// end of method

	// using two temp arrays
	static void merges(int[] A, int left, int middle, int right) {
		int[] leftTmpArray = new int[middle - left + 2]; // Create tmp arrays
		int[] rightTmpArray = new int[right - middle + 1];

		for (int i = 0; i <= middle - left; i++) // Copy values from Array 'A' to these tmp arrays
			leftTmpArray[i] = A[left + i];
		for (int i = 0; i < right - middle; i++)
			rightTmpArray[i] = A[middle + 1 + i];

		leftTmpArray[middle - left + 1] = Integer.MAX_VALUE; // Merge values and insert into Array 'A'
		rightTmpArray[right - middle] = Integer.MAX_VALUE;
		int i = 0, j = 0;
		for (int k = left; k <= right; k++) {
			if (leftTmpArray[i] < rightTmpArray[j]) {
				A[k] = leftTmpArray[i];
				i++;
			} else {
				A[k] = rightTmpArray[j];
				j++;
			}
		}
	}// end of method

	// using one temp arrays
	static void merge(int[] array, int start, int mid, int end) {

		int i = start;
		int j = mid + 1;
		int k = start;
		int size = array.length;

		int temp[] = new int[size];

		// while both halves have data
		while ((i <= mid) && (j <= end)) {
			// if the left half value is less than right
			if (array[i] < array[j]) {
				// take from left
				temp[k] = array[i];
				k++;
				i++;
			} else {
				// take from right
				temp[k] = array[j];
				k++;
				j++;
			}
		}
		// add the remaining elements from the left half
		while (i <= mid) {
			temp[k] = array[i];
			k++;
			i++;
		}
		// add the remaining elements from the right half
		while (j <= mid) {
			temp[k] = array[j];
			k++;
			j++;
		}

		// move from temp array to the original array
		for (k = start; k <= end; k++) {
			array[k] = temp[k];
		}

	}

	public static void main(String[] args) {

		int array[] = { 100, 9, 4, 5, 3 };

		System.out.println("User entered Array: Length : " + array.length);
		MergeSort.printArray(array);

		long start = System.nanoTime();
		MergeSort.mergeSort(array, 0, array.length - 1);
		long end = System.nanoTime();
		System.out.println("\n\nTime to execute this algo: " + (end - start));

		System.out.println("\nAfter sorting: ");
		MergeSort.printArray(array);
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
	}// end of method

}// end of class
