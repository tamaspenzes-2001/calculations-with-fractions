package calculationsWithFractions;

public class Fraction {
	private long numerator;
	private long denominator;
	
	public Fraction(long numerator, long denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public Fraction(Fraction originalFraction) {
		this.numerator = originalFraction.getNumerator();
		this.denominator = originalFraction.getDenominator();
	}

	public long getNumerator() {
		return numerator;
	}

	public long getDenominator() {
		return denominator;
	}
	
	public Fraction getSimplifiedFraction() {
		if (numerator == 0 && denominator == 0) {
			return this;
		} else if (numerator == denominator) {
			return new Fraction(1, 1);
		} else {
			long biggerNumber = Math.max(numerator, denominator);
			long divisor = 0;
			for (long i = biggerNumber / 2; i > 1; i--) {
				if (numerator % i == 0 && denominator % i == 0) {
					divisor = i;
					break;
				}
			}
			if (divisor == 0) {
				return this;
			} else {
				return new Fraction(numerator / divisor, denominator / divisor);
			}
		}
	}
	
	public void increaseDenominator(long newDenominator) {
		long multiplyer = newDenominator / denominator;
		numerator *= multiplyer;
		denominator = newDenominator;
	}
	
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	public boolean equals(Fraction otherFraction) {
		return numerator == otherFraction.getNumerator() && denominator == otherFraction.getDenominator();
	}

}
