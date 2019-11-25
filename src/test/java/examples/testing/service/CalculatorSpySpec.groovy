package examples.testing.service

import examples.testing.utils.Calculator
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class CalculatorSpySpec extends Specification {

    @Shared
    private Calculator testObject = Spy(Calculator) {
        sum(_, _) >> 0
    }

    @Unroll
    def "should sum always be 0 because of using SPY object, result #a+#b = 0 !!!" () {
        expect:
        testObject.sum(a, b) == 0

        where:
        a | b
        1 | 2
        3 | 4
    }

    @Unroll
    def "should multiply #a + #b = #expected"() {
        expect:
        testObject.multiply(a, b) == expected

        where:
        a | b || expected
        1 | 2 || 2
        3 | 4 || 12
        0 | 2 || 0
    }

}
