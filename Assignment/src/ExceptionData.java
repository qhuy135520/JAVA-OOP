import java.util.Scanner;
import java.util.regex.Pattern;

public class ExceptionData {

	public static String inputString() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String result = scanner.nextLine();
			if (result.isEmpty()) {
				System.out.print("Enter again: ");
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
				System.out.println("Please enter a number");
				System.out.print("Enter again: ");
			}
		}
	}

	public static double inputDouble() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			try {
				double result = Double.parseDouble(scanner.nextLine());
				return result;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number");
				System.out.print("Enter again: ");
			}
		}
	}

	public static String inputEmail() {
		Scanner scanner = new Scanner(System.in);
		Pattern p = Pattern.compile("^[a-zA-z0-9\\-_]+@[a-zA-Z]+(\\.[a-zA-Z]+)+$");
		while (true) {
			String email = scanner.nextLine();
			if (p.matcher(email).find()) {
				return email;
			} else {
				System.out.print("Wrong email, please enter again: ");
			}
		}
	}

	public static String inputPhoneNumber() {
		Scanner scanner = new Scanner(System.in);
		Pattern p = Pattern.compile("^[0-9]{10}$");
		while (true) {
			String phone = scanner.nextLine();
			if (p.matcher(phone).find()) {
				return phone;
			} else {
				System.out.print("wrong phone number, please enter again: ");
			}
		}
	}

	public static String inputName() {
		Scanner scanner = new Scanner(System.in);
		Pattern p = Pattern.compile("^[a-zA-Z\\s]+$");
		while (true) {
			String name = scanner.nextLine();
			name.split(" +");
			if (p.matcher(name).find()) {
				return name;
			} else {
				System.out.print("Wrong name type, please enter again: ");
			}
		}
	}

	public static int inputChoice() {
		while (true) {
			int result = inputInt();
			if (result == 1 || result == 2) {
				return result;
			} else {
				System.out.print("Please enter choice (" + 1 + " OR " + 2 + "):");
			}
		}
	}

	public static String yesOrNo() {
		while (true) {
			String choose = inputString();
			choose = choose.trim();
			if (choose.equalsIgnoreCase("Y") || choose.equalsIgnoreCase("N")) {
				return choose;
			} else {
				System.out.print("Please choose Y(yes) OR N(no): ");
			}
		}
	}
}