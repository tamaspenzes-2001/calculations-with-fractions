package calculationsWithFractions;

public class Fraction {
	private int numerator;
	private int denominator;
	
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}
	
	public void simplify() {
		if (numerator == denominator) {
			numerator = 1;
			denominator = 1;
		} else {
			int biggerNumber = Math.max(numerator, denominator);
			int divisor = 0;
			for (int i = biggerNumber / 2; i > 1; i--) {
				if (numerator % i == 0 && denominator % i == 0) {
					divisor = i;
					break;
				}
			}
			if (divisor != 0) {
				numerator /= divisor;
				denominator /= divisor;
			}
		}
	}
	
	public void increaseDenominator(int newDenominator) {
		int multiplyer = newDenominator / denominator;
		numerator *= multiplyer;
		denominator = newDenominator;
	}
	
	public String toString() {
		return numerator + "/" + denominator;
	}

}
