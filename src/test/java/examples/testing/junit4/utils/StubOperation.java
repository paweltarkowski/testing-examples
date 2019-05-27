package examples.testing.junit4.utils;

import examples.testing.utils.Operation;

public class StubOperation extends Operation {

    public StubOperation(double firstNumber) {
        super(firstNumber, firstNumber);
    }

    public double calculate() {
        return firstNumber;
    }
}
