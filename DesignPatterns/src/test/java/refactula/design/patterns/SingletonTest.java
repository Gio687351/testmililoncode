package refactula.design.patterns;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingletonTest {

    private final Singleton<CompanionCube> singleton = () -> CompanionCube.INSTANCE;

    @Test
    public void shouldAccessSingleton() {
        assertEquals("The cake is a lie", singleton.getInstance().tellMeTheSecret());
    }

    private enum CompanionCube {
        INSTANCE;

        public String tellMeTheSecret() {
            return "The cake is a lie";
        }
    }

}