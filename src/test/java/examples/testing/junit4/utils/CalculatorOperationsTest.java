package examples.testing.junit4.utils;

import examples.testing.junit4.runtest.OperationTests;
import examples.testing.utils.Calculator;
import examples.testing.utils.Operation;
import examples.testing.utils.Sum;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CalculatorOperationsTest {

    private static double SOME_VALUE = 1.0;

    private Calculator testObject = new Calculator();

    @Mock
    private Operation mockOperation;

    @Spy
    private Operation sumOperation = new Sum(SOME_VALUE, SOME_VALUE);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCalcUsingMockOperation() {
        //given
        double expected = 1.0;
        when(mockOperation.calculate()).thenReturn(expected);
        //when
        double result = testObject.calculate(mockOperation);
        //then
        assertEquals(0, Double.compare(expected, result));
    }

    @Test
    @Category(OperationTests.class)
    public void shouldCalcUsingCreateMockOperationUsingStaticMethod() {
        //given
        Operation stubOperation = mock(Operation.class);
        when(stubOperation.calculate()).thenReturn(SOME_VALUE);
        //when
        double result = testObject.calculate(stubOperation);
        //then
        verify(stubOperation).calculate();
        assertEquals(0, Double.compare(SOME_VALUE, result));
    }

    @Test
    @Category(OperationTests.class)
    public void shouldCalcUsingRealSumOperation() {
        //given
        //when
        double result = testObject.calculate(sumOperation);
        //then
        assertEquals(0, Double.compare(2.0, result));
    }

    @Test
    @Category(OperationTests.class)
    public void shouldCalcUsingSpySumOperation() {
        //given
        double expected = 123.0;
        when(sumOperation.calculate()).thenReturn(expected);
        //when
        double result = testObject.calculate(sumOperation);
        //then
        assertEquals(0, Double.compare(expected, result));
    }

    @Test
    @Category(OperationTests.class)
    public void shouldCalcUsingStubOperation() {
        //given
        Operation stubOperation = new StubOperation(SOME_VALUE);
        //when
        double result = testObject.calculate(stubOperation);
        //then
        assertEquals(0, Double.compare(SOME_VALUE, result));
    }

}
