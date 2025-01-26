package cn.ksmcbrigade.el.events.render;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.Event;

public class ApplyEyeInFluidEvent extends Event {
    public boolean value;
    public TagKey<Fluid> fluidTagKey;

    public ApplyEyeInFluidEvent(boolean value, TagKey<Fluid> fluidTagKey){
        this.value = value;
        this.fluidTagKey = fluidTagKey;
    }
}
