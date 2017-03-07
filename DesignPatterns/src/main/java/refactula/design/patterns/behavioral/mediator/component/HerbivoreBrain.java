package refactula.design.patterns.behavioral.mediator.component;

public class HerbivoreBrain extends BrainComponent {
    private final Strategy wonder = new Wonder();
    private final Strategy escape = new Escape();

    private Strategy activeStrategy = wonder;

    @Override
    public void update() {

    }

    private abstract class Strategy {

    }

    private class Wonder extends Strategy {

    }

    private class Escape extends Strategy {

    }
}
