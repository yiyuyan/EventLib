package cn.ksmcbrigade.el.events.block;

import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

public class StartDestroyBlockEvent extends Event implements ICancellableEvent {
    public boolean value = true;
    public final MultiPlayerGameMode instance;

    public StartDestroyBlockEvent(MultiPlayerGameMode instance){
        this.instance = instance;
    }
}
