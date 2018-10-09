
public enum Operation {

	ADDITION('+', 1) {
		@Override
		public double count(double firstNumber, double secondNumber) {
			return secondNumber + firstNumber;
		}
	},
	SUBTRACTION('-', 1) {
		@Override
		public double count(double firstNumber, double secondNumber) {
			return secondNumber - firstNumber;
		}
	},
	MULTIPLICATION('*', 2) {
		@Override
		public double count(double firstNumber, double secondNumber) {
			return secondNumber * firstNumber;
		}
	},
	DIVISION('/', 2) {
		@Override
		public double count(double firstNumber, double secondNumber) {
			if (firstNumber == 0) {
				throw new RuntimeException(Constants.ERROR_DIVISION_BY_ZERO);
			}
			return secondNumber / firstNumber;
		}
	};

	private int priority;
	private char symbol;

	private Operation(char symbol, int priority) {
		this.symbol = symbol;
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	abstract public double count(double firstNumber, double secondNumber);

	private static Operation nullableFromChar(char symbol) {
		for (Operation operation : values()) {
			if (operation.symbol == symbol) {
				return operation;
			}
		}
		return null;
	}

	public static Operation fromChar(char symbol) {
		Operation result = nullableFromChar(symbol);
		if (result == null) {
			throw new RuntimeException(Constants.ERROR_UNKNOWN_OPERATION);
		}
		return result;
	}

	public static boolean isOperation(char symbol) {
			return (nullableFromChar(symbol) != null);
	}
	
}
