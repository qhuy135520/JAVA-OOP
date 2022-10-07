
public class Menu {
	public static int menu() {
		System.out.println("1. Convert From Binary.");
		System.out.println("2. Convert From Decimal.");
		System.out.println("3. Convert From Hexa.");
		System.out.println("4. Exit");
		System.out.print("Enter your choice: ");
		int choice = Validate.checkInputIntLimit(1, 4);
		return choice;
	}

	public static int displayConvert(String from, String toCase1, String toCase2) {
		System.out.println("1. Convert " + from + " to " + toCase1);
		System.out.println("2. Convert " + from + " to " + toCase2);
		System.out.print("Enter your choice: ");
		int result = Validate.checkInputIntLimit(1, 2);
		return result;
	}

	public static void convertFromBinary(String binary) {
		int choice = displayConvert("binary", "decimal", "hexadecimal");
		switch (choice) {
		case 1:
			System.out.println("Decimal: " + Convert.convertBinaryToDecimal(binary));
			break;
		case 2:
			System.out.println("Hexadecimal: " + Convert.convertBinaryToDecimal(binary));
			break;
		}
	}

	public static void convertFromDecimal(String decimal) {
		int choice = Menu.displayConvert("decimal", "binary", "hexadecimal");
		switch (choice) {
		case 1:
			System.out.println("Binary: " + Convert.convertDecimalToBinary(decimal));
			break;
		case 2:
			System.out.println("Hexadecimal: " + Convert.convertDecimalToHexa(decimal));
			break;
		}
	}

	public static void convertFromHexa(String hexa) {
		int choice = Menu.displayConvert("hexa", "binary", "decimal");
		switch (choice) {
		case 1:
			System.out.println("Binary: " + Convert.convertHexaToBinary(hexa));
			break;
		case 2:
			System.out.println("Decimal: " + Convert.convertHexaToDecimal(hexa));
			break;
		}
	}

}
