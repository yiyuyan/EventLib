package cn.ksmcbrigade.el.events.block;

import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.Event;

public class BlockLightingEvent extends Event {
    public int value;
    public final BlockState block;

    public BlockLightingEvent(int light, BlockState block){
        this.value = light;
        this.block = block;
    }
}
