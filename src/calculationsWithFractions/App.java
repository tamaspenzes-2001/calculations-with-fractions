package calculationsWithFractions;

import java.util.Arrays;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		String fraction1Input = promptForFraction("First fraction (e.g. 4/9): ");
		String fraction2Input = promptForFraction("Second fraction (e.g. 4/9): ");
		int[] fraction1Arr = strToIntArr(fraction1Input);
		int[] fraction2Arr = strToIntArr(fraction2Input);
		Fraction fraction1 = new Fraction(fraction1Arr[0], fraction1Arr[1]);
		Fraction fraction2 = new Fraction(fraction2Arr[0], fraction2Arr[1]);
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
	
	public static String promptForFraction(String promptText) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.print(promptText);
			String fraction = input.nextLine();
			if (!fraction.matches("^-?[0-9]+/-?[0-9]+$")) {
			    System.out.println("Please provide a fraction with integers as numerator and denominator!");
			    continue;
			}
			return fraction;
		}
	}
	
	public static int[] strToIntArr(String str) {
		return Arrays.stream(str.split("/"))
			    .mapToInt(Integer::parseInt)
			    .toArray();
	}
}
