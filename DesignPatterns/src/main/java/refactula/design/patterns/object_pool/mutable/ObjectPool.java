package refactula.design.patterns.object_pool.mutable;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ObjectPool<T> {
    private final InstanceManager<T> instanceManager;
    private final int maxSize;

    private final AtomicInteger approximateSize = new AtomicInteger(0);
    private final Queue<T> queue = new ConcurrentLinkedQueue<>();

    public ObjectPool(int maxSize, InstanceManager<T> instanceManager) {
        this.instanceManager = instanceManager;
        this.maxSize = maxSize;
    }

    public T acquire() {
        T obj = queue.poll();
        if (obj == null) {
            obj = instanceManager.createInstance();
        } else {
            approximateSize.decrementAndGet();
            instanceManager.setUp(obj);
        }
        return obj;
    }

    public void release(T instance) {
        instanceManager.cleanUp(instance);
        if (approximateSize.incrementAndGet() <= maxSize) {
            queue.add(instance);
        } else {
            approximateSize.decrementAndGet();
        }
    }
}
