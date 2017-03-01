package refactula.story;

import java.util.function.Function;

public class Transform {

    public static <T, R> R transform(T o, Function<T, R> f) {
        return f.apply(o);
    }

    public static <T, R1, R2> R2 transform(T o, Function<T, R1> f1, Function<R1, R2> f2) {
        return f2.apply(f1.apply(o));
    }

    public static <T, R1, R2, R3> R3 transform(
            T o, 
            Function<T, R1> f1, 
            Function<R1, R2> f2, 
            Function<R2, R3> f3) {
        
        return f3.apply(f2.apply(f1.apply(o)));
    }

    public static <T, R1, R2, R3, R4> R4 transform(
            T o, 
            Function<T, R1> f1, 
            Function<R1, R2> f2, 
            Function<R2, R3> f3, 
            Function<R3, R4> f4) {
        
        return transform(transform(o, f1, f2), f3, f4);
    }

}
