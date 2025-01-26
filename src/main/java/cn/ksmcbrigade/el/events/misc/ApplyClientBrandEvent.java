package cn.ksmcbrigade.el.events.misc;

import net.neoforged.bus.api.Event;

public class ApplyClientBrandEvent extends Event {
    public String value;

    public ApplyClientBrandEvent(String value){
        this.value = value;
    }
}
