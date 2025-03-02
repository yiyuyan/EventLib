package cn.ksmcbrigade.el.events.social;

import net.neoforged.bus.api.Event;

public class CanSendReportsEvent extends Event {
    public boolean value;

    public CanSendReportsEvent(boolean value){
        this.value = value;
    }
}
