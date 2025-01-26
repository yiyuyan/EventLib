package cn.ksmcbrigade.el.events.entity;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.Event;

public class CheckHasEffectEvent extends Event {
    public final Holder<MobEffect> effect;
    public boolean has;

    public CheckHasEffectEvent(Holder<MobEffect> effect,boolean has){
        this.effect = effect;
        this.has = has;
    }
}
