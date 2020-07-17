package examples.testing.utils

import spock.lang.Specification
import spock.lang.Unroll

class LambdaExampleSpec extends Specification {

    @Unroll
    def "lambda should be #expected based on input #value"() {
        when:
        //using closure to work as lambda in java
        boolean result = LambdaExample.verifyCondition({ x -> x.contains(value) }
        )
        then:
        result == expected

        where:
        value                          || expected
        LambdaExample.PROPER_CONDITION || true
        "SOME_OTHER_CONDITION"         || false
    }
}