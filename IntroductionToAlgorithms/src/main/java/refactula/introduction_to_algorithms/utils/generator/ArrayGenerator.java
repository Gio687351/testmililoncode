package refactula.introduction_to_algorithms.utils.generator;

import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.array.Arrays;

public class ArrayGenerator<T> implements Generator<Array<T>> {
    private final ListGenerator<T> listGenerator;

    public ArrayGenerator(ListGenerator<T> listGenerator) {
        this.listGenerator = listGenerator;
    }

    @Override
    public Array<T> generate() {
        return Arrays.ofList(listGenerator.generate());
    }
}
