package refactula.design.patterns.behavioral.mediator.component;

import refactula.design.patterns.behavioral.mediator.Creature;
import refactula.design.patterns.behavioral.mediator.FleshType;

public class PredatorStomach extends StomachComponent {
    @Override
    public void onCollide(Creature creature) {
        if (creature.getFleshType() == FleshType.RICH_MEAT) {
            creature.onEaten();
        }
    }
}
