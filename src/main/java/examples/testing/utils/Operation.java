package examples.testing.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Operation {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected final double firstNumber;
    protected final double secondNumber;

    public Operation(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public abstract double calculate();
}
