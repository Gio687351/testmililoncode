package refactula.micro.futuristic.model;

public final class CVCode {
    private final String text;

    public CVCode(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CVCode cvCode = (CVCode) o;

        return text != null ? text.equals(cvCode.text) : cvCode.text == null;
    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }

    @Override
    public String toString() {
        return text;
    }
}
