package examples.testing.junit4.utils;

import examples.testing.utils.Sum;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class SumTest {

    @Test
    @Parameters({
            "1, 2, 3",
            "1, -1, 0"
    })
    public void shouldAddNumbers(double firstNumber, double secondNumber, double expected) {
        //given
        //when
        double result = new Sum(firstNumber, secondNumber).calculate();
        //then
        assertEquals(0, Double.compare(expected, result));
    }
}
