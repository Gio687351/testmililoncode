package refactula.design.patterns.abstract_factory.utils;

import com.google.common.base.Preconditions;

public class CastUtils {
    private CastUtils() { /* private constructor */ }

    public static <T> T checkInstanceOf(Class<T> cls, Object o) {
        Preconditions.checkNotNull(o);
        Preconditions.checkArgument(cls.isAssignableFrom(o.getClass()));
        return cls.cast(o);
    }
}
