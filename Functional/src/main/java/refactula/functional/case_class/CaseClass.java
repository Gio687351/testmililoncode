package refactula.functional.case_class;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import java.util.Optional;

public final class CaseClass<C extends CaseType<C>> {
    private final CaseClassSupervisor<C> supervisor;
    private final ImmutableMap<CaseField<?, ?>, Optional<?>> valuesMap;

    public static <C extends CaseType<C>> CaseClassBuilder<C> builder(Class<C> cls) {
        return new CaseClassBuilder<>(cls);
    }

    private CaseClass(CaseClassSupervisor<C> supervisor, ImmutableMap<CaseField<?, ?>, Optional<?>> valuesMap) {
        this.supervisor = supervisor;
        this.valuesMap = valuesMap;
    }

    ImmutableMap<CaseField<?, ?>, Optional<?>> valuesMap() {
        return valuesMap;
    }

    @SuppressWarnings("unchecked")
    public <T> T get(CaseField<C, T> field) {
        Optional<T> optional = (Optional<T>) valuesMap.get(field);
        Preconditions.checkArgument(optional != null);
        return optional.orElse(null);
    }

    @Override
    public String toString() {
        return supervisor.toString(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CaseClass<?> caseClass = (CaseClass<?>) o;

        if (supervisor != null ? !supervisor.equals(caseClass.supervisor) : caseClass.supervisor != null) return false;
        return valuesMap != null ? valuesMap.equals(caseClass.valuesMap) : caseClass.valuesMap == null;
    }

    @Override
    public int hashCode() {
        int result = supervisor != null ? supervisor.hashCode() : 0;
        result = 31 * result + (valuesMap != null ? valuesMap.hashCode() : 0);
        return result;
    }
}
