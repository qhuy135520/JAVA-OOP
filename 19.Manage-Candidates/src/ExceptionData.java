import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;

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
			Scanner scanner = new Scanner(System.in);
			try {
				float result = Float.parseFloat(scanner.nextLine());
				return result;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number");
				System.out.print("Please try again: ");
			}
		}
	}

	public static boolean checkId(ArrayList<Candidate> temp, String iD) {
		boolean isExist = true;
		if (!temp.isEmpty()) {
			for (Candidate s : temp) {
				if (s.getCandidateId().equals(iD)) {
					isExist = false;
				}
			}
		}
		return isExist;
	}

	public static String inputId(ArrayList<Candidate> temp) {
		while (true) {
			String iD = inputString();
			boolean check = checkId(temp, iD);
			if (!check) {
				System.out.println("ID is already exist!!");
				System.out.print("Enter ID: ");
			} else {
				return iD;
			}
		}
	}

	public static int inputBirthDate() {
		LocalDate date = LocalDate.now();
		int yearNow = date.getYear();
		while (true) {
			try {
				int dateBirth = Integer.parseInt(inputString());
				if (dateBirth <= yearNow && dateBirth >= 1900) {
					return dateBirth;
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number!!");
				System.out.print("Enter Birthdate:");
			}
		}
	}

	public static int yearExp(int birthDate) {
		LocalDate date = LocalDate.now();
		int yearNow = date.getYear();
		while (true) {
			try {
				int yearExp = Integer.parseInt(inputString());
				if (yearExp - (yearNow - birthDate) >= 0) {
					System.out.println("Invalid Year of Experience!!");
					System.out.println("You were born in " + birthDate + "!!");
					System.out.print("Enter Year of Experience!!");
				} else {
					return yearExp;
				}
			} catch (NumberFormatException e) {
				System.out.println("Year of Experience is number from 0 to 100!!");
				System.out.print("Enter Year of Experience!!");
			}
		}
	}

	public static int inputGraduateTime(int birthDate) {
		while (true) {
			try {
				int time = Integer.parseInt(inputString());
				if (time <= birthDate) {
					System.out.println("Invalid Graduate Time!!");
					System.out.println("You were born in " + birthDate + "!!");
					System.out.print("Enter Graduated time!!");
				} else {
					return time;
				}
			} catch (NumberFormatException e) {
				System.out.println("Year of Experience is number from 0 to 100!!");
				System.out.print("Enter Year of Experience!!");
			}
		}
	}

	public static String inputPhone() {
		Pattern p = Pattern.compile("^[0-9]{10,15}$");
		while (true) {
			try {
				String phone = inputString().trim();
				if (p.matcher(phone).find()) {
					return phone;
				} else {
					System.out.println("Wrong phone number!!");
					System.out.print("Enter phone number: ");
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter number!!");
				System.out.print("Enter phone number: ");
			}
		}
	}

	public static String inputEmail() {
		Pattern p = Pattern.compile("^[a-zA-z0-9\\-_]+@[a-zA-Z]+(\\.[a-zA-Z]+)+$");
		while (true) {
			String email = inputString();
			if (p.matcher(email).find()) {
				return email;
			} else {
				System.out.println("Wrong email !! ");
				System.out.print("Enter email: ");
			}
		}
	}

	public static String inputRank() {
		while (true) {
			String rank = inputString();
			if (rank.equalsIgnoreCase("Excellence") || rank.equalsIgnoreCase("Good") || rank.equalsIgnoreCase("Fair")
					|| rank.equalsIgnoreCase("Poor")) {
				return rank;
			} else {
				System.out.println("Rank of Graduation has 4 values(Excellence, Good, Fair, Poor)");
				System.out.print("Enter Rank of Graduation: ");
			}
		}
	}

	public static String inputSemester() {
		while (true) {
			String result = inputString();
			if (result.equalsIgnoreCase("spring") || result.equalsIgnoreCase("summer")
					|| result.equalsIgnoreCase("fall")) {
				return result;
			}
			System.out.println("Please input: Spring OR Summer OR Fall");
			System.out.print("Enter Semester: ");
		}
	}

	public static int inputLimit() {
		while (true) {
			int result = inputInt();
			if (result > 0 && result < 6) {
				return result;
			} else {
				System.out.println("Please enter choice (" + 1 + " to " + 5 + ")!!");
				System.out.println("Enter choice: ");
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
