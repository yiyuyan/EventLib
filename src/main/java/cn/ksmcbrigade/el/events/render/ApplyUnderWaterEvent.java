package cn.ksmcbrigade.el.events.render;

import net.neoforged.bus.api.Event;

public class ApplyUnderWaterEvent extends Event {
    public boolean value;

    public ApplyUnderWaterEvent(boolean value){
        this.value = value;
    }
}
