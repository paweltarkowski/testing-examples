package examples.testing.junit4.service;

import examples.testing.exception.WrongNumberException;
import examples.testing.service.NumberService;
import examples.testing.utils.Calculator;
import examples.testing.utils.NumberUtils;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
//static classes for tests
@PrepareForTest({Calculator.class, NumberUtils.class})
//example of additional runner you want to run
@PowerMockRunnerDelegate(JUnitParamsRunner.class)
public class NumberServiceTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private long SOME_LONG_VALUE = 1;

    @InjectMocks
    private NumberService testObject;

    @Mock
    private Calculator calculatorMock;

    @Before
    public void setUp() {
        logger.debug("Init mocks");
    }

    @Test
    @Parameters({"1, 2", "2, 4"})
    public void shouldSumOddNumbers(long number, long expected) throws WrongNumberException {
        //given
        logger.debug("number = {} ", number);
        mockStatic(NumberUtils.class);
        when(NumberUtils.isOdd(anyLong())).thenReturn(true);
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
    public void shouldThrowWrongNumberException() throws WrongNumberException {
        //given
        mockStatic(NumberUtils.class);
        when(NumberUtils.isOdd(anyLong())).thenReturn(false);
        //when
        testObject.sumOddNumbers(SOME_LONG_VALUE, SOME_LONG_VALUE);
        //then
        fail("Should exception be thrown");
    }

}
