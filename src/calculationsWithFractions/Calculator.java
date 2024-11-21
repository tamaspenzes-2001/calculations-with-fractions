package calculationsWithFractions;

public class Calculator {
	private Fraction fraction1;
	private Fraction fraction2;
	private final Fraction fraction1Original;
	private final Fraction fraction2Original;
	
	public Calculator(Fraction fraction1, Fraction fraction2) {
		this.fraction1 = fraction1;
		this.fraction2 = fraction2;
		this.fraction1Original = new Fraction(fraction1);
		this.fraction2Original = new Fraction(fraction2);
	}

	public Fraction getFraction1() {
		return fraction1;
	}

	public Fraction getFraction2() {
		return fraction2;
	}

	public Fraction getFraction1Original() {
		return fraction1Original;
	}
	public Fraction getFraction2Original() {
		return fraction2Original;
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
		Fraction multiplyer = fraction2Original;
		if (reciprocal.length == 1) {
			multiplyer = reciprocal[0];
		}
		int numerator = fraction1Original.getNumerator() * multiplyer.getNumerator();
		int denominator = fraction1Original.getDenominator() * multiplyer.getDenominator();
		return new Fraction(numerator, denominator);
	}
	
	public Fraction divide() {
		Fraction reciprocalOfFraction2 = new Fraction(fraction2Original.getDenominator(), fraction2Original.getNumerator());
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
