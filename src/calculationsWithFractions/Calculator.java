package calculationsWithFractions;

public class Calculator {
	private Fraction fraction1;
	private Fraction fraction2;
	
	public Calculator(Fraction fraction1, Fraction fraction2) {
		this.fraction1 = fraction1;
		this.fraction2 = fraction2;
	}

	public Fraction getFraction1() {
		return fraction1;
	}

	public Fraction getFraction2() {
		return fraction2;
	}

	public Fraction add() {
		bringToLowestCommonDenominator();
		int numerator = fraction1.getNumerator() + fraction2.getNumerator();
		return new Fraction(numerator, fraction1.getDenominator());
	}
	
	public Fraction subtract() {
		bringToLowestCommonDenominator();
		int numerator = fraction1.getNumerator() - fraction2.getNumerator();
		return new Fraction(numerator, fraction1.getDenominator());
	}
	
	public Fraction multiply(Fraction... reciprocal) {
		Fraction multiplyer = fraction2;
		if (reciprocal.length == 1) {
			multiplyer = reciprocal[0];
		}
		int numerator = fraction1.getNumerator() * multiplyer.getNumerator();
		int denominator = fraction1.getDenominator() * multiplyer.getDenominator();
		return new Fraction(numerator, denominator);
	}
	
	public Fraction divide() {
		Fraction reciprocalOfFraction2 = new Fraction(fraction2.getDenominator(), fraction2.getNumerator());
		return multiply(reciprocalOfFraction2);
	}
	
	private void bringToLowestCommonDenominator() {
		int denominator1 = fraction1.getDenominator();
		int denominator2 = fraction2.getDenominator();
		if (denominator1 != denominator2) {
			int higherDenominator = Math.max(denominator1, denominator2);
			int lowerDenominator = Math.min(denominator1, denominator2);
			int commonDenominator = higherDenominator;
			while (commonDenominator % lowerDenominator != 0) {
				commonDenominator += higherDenominator;
			}
			fraction1.increaseDenominator(commonDenominator);
			fraction2.increaseDenominator(commonDenominator);
		}
	}

}
