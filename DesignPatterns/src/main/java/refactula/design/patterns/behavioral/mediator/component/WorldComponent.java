package refactula.design.patterns.behavioral.mediator.component;

import com.google.common.base.Preconditions;
import refactula.design.patterns.behavioral.mediator.World;

import java.util.Objects;

public class WorldComponent extends CreatureComponent {
    private World world = null;

    public void onAdded(World world) {
        Preconditions.checkState(this.world == null);
        this.world = world;
    }

    public void onRemoved(World world) {
        if (this.world == null) {
            return;
        }
        Preconditions.checkState(Objects.equals(this.world, world));
        this.world = null;
    }

    public World getWorld() {
        return world;
    }

    public boolean isActive() {
        return world != null;
    }
}
