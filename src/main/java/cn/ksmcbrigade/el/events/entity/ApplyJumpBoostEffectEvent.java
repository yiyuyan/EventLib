package cn.ksmcbrigade.el.events.entity;

import net.neoforged.bus.api.Event;

public class ApplyJumpBoostEffectEvent extends Event {
    public float value;

    public ApplyJumpBoostEffectEvent(float timer){
        this.value = timer;
    }
}
