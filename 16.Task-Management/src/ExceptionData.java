import java.sql.Date;
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

	public static int inputInt() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			try {
				int result = Integer.parseInt(scanner.nextLine());
				return result;
			} catch (NumberFormatException e) {
				System.err.print("Please enter a number: ");
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
				System.err.print("Please enter a number: ");
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
				System.err.print("Please enter a number: ");
			}
		}
	}

	public static int inputID() {
		while (true) {
			int result = inputInt();
			if (result >= 1 && result <= 4) {
				return result;
			} else {
				System.err.println("The TaskTypeID must exist (1-4)");
				System.out.print("ID: ");
			}
		}
	}

	public static String taskType(int id) {
		String taskType = null;
		switch (id) {
		case 1:
			taskType = "Code";
			break;
		case 2:
			taskType = "Test";
			break;
		case 3:
			taskType = "Design";
			break;
		case 4:
			taskType = "Review";
			break;
		}
		return taskType;
	}

	public static String inputName() {
		Pattern p = Pattern.compile("^[a-zA-Z\\s]+$");
		while (true) {
			String name = inputString();
			name.split(" +");
			if (p.matcher(name).find()) {
				return name;
			} else {
				System.err.println("Wrong name type, please try again!!");
				System.out.print("Enter again: ");
			}
		}
	}

	public static String inputDate() {
		while (true) {
			try {
				String result = inputString();
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				java.util.Date date = format.parse(result);
				if (result.equalsIgnoreCase(format.format(date))) {
					return result;
				} else {
					System.err.println("Date to correct format(dd-MM-yyyy)");
					System.out.print("Date: ");
				}
			} catch (ParseException ex) {
				System.err.println("Date to correct format(dd-MM-yyyy)");
				System.out.print("Date: ");
			} catch (NumberFormatException e) {
				System.err.println("Date to correct format(dd-MM-yyyy)");
				System.out.print("Date: ");
			}
		}
	}

	public static float inputPlanFrom() {
		while (true) {
			try {

				float result = inputPositiveFloat();
				if (result >= 8.0 && result < 17.5) {
					return result;
				} else {
					System.err.println("Plan From must be in range(8.0 - 17.5)");
					System.out.print("From: ");
				}
			} catch (NumberFormatException e) {
				System.out.print("From: ");
			}
		}
	}

	public static float inputPlanTo(float from) {
		while (true) {
			try {
				float result = inputPositiveFloat();
				if (result >= from && result <= 17.5) {
					return result;
				} else {
					System.err.println("Plan To must be greater than Plan From");
					System.out.print("To: ");
				}
			} catch (NumberFormatException e) {
				System.err.println("Wrong number!!");
				System.out.print("To: ");
			}
		}
	}

	public static int inputLimit() {
		while (true) {
			int result = inputInt();
			if (result >= 1 && result <= 4) {
				return result;
			} else {
				System.err.println("Please enter choice (" + 1 + " to " + 4 + ")!!");
				System.out.print("Enter choice: ");
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
				System.err.println("Please choose Y(yes) OR N(no)!! ");
				System.out.print("Enter choice: ");
			}
		}
	}
}
