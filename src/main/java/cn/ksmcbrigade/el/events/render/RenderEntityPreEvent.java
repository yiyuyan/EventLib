package cn.ksmcbrigade.el.events.render;

import net.minecraft.world.entity.Entity;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

public class RenderEntityPreEvent extends Event {
    public final Entity entity;

    public RenderEntityPreEvent(Entity entity){
        this.entity = entity;
    }
}
