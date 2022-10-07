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

	public static int inputLimit() {
		while (true) {
			int result = inputInt();
			if (result > 0 && result < 6) {
				return result;
			} else {
				System.err.print("Please enter choice (" + 1 + " to " + 5 + "):");
			}
		}
	}

	public static boolean checkCode(ArrayList<Doctor> temp, String code) {
		boolean isExist = true;
		if (!temp.isEmpty()) {
			for (Doctor doctor : temp) {
				if (doctor.getCode().equals(code)) {
					isExist = false;
				}
			}
		}
		return isExist;
	}

	public static String inputCode(ArrayList<Doctor> temp) {
		while (true) {
			String code = inputString();
			boolean check = checkCode(temp, code);
			if (!check) {
				System.out.print("Code is already exist, try again: ");
			} else {
				return code;
			}
		}
	}

	public static String changeCode(Doctor dr, ArrayList<Doctor> list) {
		while (true) {
			String codeUpdate = inputString();
			boolean check = checkCode(list, codeUpdate);
			if (!check && !dr.getCode().equals(codeUpdate)) {
				System.out.print("Code is already exist, try again: ");
			} else {
				return codeUpdate;
			}
		}
	}

	public static boolean updateCode(ArrayList<Doctor> temp, String code) {

		boolean check = checkCode(temp, code);
		if (!check) {
			for (Doctor doctor : temp) {
				if (doctor.getCode().equals(code)) {
					System.out.printf("%-10s%-15s%-20s%-15s\n", "Code", "Name", "Specialization", "Availability");
					System.out.printf("%-10s%-15s%-20s%-20d\n", doctor.getCode(), doctor.getName(),
							doctor.getSpecialization(), doctor.getAvailability());
					break;
				}
			}
			System.err.println("Exist!!, can change!!");
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkChange(Doctor doctor, String code, String name, String specialization,
			int availability) {
		if (doctor.getCode().equals(code) && doctor.getName().equals(name)
				&& doctor.getSpecialization().equals(specialization) && doctor.getAvailability() == availability) {
			return false;
		}
		return true;
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
