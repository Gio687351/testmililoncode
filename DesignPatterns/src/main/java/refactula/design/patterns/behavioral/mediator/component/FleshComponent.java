package refactula.design.patterns.behavioral.mediator.component;

import refactula.design.patterns.behavioral.mediator.FleshType;

public class FleshComponent extends CreatureComponent {
    private final FleshType fleshType;

    public FleshComponent(FleshType fleshType) {
        this.fleshType = fleshType;
    }

    public FleshType getFleshType() {
        return fleshType;
    }
}
