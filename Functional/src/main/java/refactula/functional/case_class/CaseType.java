package refactula.functional.case_class;

public abstract class CaseType<C extends CaseType<C>> {
    private volatile CaseClass<C> delegate = null;

    protected static <C extends CaseType<C>, T> CaseField<C, T> field() {
        return new CaseField<>();
    }

    void init(CaseClass<C> delegate) {
        this.delegate = delegate;
    }

    public final <T> T get(CaseField<C, T> field) {
        return delegate.get(field);
    }

    @Override
    public String toString() {
        return delegate.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CaseType<?> caseType = (CaseType<?>) o;

        return delegate.equals(caseType.delegate);
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }
}
