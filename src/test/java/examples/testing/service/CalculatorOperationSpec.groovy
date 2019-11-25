package examples.testing.service

import examples.testing.utils.Calculator
import examples.testing.utils.Operation
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class CalculatorOperationSpec extends Specification {

    @Shared
    private Calculator testObject = new Calculator()

    @Unroll
    def "calculator should return value calculated by operation: #value"() {
        given:
        Operation operation = Stub()
        operation.calculate() >> value

        expect:
        testObject.calculate(operation) == value

        where:
        value << [1, 3, 5]
    }

    def "calculator throw exception thrown by operation"() {
        given:
        Operation operation = Stub()
        operation.calculate() >> {
            throw new ArithmeticException("SOME EXCEPTION");
        }

        when:
        testObject.calculate(operation)

        then:
        thrown(ArithmeticException)
    }

}
