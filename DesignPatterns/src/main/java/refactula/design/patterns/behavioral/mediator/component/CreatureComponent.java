package refactula.design.patterns.behavioral.mediator.component;

import com.google.common.base.Preconditions;
import refactula.design.patterns.behavioral.mediator.CreatureMediator;

public class CreatureComponent {
    private CreatureMediator mediator;

    public void setMediator(CreatureMediator mediator) {
        this.mediator = mediator;
    }

    protected final CreatureMediator mediator() {
        Preconditions.checkNotNull(mediator);
        return mediator;
    }
}
