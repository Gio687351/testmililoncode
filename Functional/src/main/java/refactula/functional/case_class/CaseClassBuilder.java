package refactula.functional.case_class;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CaseClassBuilder<C extends CaseType<C>> {
    private final Class<C> cls;
    private final Map<CaseField, Optional<?>> valuesMap = new HashMap<>();

    CaseClassBuilder(Class<C> cls) {
        this.cls = cls;
    }

    public <T> CaseClassBuilder<C> set(CaseField<C, T> field, T value) {
        valuesMap.put(field, Optional.ofNullable(value));
        return this;
    }

    public C build() {
        CaseClass<C> caseClass = CaseClassSupervisorPool
                .forClass(cls)
                .create(ImmutableMap.copyOf(valuesMap));

        C instance = instantiate();
        instance.init(caseClass);
        return instance;
    }

    private C instantiate() {
        try {
            return cls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
