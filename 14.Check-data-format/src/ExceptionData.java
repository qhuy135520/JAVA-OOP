import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ExceptionData {
	public static String inputString() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String result = scanner.nextLine();
			if (result.isEmpty()) {
				System.err.print("Enter again: ");
			} else {
				return result.trim();
			}
		}
	}

	public static String inputEmail() {
		Scanner scanner = new Scanner(System.in);
		Pattern p = Pattern.compile("^[a-zA-Z0-9\\-_]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]{2,})+$");
		while (true) {
			String email = scanner.nextLine();
			if (p.matcher(email).find()) {
				return email;
			} else {
				System.err.println("Email must is correct format");
				System.out.print("Email: ");
			}
		}
	}

	public static String inputPhoneNumber() {
		Scanner scanner = new Scanner(System.in);
		Pattern p = Pattern.compile("^[0-9]{10}$");
		while (true) {
			try {
				int phone = Integer.parseInt(scanner.nextLine());
				String result = String.valueOf(phone);
				if (p.matcher(result).find()) {
					return result;
				} else {
					System.err.println("Phone number must be 10 digits ");
					System.out.print("Phone number: ");
				}
			} catch (NumberFormatException e) {
				System.err.println("Phone number must be number");
				System.out.print("Phone number: ");
			}
		}
	}

	public static String inputDate() {
		while (true) {
			try {
				String result = inputString();
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date date = format.parse(result);
				if (result.equalsIgnoreCase(format.format(date))) {
					return result;
				} else {
					System.err.println("Date to correct format(dd/MM/yyyy)");
					System.out.print("Date: ");
				}
			} catch (ParseException ex) {
				System.err.println("Date to correct format(dd/MM/yyyy)");
				System.out.print("Date: ");
			} catch (NumberFormatException e) {
				System.err.println("Date to correct format(dd/MM/yyyy)");
				System.out.print("Date: ");
			}
		}
	}
}
