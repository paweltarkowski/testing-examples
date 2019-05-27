package examples.testing.junit4.utils;

import examples.testing.junit4.runtest.OperationTests;
import examples.testing.utils.Calculator;
import examples.testing.utils.Operation;
import examples.testing.utils.Sum;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CalculatorSimpleTest {

    private Calculator testObject = new Calculator();

    @Test
    public void shouldAddNumbers() {
        //given
        int firstNumber = 1;
        int secondNumber = 2;
        //when
        double result = testObject.sum(firstNumber, secondNumber);
        //then
        assertEquals(0, Double.compare(3.0, result));
    }


    @Test
    public void shouldMultiplyNumbers() {
        //given
        int firstNumber = 1;
        int secondNumber = 2;
        //when
        double result = testObject.multiply(firstNumber, secondNumber);
        //then
        assertEquals(0, Double.compare(2.0, result));
    }

    @Test
    public void shouldDivideNumbers() {
        //given
        int firstNumber = 1;
        int secondNumber = 2;
        //when
        double result = testObject.divide(firstNumber, secondNumber);
        //then
        assertEquals(0, Double.compare(0.5, result));
    }

    @Test(expected = ArithmeticException.class)
    public void shouldDivideNumbersWithException() {
        //given
        double firstNumber = 1.0;
        double secondNumber = 0.0;
        //when
        testObject.divide(firstNumber, secondNumber);
        //then
        fail("exception should be thrown because you can not divide by zero");
    }

    @Test
    @Category(OperationTests.class)
    public void shouldAddNumbersUsingOperations() {
        //given
        Operation operation = new Sum(1, 2);
        //when
        double result = testObject.calculate(operation);
        //then
        assertEquals(0, Double.compare(3.0, result));
    }

}
