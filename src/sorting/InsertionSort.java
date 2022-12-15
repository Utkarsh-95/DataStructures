package sorting;

public class InsertionSort {

	static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int temp = a[i], j = i;// temp = 10, 50, 20, i=j=1, 2, 3
			// { 10, 20, 30, 50 };
			while (j > 0 && a[j - 1] > temp) {// 50 > 20// true
				// swap here
				a[j] = a[j - 1];// a[1] = 30, a[3] = 50
				j--;// j=0, 2
			}
			a[j] = temp;// a[0] = 10, a[2] = 20
		}

	}// end of method

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
	}// end of method

	public static void main(String[] args) {
//		int array[] = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};

		int array[] = { 30, 10, 50, 20 };

		System.out.println("User entered Array: ");
		InsertionSort.printArray(array);

		InsertionSort.insertionSort(array);

		System.out.println("\n\nAfter sorting: ");
		InsertionSort.printArray(array);
	}

}// end of class
