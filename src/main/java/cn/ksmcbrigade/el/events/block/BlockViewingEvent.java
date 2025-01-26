package cn.ksmcbrigade.el.events.block;

import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.Event;

public class BlockViewingEvent extends Event {
    public boolean value;
    public final BlockState block;

    public BlockViewingEvent(boolean light, BlockState block){
        this.value = light;
        this.block = block;
    }
}
