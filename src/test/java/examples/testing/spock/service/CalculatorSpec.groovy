package examples.testing.spock.service

import examples.testing.utils.Calculator
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class CalculatorSpec extends Specification {

    @Shared
    private Calculator testObject = new Calculator()

    @Unroll
    def "should sum  #firstNumber + #secondNumber = #result"() {
        expect:
        testObject.sum(firstNumber, secondNumber) == result

        where:
        firstNumber | secondNumber || result
        1           | 2            || 3
        1.5         | 2.8          || 4.3
    }

    @Unroll
    def "should multiply #firstNumber * #secondNumber = #result"() {
        expect:
        testObject.multiply(firstNumber, secondNumber) == result

        where:
        firstNumber | secondNumber || result
        1           | 2            || 2
        1.5         | 3.02         || 4.53
    }
}
