package refactula.design.patterns.factory;

public class InMemoryStorageTest extends AbstractStorageTest {
    @Override
    protected Storage createStorage() {
        return StorageFactory.createInMemory();
    }
}
