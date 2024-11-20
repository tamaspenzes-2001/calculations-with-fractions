package calculationsWithFractions;

public class App {

	public static void main(String[] args) {
		Fraction fraction = new Fraction(1, 6);
		Fraction fraction2 = new Fraction(3, 5);
		Calculator calculator = new Calculator(fraction, fraction2);
		Fraction sum = calculator.multiply();
		System.out.println(sum);
	}

}
