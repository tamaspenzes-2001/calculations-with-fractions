package calculationsWithFractions;

public class App {

	public static void main(String[] args) {
		Fraction fraction1 = new Fraction(1, 2);
		Fraction fraction2 = new Fraction(1, 2);
		Calculator calculator = new Calculator(fraction1, fraction2);
		Fraction[] fractionSnapshots = snapshotFractions(fraction1, fraction2); // create copies of Fractions to display original fractions later for user
		Fraction sum = calculator.add();
		Fraction difference = calculator.subtract();
		Fraction product = calculator.multiply();
		Fraction quotient = calculator.divide();
		Fraction[] resultSnapshots = snapshotFractions(sum, difference, product, quotient);
		sum.simplify();
		difference.simplify();
		product.simplify();
		quotient.simplify();
		System.out.println(fractionSnapshots[0] + " + " + fractionSnapshots[1] + " = "
				+ fraction1 + " + " + fraction2 + " = "
				+ resultSnapshots[0] + " = " + sum
				+ (sum.getDenominator() == 0 || sum.getNumerator() == 0 ? " = 0" :
					(sum.getDenominator() == 1 ? " = " + sum.getNumerator() : "")));
		System.out.println(fractionSnapshots[0] + " - " + fractionSnapshots[1] + " = "
				+ fraction1 + " - " + fraction2 + " = "
				+ resultSnapshots[1] + " = " + difference
				+ (difference.getDenominator() == 0 || difference.getNumerator() == 0 ? " = 0" :
					(difference.getDenominator() == 1 ? " = " + difference.getNumerator() : "")));
		System.out.println(fractionSnapshots[0] + " * " + fractionSnapshots[1] + " = "
				+ fraction1 + " * " + fraction2 + " = "
				+ resultSnapshots[2] + " = " + product
				+ (product.getDenominator() == 0 || product.getNumerator() == 0 ? " = 0" :
					(product.getDenominator() == 1 ? " = " + product.getNumerator() : "")));
		System.out.println(fractionSnapshots[0] + " / " + fractionSnapshots[1] + " = "
				+ fraction1 + " / " + fraction2 + " = "
				+ resultSnapshots[3] + " = " + quotient
				+ (quotient.getDenominator() == 0 || quotient.getNumerator() == 0 ? " = 0" :
					(quotient.getDenominator() == 1 ? " = " + quotient.getNumerator() : "")));
	}
	
	public static Fraction[] snapshotFractions(Fraction... fractions) {
		Fraction[] snapshots = new Fraction[fractions.length];
		for (int i = 0; i < snapshots.length; i++) {
			snapshots[i] = new Fraction(fractions[i]);
		}
		return snapshots;
	}

}
