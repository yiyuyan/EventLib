package cn.ksmcbrigade.el.events.block;

import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

public class StopDestroyBlockEvent extends Event implements ICancellableEvent {
    public final MultiPlayerGameMode instance;

    public StopDestroyBlockEvent(MultiPlayerGameMode instance){
        this.instance = instance;
    }
}
