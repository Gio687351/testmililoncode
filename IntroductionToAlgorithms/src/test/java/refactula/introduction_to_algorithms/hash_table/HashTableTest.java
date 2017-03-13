package refactula.introduction_to_algorithms.hash_table;

import org.junit.Test;

import java.util.HashSet;
import java.util.Random;

import static org.junit.Assert.*;

public class HashTableTest {

    private static final int OPERATION_INSERT = 0;
    private static final int OPERATION_CONTAINS = 1;
    private static final int OPERATION_REMOVE = 2;

    @Test
    public void test() {
        Random random = new Random("HashTable".hashCode());
        int samples = 10000;
        for (int i = 0; i < samples; i++) {
            HashTable<Integer> hashTable = new HashTable<>();
            HashSet<Integer> hashSet = new HashSet<>();
            int operations = 10 + random.nextInt(990);
            int maxElement = 10 + random.nextInt(100);
            for (int j = 0; j < operations; j++) {
                switch (random.nextInt(3)) {
                    case OPERATION_INSERT: {
                        Integer element = random.nextInt(maxElement);
                        boolean expected = hashSet.add(element);
                        boolean actual = hashTable.insert(element);
                        assertEquals(expected, actual);
                    }
                    break;

                    case OPERATION_CONTAINS: {
                        Integer element = random.nextInt(maxElement);
                        boolean expected = hashSet.contains(element);
                        boolean actual = hashTable.contains(element);
                        assertEquals(expected, actual);
                    }
                    break;

                    case OPERATION_REMOVE: {
                        Integer element = random.nextInt(maxElement);
                        boolean expected = hashSet.remove(element);
                        boolean actual = hashTable.remove(element);
                        assertEquals(expected, actual);
                    }
                    break;
                }
            }
        }
    }

}