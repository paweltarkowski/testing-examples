package examples.testing.junit4.service;

import examples.testing.exception.WrongNumberException;
import examples.testing.service.NumberService;
import examples.testing.utils.Calculator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class NumberServiceSimpleMockTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @InjectMocks
    private NumberService testObject;

    @Mock
    private Calculator calculatorMock;

    @Before
    public void setUp() {
        logger.debug("Init mocks");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Parameters({"1, 2", "3, 6"})
    public void shouldSumOddNumbers(long number, long expected) throws WrongNumberException {
        //given
        logger.debug("number = {} ", number);
        when(calculatorMock.sum(number, number)).thenReturn(Double.valueOf(expected));

        //when
        long result = testObject.sumOddNumbers(number, number);

        //then
        //additionally you can verify if mock was called once
        verify(calculatorMock).sum(number, number);
        //another example
        verify(calculatorMock, times(1)).sum(anyDouble(), anyDouble());
        assertEquals(0, Double.compare(expected, result));
    }

    @Test(expected = WrongNumberException.class)
    @Parameters({"1, 2", "2, 1", "2, 2"})
    public void shouldThrowWrongNumberException(long firstNumber, long secondNumber) throws WrongNumberException {
        //given
        //when
        testObject.sumOddNumbers(firstNumber, secondNumber);
        //then
        fail("Should exception be thrown");
    }

}
