
public class Calculation {
	public double add(double result, float number) {
		return result + number;
	}

	public double subtract(double result, float number) {
		return result - number;
	}

	public double multiply(double result, float number) {
		return result * number;
	}

	public double divide(double result, float number) {
		return result / number;
	}

	public double calculateExponents(double result, float number) {
		return Math.pow(result, number);
	}

	public double calculatorBMI(float weight, float height) {
		double res;
		res = weight / Math.pow(height / 100, 2);
		return res;
	}
}
