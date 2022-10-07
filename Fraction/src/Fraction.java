public class Fraction {
	private int numerator;
	private int denominator;

	public Fraction() {
	}

	// Create Fraction
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	// Print method
	public void outputFraction(int n) {
		System.out.print(numerator + "/" + (denominator));
	}

	// Find GCD(greatest common divisor) by Euclidean Algorithm...
	public int GCD(int numerator, int denominator) {
		int r = numerator % denominator;
		while (r != 0) {
			numerator = denominator;
			denominator = r;
			r = numerator % denominator;
		}
		return denominator;
	}

	public void reduce() {
		int x = GCD(numerator, denominator);
		numerator /= x;
		denominator /= x;
	}
}