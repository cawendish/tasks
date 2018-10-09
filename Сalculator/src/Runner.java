
public class Runner {

	public static void main(String[] args) {
		final String EXPRESSION = "1.56 + 2 / 3.24 + 4 * 3.2";
		Calculator calculator = new Calculator();
		double result = calculator.calculate(EXPRESSION);
		System.out.println(result);
	}

}
