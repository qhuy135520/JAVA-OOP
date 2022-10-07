import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		QuickSort.inputArray();
		System.out.println("Array before sorted: ");
		QuickSort.display();
		QuickSort.quickSort(QuickSort.intArray, 0, QuickSort.intArray.length);
		System.out.println("Array after sorted:");
		QuickSort.display();
	}
}
