package cn.ksmcbrigade.el.events.entity;

import net.neoforged.bus.api.Event;

public class ApplyEntityInternetRangeEvent extends Event {
    public double value;

    public ApplyEntityInternetRangeEvent(double value){
        this.value = value;
    }
}
