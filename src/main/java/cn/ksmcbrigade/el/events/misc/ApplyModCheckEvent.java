package cn.ksmcbrigade.el.events.misc;

import net.minecraft.util.ModCheck;
import net.neoforged.bus.api.Event;

public class ApplyModCheckEvent extends Event {
    public ModCheck value;

    public ApplyModCheckEvent(ModCheck value){
        this.value = value;
    }
}
