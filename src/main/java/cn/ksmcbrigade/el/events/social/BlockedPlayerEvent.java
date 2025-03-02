package cn.ksmcbrigade.el.events.social;

import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

import java.util.UUID;

public class BlockedPlayerEvent extends Event {
    public final UUID player;
    public boolean value;

    public BlockedPlayerEvent(UUID player,boolean value){
        this.player = player;
        this.value = value;
    }
}
