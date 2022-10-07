
public class Main {

//Main
	public static void main(String[] args) {
		BubbleSort.inputArray();
		System.out.println("Array before was sorted:");
		BubbleSort.display();
		BubbleSort.bubbleSort();
		System.out.println("Array after was sorted:");
		BubbleSort.display();
	}
}
