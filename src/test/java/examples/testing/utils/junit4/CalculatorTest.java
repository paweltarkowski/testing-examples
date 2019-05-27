package examples.testing.utils;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    private Calculator testObject = new Calculator();

    @Test
    @Parameters({
            "1, 2, 3",
            "1, -1, 0"
    })
    public void shouldAddNumbers(double firstNumber, double secondNumber, double expected) {
        //given
        //when
        double result = testObject.add(firstNumber, secondNumber);
        //then
        assertEquals(0, Double.compare(expected, result));
    }

    //name of this method is connected with shouldMultiplyNumbers
    private Object[] parametersForShouldMultiplyNumbers() {
        return new Object[]{
                new Object[]{1, 2, 2.0},
                new Object[]{3, 4, 12.0}
        };
    }

    @Test
    @Parameters
    public void shouldMultiplyNumbers(double firstNumber, double secondNumber, double expected) {
        //given
        //when
        double result = testObject.multiply(firstNumber, secondNumber);
        //then
        assertEquals(0, Double.compare(expected, result));
    }


    private Object[] parameterForCheckDivide() {
        return new Object[]{
                new Object[]{0, 2, 0},
                new Object[]{1, 2, 0.5}
        };
    }

    @Test
    @Parameters(method = "parameterForCheckDivide")
    public void shouldDivideNumbers(double firstNumber, double secondNumber, double expected) {
        //given
        //when
        double result = testObject.divide(firstNumber, secondNumber);
        //then
        assertEquals("Expected: " + expected + ", result: " + result, 0, Double.compare(expected, result));
    }

    @Test(expected = ArithmeticException.class)
    @Parameters({
            "1, 0",
            "0, 0",
            "-100, 0"

    })

    public void shouldThrowExceptionDuringDivideNumbers(double firstNumber, double secondNumber) {
        //given
        //when
        //then
        testObject.divide(firstNumber, secondNumber);
    }
}
