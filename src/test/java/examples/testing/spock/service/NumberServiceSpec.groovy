package examples.testing.spock.service

import examples.testing.exception.WrongNumberException
import examples.testing.service.NumberService
import examples.testing.utils.Calculator
import spock.lang.Specification
import spock.lang.Unroll

class NumberServiceSpec extends Specification {

    private Calculator calculator
    private NumberService testObject

    def setupSpec(){
        println "SETUP SPEC"
    }

    def setup() {
        println "SETUP"
        calculator = Stub()
        testObject = new NumberService(calculator)
    }

    @Unroll
    def "should sum of two odd numbers be possible to calculate: #firstOddNumber + #secondOddNumber = #expected"() {
        given:
        println "GIVEN"
        calculator.sum(firstOddNumber, secondOddNumber) >> expected

        when:
        println "WHEN"
        def result = testObject.sumOddNumbers(firstOddNumber, secondOddNumber)

        then:
        println "THEN"
        result == expected

        where:
        firstOddNumber | secondOddNumber || expected | printStepCall
        1              | 3               || 4        | printStepWhere(1)
        5              | 5               || 10       | printStepWhere(2)
    }

    def printStepWhere(int index) {
        println "calculator is null: " + (calculator == null)

        // mock is not changed here - watch out for this case when you set mock in setup method
        calculator.sum(1, 3) >> 3

        println("WHERE " + index)
    }

    @Unroll
    def "should calculation at least one not odd number throw exception: #firstNumber + #secondNumber, #description"() {
        when:
        testObject.sumOddNumbers(firstNumber, secondNumber)

        then:
        thrown(WrongNumberException)

        where:
        firstNumber | secondNumber || description                | printStepCall
        2           | 1            || "first number is not odd"  | printStepWhere(1)
        1           | 4            || "second number is not odd" | printStepWhere(2)
        2           | 2            || "both numbers are not odd" | printStepWhere(3)
    }

    def cleanup() {
        println "CLEANUP"
    }

    def cleanupSpec() {
        println "CLEANUP SPEC"
    }
}
