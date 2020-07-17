package examples.testing.service

import examples.testing.exception.WrongNumberException
import examples.testing.utils.Calculator
import examples.testing.utils.NumberUtils
import org.junit.runner.RunWith
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.powermock.modules.junit4.PowerMockRunnerDelegate
import org.spockframework.runtime.Sputnik
import spock.lang.Specification

import static org.mockito.ArgumentMatchers.anyLong
import static org.powermock.api.mockito.PowerMockito.mockStatic
import static org.powermock.api.mockito.PowerMockito.when

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(Sputnik.class)
@PrepareForTest([NumberUtils.class, Calculator.class])
class NumberServiceWithPowerMockSpec extends Specification {

    private final static long SOME_LONG_NUMBER = 3

    private Calculator calculator
    private NumberService testObject

    def setup() {
        mockStatic(NumberUtils.class)
        calculator = Mock()
        testObject = new NumberService(calculator)
    }

    def "should throw exception when you try to add not odd number"() {
        given:
        isOddNumber(false)

        when:
        testObject.sumOddNumbers(SOME_LONG_NUMBER, SOME_LONG_NUMBER)

        then:
        thrown(WrongNumberException)
        0 * calculator.sum(*_)
    }

    private isOddNumber(boolean isOdd) {
        when(NumberUtils.isOdd(anyLong())).thenReturn(isOdd)
    }

    def "should return value specified by mock calculator"() {
        given:
        isOddNumber(true)
        calculator.sum(*_) >> SOME_LONG_NUMBER

        expect:
        testObject.sumOddNumbers(SOME_LONG_NUMBER, SOME_LONG_NUMBER) == SOME_LONG_NUMBER
    }

}
