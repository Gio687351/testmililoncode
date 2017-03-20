package refactula.functional.case_class;

import org.junit.Test;

import static org.junit.Assert.*;

public class CaseClassTest {

    public static final class Point extends CaseType<Point> {
        public static final CaseField<Point, Double> X = field();
        public static final CaseField<Point, Double> Y = field();
    }

    public static final class User extends CaseType<User> {
        public static final CaseField<User, String> NAME = field();
        public static final CaseField<User, Integer> AGE = field();
        public static final CaseField<User, String> PHONE = field();
    }

    @Test
    public void testEverythingAtOnce() {
        User user1 = CaseClass.builder(User.class)
                .set(User.NAME, "Patrick")
                .set(User.AGE, 25)
                .set(User.PHONE, "555175354")
                .build();

        User user2 = CaseClass.builder(User.class)
                .set(User.PHONE, "555175354")
                .set(User.AGE, 25)
                .set(User.NAME, "Patrick")
                .build();

        User user3 = CaseClass.builder(User.class)
                .set(User.PHONE, "75133555")
                .set(User.AGE, 36)
                .set(User.NAME, "Alice")
                .build();

        Point point = CaseClass.builder(Point.class)
                .set(Point.X, 15.54)
                .set(Point.Y, 7.64)
                .build();

        assertEquals(15.54, point.get(Point.X), 0.0001);
        assertEquals("Point{X=15.54, Y=7.64}", point.toString());
        assertEquals("Patrick", user1.get(User.NAME));
        assertEquals("User{NAME=Patrick, AGE=25, PHONE=555175354}", user1.toString());
        assertFalse(user1 == user2);
        assertEquals(user1, user2);
        assertFalse(user1 == user3);
        assertNotEquals(user1, user3);
    }

}