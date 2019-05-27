package examples.testing.utils.junit4;

import examples.testing.utils.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculatorAddParameterizedTest {

    private Calculator testObject = new Calculator();

    @Parameter
    public double firstNumber;

    @Parameter(value = 1)
    public double secondNumber;

    @Parameter(value = 2)
    public double expected;

    @Parameters(name = "{index}: Calculate ({0}+{1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 2, 3},
                {1, -1, 0}
        });
    }

    @Test
    public void shouldAddNumbersWhichAreParameterized() {
        //given
        //when
        double result = testObject.add(firstNumber, secondNumber);
        //then
        assertEquals(0, Double.compare(expected, result));
    }
}
