package refactula.design.patterns;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AbstractFactoryTest {

    @Test
    public void testEnglishGreeter() {
        UniversalGreeter greeter = new UniversalGreeter(PersonalizedEnglishGreeterFactory.INSTANCE);
        assertEquals("Hello, Sebastian!", greeter.greet("Sebastian"));
        assertEquals("Hello, Paul!", greeter.greet("Paul"));
        assertEquals("Hello, Amanda!", greeter.greet("Amanda"));
    }

    @Test
    public void testFrenchGreeter() {
        UniversalGreeter greeter = new UniversalGreeter(PersonalizedFrenchGreeterFactory.INSTANCE);
        assertEquals("Bonjour, Sebastian!", greeter.greet("Sebastian"));
        assertEquals("Bonjour, Paul!", greeter.greet("Paul"));
        assertEquals("Bonjour, Amanda!", greeter.greet("Amanda"));
    }

    interface PersonalizedGreeter {
        String greet();
    }

    static class UniversalGreeter {
        private final PersonalizedGreeterFactory personalizedGreeterFactory;

        UniversalGreeter(PersonalizedGreeterFactory personalizedGreeterFactory) {
            this.personalizedGreeterFactory = personalizedGreeterFactory;
        }

        public String greet(String name) {
            return personalizedGreeterFactory.produce(new Name(name)).greet();
        }
    }

    static final class Name {
        private final String value;

        private Name(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    interface PersonalizedGreeterFactory extends AbstractFactory<Name, PersonalizedGreeter> {
        @Override
        PersonalizedGreeter produce(Name key);
    }

    enum PersonalizedEnglishGreeterFactory implements PersonalizedGreeterFactory {
        INSTANCE;

        @Override
        public PersonalizedGreeter produce(Name name) {
            return () -> "Hello, " + name + "!";
        }
    }

    enum PersonalizedFrenchGreeterFactory implements PersonalizedGreeterFactory {
        INSTANCE;

        @Override
        public PersonalizedGreeter produce(Name name) {
            return () -> "Bonjour, " + name + "!";
        }
    }

}