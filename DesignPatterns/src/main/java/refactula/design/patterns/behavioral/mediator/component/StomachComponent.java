package refactula.design.patterns.behavioral.mediator.component;

import refactula.design.patterns.behavioral.mediator.Creature;

public abstract class StomachComponent extends CreatureComponent {
    public abstract void onCollide(Creature creature);
}
