import java.util.Scanner;
import java.util.regex.Pattern;

public class ExceptionData {
	final public static String phoneRegex1 = "^[0-9]{3}[-][0-9]{3}[-][0-9]{4}$";
	final public static String phoneRegex2 = "^[0-9]{3}[.][0-9]{3}[.][0-9]{4}$";
	final public static String phoneRegex3 = "^[0-9]{3}[\\s][0-9]{3}[\\s][0-9]{4}$|^[0-9]{10}$";
	final public static String phoneRegex4 = "^[0-9]{3}[-][0-9]{3}[-][0-9]{4}[\\s][0-9]{4}$";
	final public static String phoneRegex5 = "^[0-9]{3}[-][0-9]{3}[-][0-9]{4}[\\s]x[0-9]{4}$";
	final public static String phoneRegex6 = "^[0-9]{3}[-][0-9]{3}[-][0-9]{4}[\\s]ext[0-9]{4}$";

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

	public static double inputDouble() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			try {
				double result = Double.parseDouble(scanner.nextLine());
				return result;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number");
				System.out.print("Please try again: ");
			}
		}
	}

	public static String inputPhoneNumber() {
		Pattern p1 = Pattern.compile(phoneRegex1);
		Pattern p2 = Pattern.compile(phoneRegex2);
		Pattern p3 = Pattern.compile(phoneRegex3);
		Pattern p4 = Pattern.compile(phoneRegex4);
		Pattern p5 = Pattern.compile(phoneRegex5);
		Pattern p6 = Pattern.compile(phoneRegex6);
		while (true) {
			String phone = inputString();
			if (p1.matcher(phone).find() || p2.matcher(phone).find() || p3.matcher(phone).find()
					|| p4.matcher(phone).find() || p5.matcher(phone).find() || p6.matcher(phone).find()) {
				return phone;
			} else {
				System.err.print("Please input Phone flow\r\n" + "• 1234567890\r\n" + "• 123-456-7890\r\n"
						+ "• 123-456-7890 x1234\r\n" + "• 123-456-7890 ext1234\r\n" + "• 123.456.7890\r\n"
						+ "• 123 456 7890\r\n " + "" + "Please try again: ");
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

	public static int inputId() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			try {
				System.out.print("Enter ID: ");
				int result = Integer.parseInt(scanner.nextLine());
				return result;
			} catch (NumberFormatException e) {
				System.err.println("ID is digit");
			}
		}
	}

	public static int inputLimit() {
		while (true) {
			int result = inputInt();
			if (result > 0 && result < 5) {
				return result;
			} else {
				System.err.print("Please enter choice (" + 1 + " To " + 4 + "):");
			}
		}
	}

	public static String yesOrNo() {
		System.out.print("Do you want to continue (Y/N): ");
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
