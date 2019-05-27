package examples.testing.utils;

public class Calculator {
    public double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public double divide(double firstNumber, double secondNumber) {
        if (Double.compare(secondNumber, 0.0) == 0) {
            throw new ArithmeticException("Can not divide " + firstNumber + " by 0 ");
        }
        return firstNumber / secondNumber;
    }
}
