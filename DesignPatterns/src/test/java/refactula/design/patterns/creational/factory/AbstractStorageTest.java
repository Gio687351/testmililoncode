package refactula.design.patterns.creational.factory;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractStorageTest {

    private Storage storage;

    @Before
    public void setup() {
        storage = createStorage();
    }

    protected abstract Storage createStorage();

    @Test
    public void testRetriveWithoutStore() {
        assertNull(storage.retrieve("key"));
    }

    @Test
    public void testStoreAndRetrieve() {
        storage.store("fruit", "orange");
        assertEquals("orange", storage.retrieve("fruit"));
    }

    @Test
    public void testStoreOverwrite() {
        storage.store("vegetable", "carrot");
        storage.store("vegetable", "beetroot");
        assertEquals("beetroot", storage.retrieve("vegetable"));
    }

    @Test
    public void testMultipleRetrieve() {
        storage.store("game", "football");
        storage.retrieve("game");
        assertEquals("football", storage.retrieve("game"));
    }

    @Test
    public void testStoreMultipleValues() {
        storage.store("1", "one");
        storage.store("2", "two");
        storage.store("3", "three");
        assertEquals("one", storage.retrieve("1"));
        assertEquals("two", storage.retrieve("2"));
        assertEquals("three", storage.retrieve("3"));
    }

}