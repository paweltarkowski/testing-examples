package examples.testing.utils;

public class Sum extends Operation {

    public Sum(double firstNumber, double secondNumber) {
        super(firstNumber, secondNumber);
    }

    public double calculate() {
        logger.debug("Add 2 numbers: {} + {}", firstNumber, secondNumber);
        return firstNumber + secondNumber;
    }
}
