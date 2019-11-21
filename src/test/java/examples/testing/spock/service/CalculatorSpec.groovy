package examples.testing.spock.service

import examples.testing.utils.Calculator
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class CalculatorSpec extends Specification {

    @Shared
    private Calculator testObject = new Calculator()

    @Unroll
    def "should sum  #firstNumber + #secondNumber = #expected"() {
        expect:
        testObject.sum(firstNumber, secondNumber) == expected

        where:
        firstNumber | secondNumber || expected
        1           | 2            || 3
        1.5         | 2.8          || 4.3
        1           | -2           || -1
    }

    @Unroll
    def "should multiply #firstNumber * #secondNumber = #expected"() {
        expect:
        testObject.multiply(firstNumber, secondNumber) == expected

        where:
        firstNumber | secondNumber || expected
        1           | 2            || 2
        1.5         | 3.02         || 4.53
        0           | 1            || 0
    }

    @Unroll
    def "should divide #firstNumber/#secondNumber = #expected"() {
        expect:
        testObject.divide(firstNumber, secondNumber) == expected

        where:
        firstNumber | secondNumber || expected
        1           | 2            || 0.5
        2           | 1            || 2
        0           | 1            || 0
    }

    @Unroll
    def "should throw exception because of #someNumber is division by 0"() {
        when:
        testObject.divide(someNumber, 0)

        then:
        def exc = thrown(ArithmeticException)
        exc.getMessage().contains(someNumber.toPlainString())

        where:
        someNumber << [0.0, 1.0, 2.0]
    }
}
