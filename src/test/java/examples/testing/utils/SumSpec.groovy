package examples.testing.utils

import spock.lang.Specification
import spock.lang.Unroll

class SumSpec extends Specification {

    @Unroll
    def "should sum all elements #description"() {
        when:
        def result = operation.calculate()

        then:
        result == expected

        where:
        operation         || expected | description
        new Sum(1.3, 2.4) || 3.7      | "1.3 + 2.4 = 3.7"
        new Sum(0, 1)     || 1        | "0 + 1 = 1"
        new Sum(-1, 2)    || 1        | "-1 + 2  = 1"
    }
}
