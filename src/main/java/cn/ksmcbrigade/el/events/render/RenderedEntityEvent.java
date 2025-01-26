package cn.ksmcbrigade.el.events.render;

import net.minecraft.world.entity.Entity;
import net.neoforged.bus.api.Event;

public class RenderedEntityEvent extends Event {
    public final Entity entity;

    public RenderedEntityEvent(Entity entity){
        this.entity = entity;
    }
}
