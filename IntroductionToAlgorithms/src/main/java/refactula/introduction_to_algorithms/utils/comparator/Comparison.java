package refactula.introduction_to_algorithms.utils.comparator;

import java.util.function.IntPredicate;

public enum Comparison {
    LESS_THAN(comparisonInt -> comparisonInt < 0),
    LESS_THAN_OR_EQUAL_TO(comparisonInt -> comparisonInt <= 0),
    EQUAL_TO(comparisonInt -> comparisonInt == 0),
    GREATER_THAN_OR_EQUAL_TO(comparisonInt -> comparisonInt >= 0),
    GREATER_THAN(comparisonInt -> comparisonInt > 0);

    private final IntPredicate predicate;

    Comparison(IntPredicate predicate) {
        this.predicate = predicate;
    }

    public boolean matches(int comparisonInt) {
        return predicate.test(comparisonInt);
    }
}
