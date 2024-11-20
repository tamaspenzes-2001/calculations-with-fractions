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
	
	public void changeDenominator(int newDenominator) {
		int multiplyer = newDenominator / denominator;
		numerator *= multiplyer;
		denominator = newDenominator;
	}
	
	public String toString() {
		return numerator + "/" + denominator;
	}

}
