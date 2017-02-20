package refactula.design.patterns.creational.factory;

public class InMemoryStorageTest extends AbstractStorageTest {
    @Override
    protected Storage createStorage() {
        return StorageFactory.createInMemory();
    }
}
