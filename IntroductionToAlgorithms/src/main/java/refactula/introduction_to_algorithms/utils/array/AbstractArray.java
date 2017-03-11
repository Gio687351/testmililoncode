package refactula.introduction_to_algorithms.utils.array;

import java.util.Objects;

public abstract class AbstractArray<T> implements Array<T> {

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Array))
            return false;

        Array other = (Array) o;
        if (length() != other.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (!Objects.equals(get(i), other.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        for (int i = 0; i < length(); i++) {
            T value = get(i);
            hashCode = 31 * hashCode + Objects.hashCode(value);
        }
        return hashCode;
    }

    @Override
    public String toString() {
        return Arrays.asList(this).toString();
    }
}
