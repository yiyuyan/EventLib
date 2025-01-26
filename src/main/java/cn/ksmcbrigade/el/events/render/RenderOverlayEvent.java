package cn.ksmcbrigade.el.events.render;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

public class RenderOverlayEvent extends Event implements ICancellableEvent {
    public final ResourceLocation resourceLocation;

    public RenderOverlayEvent(ResourceLocation resourceLocation){
        this.resourceLocation =resourceLocation;
    }
}
