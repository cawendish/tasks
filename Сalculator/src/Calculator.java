import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Calculator {
	private static final int MIN_ELEMENT_COUNT = 3;
	
	public Calculator() {

	}

	private String polishNotation(String inputStr) {

		StringBuilder stack = new StringBuilder();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < inputStr.length(); i++) {
			char curChar = inputStr.charAt(i);
			if (Operation.isOperation(curChar)) {
				while (stack.length() > 0) {
					char tempChar = stack.substring(stack.length() - 1).charAt(0);
					if (Operation.isOperation(tempChar) && (Operation.fromChar(curChar).getPriority() <= Operation
							.fromChar(tempChar).getPriority())) {
						result.append(Constants.SPACE).append(tempChar).append(Constants.SPACE);
						stack.setLength(stack.length() - 1);
					} else {
						result.append(Constants.SPACE);
						break;
					}
				}
				result.append(Constants.SPACE);
				stack.append(curChar);
			} else {
				result.append(curChar);
			}
		}

		while (stack.length() > 0) {
			result.append(Constants.SPACE).append(stack.substring(stack.length() - 1));
			stack.setLength(stack.length() - 1);
		}

		return result.toString();
	}

	public double calculate(String inputStr) {
		
		String polishStr = polishNotation(inputStr);
		StringTokenizer tokens = new StringTokenizer(polishStr);
		
		if (tokens.countTokens() < MIN_ELEMENT_COUNT) {
			throw new IllegalArgumentException(Constants.ERROR_NOT_ENOUGH_ELEMENTS);
		}
		
		Deque<Double> numbers = new LinkedList<>();
		
		try {
			
			while (tokens.hasMoreTokens()) {
				String tempStr = tokens.nextToken();
				char symbol = tempStr.charAt(0);
				double result;
				if (tempStr.length() == 1 && Operation.isOperation(symbol)) {
					double firstNumber = numbers.pop();
					double secondNumber = numbers.pop();
					Operation operation = Operation.fromChar(symbol);
					result = operation.count(firstNumber, secondNumber);
				} else {
					result = Double.parseDouble(tempStr);
				}
				numbers.push(result);
			}
			
		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException(Constants.ERROR_NOT_ENOUGH_ELEMENTS);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Constants.ERROR_UNKNOWN_SYMBOL);
		}
		
		return numbers.pop();
	}

}
