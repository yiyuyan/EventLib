package cn.ksmcbrigade.el.events.render;

import net.minecraft.world.entity.Entity;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

public class RenderEntityEvent extends Event implements ICancellableEvent {
    public final Entity entity;

    public RenderEntityEvent(Entity entity){
        this.entity = entity;
    }
}
