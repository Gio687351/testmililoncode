package refactula.design.patterns.creational.object_pool.mutable;

public interface InstanceManager<T> {

    /**
     * Create a new instance of the object.
     */
    T createInstance();

    /**
     * Clean up the instance before returning it into the pool during release() invocation.
     * Is might be a good place to remove all stale references from the object in order to avoid memory leaking.
     */
    void cleanUp(T instance);

    /**
     * Get ready the instance for reuse by putting it into valid initial state.
     * Is called before returning the object from acquire() method.
     */
    void setUp(T instance);

}
