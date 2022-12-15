package divideAndConquer;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertString_DC {
	// Function to find the minimum number of operations required to transform a
	// given
	// string into another string
	public static int getMinimumOperations(String first, String second) {
		// to keep track of the minimum number of operations required
		int count = 0;

		// `i` and `j` keep track of the current characters' index in the
		// first and second strings, respectively

		// start from the end of the first and second string
		for (int i = first.length() - 1, j = i; i >= 0; i--, j--) {
			// if the current character of both strings doesn't match,
			// search for `second[j]` in substring `first[0, i-1]` and
			// increment the count for every move
			while (i >= 0 && first.charAt(i) != second.charAt(j)) {
				i--;
				count++;
			}
		}

		// return the minimum operations required
		return count;
	}

	// Function to determine if the first string can be transformed into
	// the second string
	public static boolean isTransformable(char[] first, char[] second) {
		// base case
		if (first == null || second == null) {
			return false;
		}

		// if the length of both strings differs
		if (first.length != second.length) {
			return false;
		}

		// return true if both strings have the same set of characters
		return getFrequencyMap(first).equals(getFrequencyMap(second));
	}

	// Utility function to create a frequency map
	public static Map<Character, Long> getFrequencyMap(char[] chars) {
		return new String(chars).chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

	public static void main(String[] args) {
		String first = "ADCB";
		String second = "ABCD";

		if (isTransformable(first.toCharArray(), second.toCharArray())) {
			System.out.println("The minimum operations required to convert the string " + first + " to string " + second
					+ " are " + getMinimumOperations(first, second));
		} else {
			System.out.println("The string cannot be transformed");
		}
	}
}