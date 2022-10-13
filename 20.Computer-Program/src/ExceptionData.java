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

	public static float inputFloat() {
		while (true) {
			try {
				float result = Float.parseFloat(inputString());
				return result;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number");
				System.out.print("Please try again: ");
			}
		}
	}

	public static float inputdenominator() {
		while (true) {
			try {
				float result = Float.parseFloat(inputString());
				if (result != 0) {
					return result;
				} else {
					System.out.println("Can't divide by 0!!");
					System.out.print("Enter number:");
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number");
				System.out.print("Please try again: ");
			}
		}
	}

	public static String inputOperator() {
		while (true) {
			String result = inputString();
			if (result.equals("+") || result.equals("-") || result.equals("*") || result.equals("/")
					|| result.equals("^") || result.equals("=")) {
				return result;
			} else {
				System.out.println("Please enter operator!!");
				System.out.print("Enter Operator: ");
			}
		}
	}

	public static int inputLimit() {
		while (true) {
			int result = inputInt();
			if (result > 0 && result < 4) {
				return result;
			} else {
				System.out.println("Please enter choice (" + 1 + " to " + 3 + ")!!");
				System.out.println("Enter choice: ");
			}
		}
	}
}
