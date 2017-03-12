package refactula.introduction_to_algorithms.radix_sort;

import refactula.introduction_to_algorithms.utils.enumeration.Enumeration;

final class DigitEnumeration implements Enumeration<Integer> {
    private final int division;
    private final int mod;

    DigitEnumeration(int division, int mod) {
        this.division = division;
        this.mod = mod;
    }

    @Override
    public int valuesAmount() {
        return mod * 2 - 1;
    }

    @Override
    public int getIndex(Integer value) {
        return (value / division) % mod + mod - 1;
    }
}
