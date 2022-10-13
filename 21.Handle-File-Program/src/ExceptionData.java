import java.util.Scanner;

public class ExceptionData {
	public static String inputString() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String result = scanner.nextLine();
			if (result.isEmpty()) {
				System.out.print("Please try again: ");
			} else {
				return result.trim();
			}
		}
	}

	public static int inputInt() {
		while (true) {
			try {
				int result = Integer.parseInt(inputString());
				return result;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number");
				System.out.print("Please try again: ");
			}
		}
	}

	public static int inputLimit() {
		while (true) {
			int result = inputInt();
			if (result > 0 && result < 7) {
				return result;
			} else {
				System.out.println("Please enter choice (" + 1 + " to " + 6 + ")!!");
				System.out.println("Enter choice: ");
			}
		}
	}
}
