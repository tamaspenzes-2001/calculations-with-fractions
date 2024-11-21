package calculationsWithFractions;

public class App {

	public static void main(String[] args) {
		Fraction fraction1 = new Fraction(1, 2);
		Fraction fraction2 = new Fraction(1, 4);
		Calculator calculator = new Calculator(fraction1, fraction2);
		Fraction sum = calculator.add();
		Fraction difference = calculator.subtract();
		Fraction product = calculator.multiply();
		Fraction quotient = calculator.divide();
		
		Fraction simplifiedSum = sum.getSimplifiedFraction();
		Fraction simplifiedDifference = difference.getSimplifiedFraction();
		Fraction simplifiedProduct = product.getSimplifiedFraction();
		Fraction simplifiedQuotient = quotient.getSimplifiedFraction();
		
		Fraction fraction1Original = calculator.getFraction1Original();
		Fraction fraction2Original = calculator.getFraction2Original();
		
		System.out.println(fraction1Original + " + " + fraction2Original + " = "
				+ (!fraction1.equals(fraction1Original) || !fraction2.equals(fraction2Original) ? fraction1 + " + " + fraction2 + " = " : "") // if bringing to common denominator is needed, include its result
				+ sum + (!sum.equals(simplifiedSum) ? " = " + simplifiedSum : "")
				+ (simplifiedSum.getDenominator() == 0 || simplifiedSum.getNumerator() == 0 ? " = 0" :
					(simplifiedSum.getDenominator() == 1 ? " = " + simplifiedSum.getNumerator() : "")));
		System.out.println(fraction1Original + " - " + fraction2Original + " = "
				+ (!fraction1.equals(fraction1Original) || !fraction2.equals(fraction2Original) ? fraction1 + " - " + fraction2 + " = " : "")
				+ difference + (!difference.equals(simplifiedDifference) ? " = " + simplifiedDifference : "")
				+ (simplifiedDifference.getDenominator() == 0 || simplifiedDifference.getNumerator() == 0 ? " = 0" :
					(simplifiedDifference.getDenominator() == 1 ? " = " + simplifiedDifference.getNumerator() : "")));
		System.out.println(fraction1Original + " * " + fraction2Original + " = "
				+ product + (!product.equals(simplifiedProduct) ? " = " + simplifiedProduct : "")
				+ (simplifiedProduct.getDenominator() == 0 || simplifiedProduct.getNumerator() == 0 ? " = 0" :
					(simplifiedProduct.getDenominator() == 1 ? " = " + simplifiedProduct.getNumerator() : "")));
		System.out.println(fraction1Original + " / " + fraction2Original + " = "
				+ quotient + (!quotient.equals(simplifiedQuotient) ? " = " + simplifiedQuotient : "")
				+ (simplifiedQuotient.getDenominator() == 0 || simplifiedQuotient.getNumerator() == 0 ? " = 0" :
					simplifiedQuotient.getDenominator() == 1 ? " = " + simplifiedQuotient.getNumerator() : ""));
	}

}
