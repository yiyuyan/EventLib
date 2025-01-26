package cn.ksmcbrigade.el.events.render;

import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.Event;

public class RenderBlockEvent extends Event {
    public final BlockState block;
    public boolean render;

    public RenderBlockEvent(BlockState block,boolean render){
        this.block = block;
        this.render = render;
    }
}
