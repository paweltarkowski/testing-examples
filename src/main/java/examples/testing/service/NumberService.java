package examples.testing.service;

import examples.testing.exception.WrongNumberException;
import examples.testing.utils.Calculator;

import static examples.testing.utils.NumberUtils.isOdd;

public class NumberService {

    private final Calculator calculator;

    public NumberService(Calculator calculator) {
        this.calculator = calculator;
    }

    public long sumOddNumbers(long firstNumber, long secondNumber) throws WrongNumberException {
        if (!isOdd(firstNumber) || !isOdd(secondNumber)) {
            throw new WrongNumberException("At least one number is not odd:" + firstNumber + "," + secondNumber);
        }
        double result = calculator.sum(firstNumber, secondNumber);
        return Double.valueOf(result).longValue();
    }
}
