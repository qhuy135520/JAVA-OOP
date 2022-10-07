import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ExceptionData {
	public static String inputString() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String result = scanner.nextLine();
			if (result.isEmpty()) {
				System.err.print("Please try again: ");
			} else {
				return result.trim();
			}
		}
	}

	public static int inputInt() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			try {
				int result = Integer.parseInt(scanner.nextLine());
				return result;
			} catch (NumberFormatException e) {
				System.err.println("Please enter a number");
				System.err.print("Please try again: ");
			}
		}
	}

	public static String inputName() {
		Pattern p = Pattern.compile("^[a-zA-Z\\s]+$");
		while (true) {
			String name = inputString();
			name.split(" +");
			if (p.matcher(name).find()) {
				return name;
			} else {
				System.err.print("Wrong name type, please try again: ");
			}
		}
	}

	public static float inputPositiveFloat() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			try {
				float result = Float.parseFloat(scanner.nextLine());
				if (result > 0) {
					return result;
				}
			} catch (NumberFormatException e) {
				System.err.println("Please enter a number");
				System.err.print("Please try again: ");
			}
		}
	}

	public static int inputPositiveInt() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			try {
				int result = Integer.parseInt(scanner.nextLine());
				if (result > 0) {
					return result;
				}
			} catch (NumberFormatException e) {
				System.err.println("Please enter a number");
				System.err.print("Please try again: ");
			}
		}
	}

	public static int inputLimit() {
		while (true) {
			int result = inputInt();
			if (result >= 1 && result <= 4) {
				return result;
			} else {
				System.err.print("Please enter choice (" + 1 + " to " + 4 + "):");
			}
		}
	}

	public static String yesOrNo() {
		System.out.print("Do you want to redefine (Y/N): ");
		while (true) {
			String choose = inputString();
			choose = choose.trim();
			if (choose.equalsIgnoreCase("Y") || choose.equalsIgnoreCase("N")) {
				return choose;
			} else {
				System.err.print("Please choose Y(yes) OR N(no): ");
			}
		}
	}
}
