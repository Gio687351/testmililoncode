package refactula.introduction_to_algorithms.utils.comparator;

import static refactula.introduction_to_algorithms.utils.comparator.Comparison.EQUAL_TO;
import static refactula.introduction_to_algorithms.utils.comparator.Comparison.GREATER_THAN;
import static refactula.introduction_to_algorithms.utils.comparator.Comparison.GREATER_THAN_OR_EQUAL_TO;
import static refactula.introduction_to_algorithms.utils.comparator.Comparison.SMALLER_THAN;
import static refactula.introduction_to_algorithms.utils.comparator.Comparison.SMALLER_THAN_OR_EQUAL_TO;

public interface Comparator<T> {

    boolean is(T first, Comparison comparison, T second);

    default PartialComparison<T> is(T first) {
        return new PartialComparison<T>() {
            @Override
            public boolean smallerThan(T second) {
                return is(first, SMALLER_THAN, second);
            }

            @Override
            public boolean smallerThanOrEqualTo(T second) {
                return is(first, SMALLER_THAN_OR_EQUAL_TO, second);
            }

            @Override
            public boolean equalTo(T second) {
                return is(first, EQUAL_TO, second);
            }

            @Override
            public boolean greaterThanOrEqualTo(T second) {
                return is(first, GREATER_THAN_OR_EQUAL_TO, second);
            }

            @Override
            public boolean greaterThan(T second) {
                return is(first, GREATER_THAN, second);
            }
        };
    }

    interface PartialComparison<T> {
        boolean smallerThan(T second);
        boolean smallerThanOrEqualTo(T second);
        boolean equalTo(T second);
        boolean greaterThanOrEqualTo(T second);
        boolean greaterThan(T second);
    }

}
