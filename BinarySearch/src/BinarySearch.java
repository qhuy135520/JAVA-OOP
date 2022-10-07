import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
	private static int[] intArray = null;

	public static void search() {
		System.out.print("Enter number you wanna search: ");
		int value = Validate.inputInt();

		System.out.println("Iterative Binary Search: ");
		int iterative = iterativeBinarySearch(intArray, value);
		if (iterative != -1) {
			System.out.println("Number you wanna search is at " + iterative + " of Array");
		} else {
			System.out.println("Not Found!!!");
		}
		System.out.println("============================");
		System.out.println("Recursive Binary Search:");
		int recursive = recursiveBinarySearch(intArray, 0, intArray.length, value);
		if (recursive != -1) {
			System.out.println("Number you wanna search is at " + recursive + " of Array");
		} else {
			System.out.println("Not Found!!!");
		}

	}

	public static void inputArray() {
		Random rd = new Random();
		System.out.println("Enter number of elements: ");
		int n = Validate.inputInt();

		intArray = new int[n];

		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = rd.nextInt(9);
		}
	}

	public static void display() {
		Arrays.sort(intArray);
		for (int i = 0; i < intArray.length; i++) {
			System.out.println("Arr[" + i + "] = " + intArray[i]);
		}
	}

	public static int iterativeBinarySearch(int[] intArray, int value) {
		int start = 0;
		int end = intArray.length;

		while (start < end) {
			int midpoint = (start + end) / 2;
			if (intArray[midpoint] == value) {
				return midpoint;
			} else if (intArray[midpoint] < value) {
				start = midpoint + 1;
			} else {
				end = midpoint;
			}
		}
		return -1;
	}


	public static int recursiveBinarySearch(int[] intArray, int start, int end, int value) {
		if (start >= end) {
			return -1;
		}

		int midpoint = (start + end) / 2;

		if (intArray[midpoint] == value) {
			return midpoint;
		} else if (intArray[midpoint] < value) {
			return recursiveBinarySearch(intArray, midpoint + 1, end, value);
		} else {
			return recursiveBinarySearch(intArray, start, midpoint, value);
		}
	}
}
