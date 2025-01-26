package cn.ksmcbrigade.el.events.misc;

import net.neoforged.bus.api.Event;

public class GetOptionValueEvent extends Event {
    public Object value;
    public final String cap;

    public GetOptionValueEvent(Object value,String optionCap){
        this.value = value;
        this.cap = optionCap;
    }
}
