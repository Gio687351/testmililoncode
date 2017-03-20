package refactula.functional.case_class;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.lang.reflect.Field;
import java.util.Optional;

final class CaseClassSupervisor<C extends CaseType<C>> {
    private final Class<C> cls;
    private final ImmutableSet<CaseField<?, ?>> fields;
    private final ImmutableMap<CaseField<?, ?>, String> fieldNames;

    private CaseClassSupervisor(Class<C> cls, ImmutableSet<CaseField<?, ?>> fields, ImmutableMap<CaseField<?, ?>, String> fieldNames) {
        this.cls = cls;
        this.fields = fields;
        this.fieldNames = fieldNames;
    }

    static <C extends CaseType<C>> CaseClassSupervisor<C> create(Class<C> cls) {
        ImmutableSet.Builder<CaseField<?, ?>> fields = ImmutableSet.builder();
        ImmutableMap.Builder<CaseField<?, ?>, String> fieldNames = ImmutableMap.builder();
        for (Field field : cls.getDeclaredFields()) {
            if (field.getType().equals(CaseField.class)) {
                try {
                    CaseField<?, ?> caseField = (CaseField<?, ?>) field.get(null);
                    fields.add(caseField);
                    fieldNames.put(caseField, field.getName());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return new CaseClassSupervisor<>(cls, fields.build(), fieldNames.build());
    }

    CaseClass<C> create(ImmutableMap<CaseField, Optional<?>> valuesMap) {
        Preconditions.checkArgument(fields.containsAll(valuesMap.keySet()));
        ImmutableMap.Builder<CaseField<?, ?>, Optional<?>> newValues = ImmutableMap.builder();
        for (CaseField<?, ?> field : fields) {
            Optional<?> optional = valuesMap.get(field);
            newValues.put(field, optional != null ? optional : Optional.empty());
        }
        return new CaseClass<>(this, newValues.build());
    }

    String toString(CaseClass<C> caseClass) {
        ToStringHelper helper = MoreObjects.toStringHelper(cls);
        for (CaseField<?, ?> field : fields) {
            helper.add(fieldNames.get(field), caseClass.valuesMap().get(field).orElse(null));
        }
        return helper.toString();
    }
}
