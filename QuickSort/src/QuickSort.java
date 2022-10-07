import java.util.Random;

public class QuickSort {
	static int[] intArray = null;

	public static void inputArray() {
		Random rd = new Random();
		System.out.print("Enter number of elements: ");
		int n = Validate.inputInt();
		intArray = new int[n];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = rd.nextInt(10);
		}

	}

	public static void display() {
		for (int i = 0; i < intArray.length; i++) {
			System.out.println("Arr[" + i + "] = " + intArray[i]);
		}
	}

	public static void quickSort(int[] input, int start, int end) {
		if (end - start < 2) {
			return;
		}

		int pivotIndex = partition(input, start, end);
		quickSort(input, start, pivotIndex);
		quickSort(input, pivotIndex + 1, end);
	}

	public static int partition(int[] input, int start, int end) {
		int pivot = input[start];
		int i = start;
		int j = end;

		while (i < j) {
			while (i < j && input[--j] >= pivot)
				;
			if (i < j) {
				input[i] = input[j];
			}

			while (i < j && input[++i] <= pivot)
				;
			if (i < j) {
				input[j] = input[i];
			}

		}
		input[j] = pivot;
		return j;
	}
}
