import java.io.File;
import java.util.Scanner;

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

	public static boolean checkInputPath(String path) {
		boolean isPath;

		File file = new File(path);
		if (file.exists() && file.isFile()) {
			isPath = true;
		} else {
			isPath = false;
		}
		return isPath;
	}

	public static String yesOrNo() {
		System.err.print("Do you want to continue (Y/N): ");
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
