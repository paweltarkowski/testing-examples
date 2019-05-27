package examples.testing.junit4.utils;

import examples.testing.utils.NumberUtils;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class NumberUtilsTest {

    @Test
    @Parameters({
            "1, true",
            "3, true",
            "5, true",
            "0, false",
            "2, false",
            "10, false",
    })
    public void shouldCheckOddNumbers(long number, boolean expected) {
        //given
        //when
        //then
        assertEquals(expected, NumberUtils.isOdd(number));
    }

}

