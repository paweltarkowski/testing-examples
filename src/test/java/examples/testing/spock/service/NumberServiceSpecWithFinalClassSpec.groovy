package examples.testing.spock.service

import examples.testing.service.NumberService
import examples.testing.utils.FinalCalculator
import org.junit.runner.RunWith
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.powermock.modules.junit4.PowerMockRunnerDelegate
import org.spockframework.runtime.Sputnik
import spock.lang.Specification
import spock.lang.Unroll

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(Sputnik.class)
@PrepareForTest([FinalCalculator.class])
class NumberServiceSpecWithFinalClassSpec extends Specification {

    private FinalCalculator finalCalculator
    private NumberService testObject

    def setup() {
        finalCalculator = Mock(FinalCalculator)
        testObject = new NumberService(finalCalculator)
    }

    @Unroll
    def "should sum of two odd numbers be possible to calculate: #firstOddNumber + #secondOddNumber = #expected"() {
        given:
        finalCalculator.sum(firstOddNumber, secondOddNumber) >> expected

        expect:
        testObject.sumOddNumbers(firstOddNumber, secondOddNumber) == expected

        where:
        firstOddNumber | secondOddNumber || expected
        1              | 3               || 4
        5              | 5               || 10
    }

}
