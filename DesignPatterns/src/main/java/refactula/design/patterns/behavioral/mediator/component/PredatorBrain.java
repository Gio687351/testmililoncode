package refactula.design.patterns.behavioral.mediator.component;

public class PredatorBrain extends BrainComponent {
    private final Wonder wonder = new Wonder();
    private final Hunt hunt = new Hunt();

    private Strategy activeStrategy = wonder;

    @Override
    public void update() {

    }

    private abstract class Strategy {

    }

    private class Wonder extends Strategy {

    }

    private class Hunt extends Strategy {

    }
}
