package calculationsWithFractions;

public class App {

	public static void main(String[] args) {
		Fraction fraction = new Fraction(2, 5);
		Fraction fraction2 = new Fraction(2, 4);
		Calculator calculator = new Calculator(fraction, fraction2);
		Fraction sum = calculator.add();
		System.out.println(sum);
	}

}
