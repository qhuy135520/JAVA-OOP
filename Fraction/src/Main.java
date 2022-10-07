
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		ArrayList<Fraction> list = new ArrayList<>();// Add list of Fraction
		ArrayList<Integer> tu = new ArrayList<>();// Add list of Numerator
		ArrayList<Integer> mau = new ArrayList<>(); // Add list of denominator
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of element: ");
		int n = sc.nextInt();
		Random rd = new Random();
		// Create Fraction
		for (int i = 0; i < n; i++) {
			// create numerator & denominator
			int numerator = rd.nextInt(10) + 1;
			tu.add(numerator);
			int denominator = rd.nextInt(10) + 1;
			mau.add(denominator);
			Fraction f = new Fraction(numerator, denominator);
			f.reduce();
			list.add(f);
		}
		// Sort Fraction

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				float p1 = (float) tu.get(i) / mau.get(i);
				float p2 = (float) tu.get(j) / mau.get(j);
				int x, y;
				if (p1 > p2) {	
					// Swap Fraction...
					Fraction t = list.get(i);
					list.set(i, list.get(j));
					list.set(j, t);
					// swap numerator
					x = tu.get(i);
					tu.set(i, tu.get(j));
					tu.set(j, x);
					// swap denominator
					y = mau.get(i);
					mau.set(i, mau.get(j));
					mau.set(j, y);
				}
			}
		}
		// Print Fraction
		
		System.out.println("Sorted fraction List: ");
		System.out.print("[");
		for (int i = 0; i < n; i++) {
			list.get(i).outputFraction(n);
			if (i < n - 1) {
				System.out.print(", ");
			}
		}System.out.print("]");
		
	}

}