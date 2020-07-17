package examples.testing.service

import examples.testing.utils.Calculator
import examples.testing.utils.Operation
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class CalculatorOperationSpec extends Specification {

    def SOME_VALUE = 1

    @Shared
    private Calculator testObject = new Calculator()

    def "calculator should check if method operation return proper value "() {
        given:
        //Stub is used because we do not need check of invocation count and verify only result of the method
        Operation operation = Stub()
        //we can declare mocking method in "given: because we do not check invocation count of this method in "then" block
        operation.calculate() >> SOME_VALUE

        expect:
        testObject.calculate(operation) == SOME_VALUE
    }

    @Unroll
    def "calculator should invoke operation method and return: #expected"() {
        given:

        Operation operation = Mock()
        when:
        def result = testObject.calculate(operation)

        then:
        //invocation count and checking results requires some kind of trick - return mock value is defined in "then" block
        //instead of "given" block to allow spock to work as expected
        1 * operation.calculate() >> expected
        result == expected


        where:
        expected << [1, 3, 5]
    }

    def "calculator throw exception thrown by operation"() {
        given:
        Operation operation = Stub()
        operation.calculate() >> {
            throw new ArithmeticException("SOME EXCEPTION")
        }

        when:
        testObject.calculate(operation)

        then:
        thrown(ArithmeticException)
    }

}
