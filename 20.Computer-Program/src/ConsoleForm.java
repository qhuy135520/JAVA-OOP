import java.util.Arrays;
import java.util.List;

public class ConsoleForm {
	Calculation cal = new Calculation();
	List<String> choices = Arrays.asList("||=====Calculator Program =====||", "||1. Normal Calculator         ||",
			"||2. BMI Calculator            ||", "||3. Exit                      ||",
			"||=============================||", "Please choice one option:: ");

	public int getChoice() {
		choices.forEach(c -> System.out.println(c));
		return ExceptionData.inputLimit();
	}

	public void normalCalculator() {
		boolean flag = true;
		float b = 0;
		System.out.print("Enter number: ");
		double result = ExceptionData.inputFloat();
		while (flag) {
			System.out.println("Enter Operator: ");
			String operator = ExceptionData.inputOperator();
			if (!operator.equals("=") && !operator.equals("/")) {
				System.out.print("Enter number: ");
				b = ExceptionData.inputFloat();
			}
			switch (operator) {
			case "+":
				result = cal.add(result, b);
				break;
			case "-":
				result = cal.subtract(result, b);
				break;
			case "*":
				result = cal.multiply(result, b);
				break;
			case "/":
				System.out.print("Enter number: ");
				b = ExceptionData.inputdenominator();
				result = cal.divide(result, b);
				break;
			case "^":
				result = (float) cal.calculateExponents(result, b);
				break;
			case "=":
				System.out.print("Result: " + result + "\n");
				flag = false;
				return;
			}
			System.out.println("Memory: " + result);
		}
	}

	public static String status(double res) {
		String status = "";
		if (res < 19 && res > 0) {
			status = "Under-standard";
		} else if (res >= 19 && res < 25) {
			status = "Standard";
		} else if (res >= 25 && res < 30) {
			status = "Overweight";
		} else if (res >= 30 && res <= 40) {
			status = "Fat - should lose weight";
		} else if (res > 40) {
			status = "Very fat - should lose weight immediately";
		}
		return status;
	}

	public void bmiCalculator() {
		float weight, height;
		System.out.println("Enter Weight(kg)");
		weight = ExceptionData.inputFloat();
		System.out.println("Enter Height(cm)");
		height = ExceptionData.inputFloat();
		double res = cal.calculatorBMI(weight, height);
		String status = status(res);
		System.out.printf("BMI Number: %.2f\n", res);
		System.out.println("BMI Status: " + status);

	}

	public void execute() {
		while (true) {
			int choice = getChoice();
			switch (choice) {
			case 1:
				normalCalculator();
				break;
			case 2:
				bmiCalculator();
				break;
			case 3:
				System.exit(0);
				break;
			}
		}
	}
}
