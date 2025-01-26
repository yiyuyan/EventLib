package cn.ksmcbrigade.el.events.render;

import net.neoforged.bus.api.Event;

public class ZoomEvent extends Event {
    public double foV;

    public ZoomEvent(double foV){
        this.foV = foV;
    }
}
