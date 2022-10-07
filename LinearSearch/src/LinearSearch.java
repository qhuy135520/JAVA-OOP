import java.util.Random;

public class LinearSearch {
	private static int[] intArray = null;

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

	public static void checkSearch() {
		System.out.println("Enter number you wanna search: ");
		int value = Validate.inputInt();
		int check = linearSearch(intArray, value);
		if (check == -1) {
			System.out.println("Not Found!!");
		} else {
			System.out.print("Number you wanna search is at: " + check);
			for (int i = (check + 1); i < intArray.length; i++) {
				if (intArray[i] == value) {
					System.out.print(", ");
					System.out.print(i);
				}
			}
		}
	}

	public static int linearSearch(int[] input, int value) {
		for (int i = 0; i < input.length; i++) {
			if (input[i] == value) {
				return i;
			}
		}
		return -1;
	}
}
