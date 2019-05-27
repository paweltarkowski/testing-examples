package examples.testing.junit4.runtest;

import examples.testing.junit4.utils.CalculatorOperationsTest;
import examples.testing.junit4.utils.CalculatorSimpleTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(OperationTests.class)
@Suite.SuiteClasses({CalculatorSimpleTest.class, CalculatorOperationsTest.class}) //Run only tests for specific categories
public class OnlyOperationsSuite {
}
