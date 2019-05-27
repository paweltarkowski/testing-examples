package examples.testing.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public double add(double firstNumber, double secondNumber) {

        logger.debug("Add 2 numbers: {} + {}", firstNumber, secondNumber);
        return firstNumber + secondNumber;
    }

    public double multiply(double firstNumber, double secondNumber) {
        logger.debug("Multiply 2 numbers: {} * {}", firstNumber, secondNumber);
        return firstNumber * secondNumber;
    }

    public double divide(double firstNumber, double secondNumber) {
        logger.debug("Divide 2 numbers: {} / {}", firstNumber, secondNumber);
        if (Double.compare(secondNumber, 0.0) == 0) {
            throw new ArithmeticException("Can not divide " + firstNumber + " by 0 ");
        }
        return firstNumber / secondNumber;
    }
}
