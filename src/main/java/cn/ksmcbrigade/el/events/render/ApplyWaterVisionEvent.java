package cn.ksmcbrigade.el.events.render;

import net.neoforged.bus.api.Event;

public class ApplyWaterVisionEvent extends Event {
    public float value;

    public ApplyWaterVisionEvent(float value){
        this.value = value;
    }
}
