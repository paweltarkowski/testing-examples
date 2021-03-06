package examples.testing.junit4.utils;

import examples.testing.utils.Calculator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING) //order test methods by name
public class CalculatorTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(CalculatorTest.class);

    private static Calculator testObject;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void setUpClass() {
        LOGGER.debug("Setup class");
        testObject = new Calculator();
    }

    @Before
    public void setUp() {
        LOGGER.debug("Setup test");
    }

    //example of specify params before method call
    @Test
    @Parameters({
            "1, 2, 3",
            "1, -1, 0"
    })
    public void shouldAddNumbers(double firstNumber, double secondNumber, double expected) {
        //given
        //when
        double result = testObject.sum(firstNumber, secondNumber);
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

    @Test //(expected = ArithmeticException.class) - can be used in case on exception.expect
    @Parameters({
            "1, 0",
            "0, 0",
            "-100, 0"

    })
    public void shouldThrowExceptionDuringDivideNumbers(double firstNumber, double secondNumber) {
        //given
        exception.expect(ArithmeticException.class);
        //when
        //then
        testObject.divide(firstNumber, secondNumber);
    }

    @After
    public void tearDown() {
        LOGGER.debug("Tear down after test");
    }

    @AfterClass
    public static void tearDownClass() {
        LOGGER.debug("Tear down after class");
    }

}
