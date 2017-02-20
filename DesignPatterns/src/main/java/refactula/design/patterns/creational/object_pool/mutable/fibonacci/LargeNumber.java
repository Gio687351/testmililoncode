package refactula.design.patterns.creational.object_pool.mutable.fibonacci;

import com.google.common.base.Preconditions;

public class LargeNumber {
    private final byte[] digits;
    private int usedDigits;

    public LargeNumber(int maxDigits) {
        digits = new byte[maxDigits];
        setZero();
    }

    public void setZero() {
        usedDigits = 0;
    }

    public void set(long value) {
        Preconditions.checkArgument(value >= 0);
        setZero();
        while (value > 0) {
            digits[usedDigits++] = (byte) (value % 10);
            value /= 10;
        }
    }

    public byte getDigit(int index) {
        return index < usedDigits ? digits[index] : 0;
    }

    public int getDigitsAmount() {
        return usedDigits;
    }

    public void sum(LargeNumber x, LargeNumber y) {
        byte reminder = 0;
        setZero();
        while (usedDigits < x.getDigitsAmount() || usedDigits < y.getDigitsAmount() || reminder > 0) {
            reminder += x.getDigit(usedDigits) + y.getDigit(usedDigits);
            digits[usedDigits] = (byte) (reminder % 10);
            reminder /= 10;
            usedDigits++;
        }
    }

    @Override
    public String toString() {
        if (usedDigits == 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder(usedDigits);
        for (int i = usedDigits - 1; i >= 0; i--) {
            stringBuilder.append(digits[i]);
        }
        return stringBuilder.toString();
    }
}
