package examples.testing.utils;

import java.util.function.Predicate;

public class LambdaExample {
    protected final static String PROPER_CONDITION = "PROPER_CONDITION";
    public static boolean verifyCondition(Predicate<String> predicate) {
        return predicate.test(PROPER_CONDITION);
    }
}
