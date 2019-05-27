package examples.testing.utils.junit4;

import examples.testing.utils.Calculator;
import org.junit.Test;

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
        double result = testObject.add(firstNumber, secondNumber);
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

}
