package refactula.design.patterns.behavioral.mediator;

public class Geometry {

    public static float distanceSquared(float x1, float y1, float x2, float y2) {
        float dx = x1 - x2;
        float dy = y1 - y2;
        return dx * dx + dy * dy;
    }

    public static float distance(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt(distanceSquared(x1, y1, x2, y2));
    }

    public static float length(float x, float y) {
        return distance(0, 0, x, y);
    }
}
