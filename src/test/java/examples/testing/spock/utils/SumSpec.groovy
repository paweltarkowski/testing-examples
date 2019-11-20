package examples.testing.spock.utils

import examples.testing.utils.Sum
import spock.lang.Specification
import spock.lang.Unroll

class SumSpec extends Specification {

    @Unroll
    def "should sum all elements #description"() {
        when:
        def result = operation.calculate()

        then:
        Double.compare(result, expected) == 0

        where:
        operation      | expected | description
        new Sum(1, 2)  | 3        | "1 + 2 = 3"
        new Sum(0, 1)  | 1        | "0 + 1 = 1"
        new Sum(-1, 2) | 1        | "-1 + 2  = 1"
    }
}
