package examples.testing.service;

import examples.testing.exception.WrongNumberException;
import examples.testing.utils.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static examples.testing.utils.NumberUtils.isOdd;

public class NumberService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final Calculator calculator;

    public NumberService(Calculator calculator) {
        this.calculator = calculator;
    }

    public long sumOddNumbers(long firstNumber, long secondNumber) throws WrongNumberException {
        if (!isOdd(firstNumber) || !isOdd(secondNumber)) {
            throw new WrongNumberException("At least one number is not odd:" + firstNumber + "," + secondNumber);
        }
        long result = Double.valueOf(calculator.sum(firstNumber, secondNumber)).longValue();
        logger.info("Result is {}", result);
        return result;
    }
}
