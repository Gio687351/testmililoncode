package refactula.functional.case_class;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class CaseClassSupervisorPool {
    private static final ConcurrentMap<Class, CaseClassSupervisor> pool = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    static <C extends CaseType<C>> CaseClassSupervisor<C> forClass(Class<C> cls) {
        return pool.computeIfAbsent(cls, CaseClassSupervisor::create);
    }
}
