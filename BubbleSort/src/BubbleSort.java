import java.util.Random;

public class BubbleSort {
	private static int[] Arr = null;

	// Create random integer and add to Array
	public static void inputArray() {
		Random rd = new Random();
		System.out.print("Enter number of element: ");
		int n = Validate.inputInt();
		Arr = new int[n];
		for (int i = 0; i < Arr.length; i++) {
			Arr[i] = rd.nextInt(10);
		}
	}

	// Display
	public static void display() {
		for (int i = 0; i < Arr.length; i++) {
			System.out.println("Arr[" + i + "] = " + Arr[i]);
		}
	}

	// Sorting
	public static void bubbleSort() {
		for (int i = 0; i < Arr.length - 1; i++) {
			boolean isSwap = true;
			for (int j = 0; j < Arr.length - i - 1; j++) {
				if (Arr[j] > Arr[j + 1]) {
					Swap(j, j + 1);
					isSwap = false;
				}
			}
			if (isSwap == true) {
				break;
			}
		}
	}

	// Swap 2 elements
	public static void Swap(int i, int j) {
		if (i == j) {
			return;
		}
		int temp = Arr[i];
		Arr[i] = Arr[j];
		Arr[j] = temp;
	}

}
