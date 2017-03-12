package refactula.introduction_to_algorithms.utils.array;

import java.util.AbstractList;
import java.util.List;

public class Arrays {

    private Arrays() {
        // private constructor
    }

    public static <T> Array<T> ofObjects(int length) {
        return new ObjectArray<T>(createGenericArray(length));
    }

    @SuppressWarnings("unchecked")
    private static <T> T[] createGenericArray(int length) {
        return (T[]) new Object[length];
    }

    public static Array<Boolean> ofBooleans(int length) {
        return of(new boolean[length]);
    }

    public static Array<Byte> ofBytes(int length) {
        return of(new byte[length]);
    }

    public static Array<Character> ofChars(int length) {
        return of(new char[length]);
    }

    public static Array<Double> ofDoubles(int length) {
        return of(new double[length]);
    }

    public static Array<Float> ofFloats(int length) {
        return of(new float[length]);
    }

    public static Array<Integer> ofInts(int length) {
        return of(new int[length]);
    }

    public static Array<Long> ofLongs(int length) {
        return of(new long[length]);
    }

    public static Array<Short> ofShorts(int length) {
        return of(new short[length]);
    }

    public static Array<Boolean> of(boolean... delegate) {
        return new BooleanArray(delegate);
    }

    public static Array<Byte> of(byte... delegate) {
        return new ByteArray(delegate);
    }

    public static Array<Character> of(char... delegate) {
        return new CharArray(delegate);
    }

    public static Array<Double> of(double... delegate) {
        return new DoubleArray(delegate);
    }

    public static Array<Float> of(float... delegate) {
        return new FloatArray(delegate);
    }

    public static Array<Integer> of(int... delegate) {
        return new IntArray(delegate);
    }

    public static Array<Long> of(long... delegate) {
        return new LongArray(delegate);
    }

    public static Array<Short> of(short... delegate) {
        return new ShortArray(delegate);
    }

    public static <T> Array<T> ofList(List<T> list) {
        return new ListArray<>(list);
    }

    public static <T> List<T> asList(Array<T> array) {
        return new AbstractList<T>() {
            @Override
            public int size() {
                return array.length();
            }

            @Override
            public T get(int index) {
                return array.get(index);
            }
        };
    }
}
