package cn.ksmcbrigade.el.events.block;

import net.neoforged.bus.api.Event;

public class ApplyBlockInternetRangeEvent extends Event {
    public double value;

    public ApplyBlockInternetRangeEvent(double value){
        this.value = value;
    }
}
