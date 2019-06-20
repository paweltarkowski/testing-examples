package examples.testing.junit5.utils;

import examples.testing.utils.Sum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.Stream.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("Sum Assertions")
public class SumTest {

    static Stream<Arguments> forShouldAddNumbers() {
        return of(
                arguments(1.0, 2.0, 3.0),
                arguments(1.0, 1.0, 2.0)
        );
    }

    @ParameterizedTest(name = "\"{0}+{1}\" should be {2}")
    @MethodSource("forShouldAddNumbers")
    @CsvSource({"2.0, 5.0, 7.0", "2.0, -3.0, -1.0"})
    public void shouldAddNumbers(double firstNumber, double secondNumber, double expected) {
        //given
        //when
        double result = new Sum(firstNumber, secondNumber).calculate();
        //then
        assertEquals(0, Double.compare(expected, result));
    }
}
