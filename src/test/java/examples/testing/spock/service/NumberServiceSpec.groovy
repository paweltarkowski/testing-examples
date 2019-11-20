package examples.testing.spock.service

import examples.testing.exception.WrongNumberException
import examples.testing.service.NumberService
import examples.testing.utils.Calculator
import spock.lang.Specification
import spock.lang.Unroll

class NumberServiceSpec extends Specification {

    private Calculator calculator
    private NumberService testObject

    def setup() {
        println "SETUP"
        calculator = Mock()
        testObject = new NumberService(calculator)
    }

    @Unroll
    def "should sum of two odd numbers be possible to calculate: #firstOddNumber + #secondOddNumber"() {
        given:
        println "GIVEN"
        calculator.sum(firstOddNumber, secondOddNumber) >> sum

        when:
        println "WHEN"
        def result = testObject.sumOddNumbers(firstOddNumber, secondOddNumber)

        then:
        println "THEN"
        result == sum

        where:
        firstOddNumber | secondOddNumber || sum | printStepCall
        1              | 3               || 4   | printStepWhere(1)
        5              | 5               || 10  | printStepWhere(2)
    }

    def printStepWhere(int index) {
        println("WHERE " + index)
    }

    @Unroll
    def "should calculation at least one not odd number throw exception: #firstNumber + #secondNumber, #description"() {
        when:
        testObject.sumOddNumbers(firstNumber, secondNumber)

        then:
        thrown(WrongNumberException)

        where:
        firstNumber | secondNumber | description
        2           | 1            | "first number is not odd"
        1           | 4            | "second number is not odd"
        2           | 2            | "both numbers are not odd"
    }

}
