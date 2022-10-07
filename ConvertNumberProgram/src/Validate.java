import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {

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

	public static int checkInputIntLimit(int min, int max) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				int result = Integer.parseInt(sc.nextLine().trim());
				if (result < min || result > max) {
					throw new NumberFormatException();

				}
				return result;
			} catch (NumberFormatException e) {
				System.err.println("Please input number in rage [" + min + ", " + max + "]");
				System.out.print("Enter again: ");
			}
		}
	}

	public static String inputBinaryNumber() {
		Scanner scanner = new Scanner(System.in);
		Pattern p = Pattern.compile("^[0-1]+$");
		while (true) {
			System.out.print("Enter binary number: ");
			String binaryNumber = inputString();
			if (p.matcher(binaryNumber).find()) {
				return binaryNumber;
			} else {
				System.out.print("wrong binary number, please enter again: ");
			}
		}
	}

	public static String inputDecimalNumber() {
		Scanner scanner = new Scanner(System.in);
		Pattern p = Pattern.compile("^[0-9]+$");
		while (true) {
			System.out.print("Enter decimal number: ");
			String decimalNumber = inputString();
			if (p.matcher(decimalNumber).find()) {
				return decimalNumber;
			} else {
				System.out.print("wrong decimal number, please enter again: ");
			}
		}
	}

	public static String inputHexaNumber() {
		Scanner scanner = new Scanner(System.in);
		Pattern p = Pattern.compile("^[0-9A-F]+$");
		while (true) {
			System.out.print("Enter hexa number: ");
			String hexaNumber = inputString();
			if (p.matcher(hexaNumber).find()) {
				return hexaNumber;
			} else {
				System.out.print("wrong hexa number, please enter again: ");
			}
		}
	}
}
