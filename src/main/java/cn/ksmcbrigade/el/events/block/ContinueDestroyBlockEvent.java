package cn.ksmcbrigade.el.events.block;

import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

public class ContinueDestroyBlockEvent extends Event implements ICancellableEvent {
    public boolean value = true;
    public final BlockPos pos;
    public final Direction direction;
    public final MultiPlayerGameMode instance;

    public ContinueDestroyBlockEvent(MultiPlayerGameMode instance, BlockPos pos, Direction direction){
        this.instance = instance;
        this.pos = pos;
        this.direction = direction;
    }
}
