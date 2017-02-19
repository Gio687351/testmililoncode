package refactula.design.patterns;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingletonTest {

    @Test
    public void shouldAccessSingleton() {
        assertEquals("The cake is a lie", Singleton.INSTANCE.tellMeTheSecret());
    }

}