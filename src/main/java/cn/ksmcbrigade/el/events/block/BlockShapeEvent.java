package cn.ksmcbrigade.el.events.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.bus.api.Event;

public class BlockShapeEvent extends Event {
    public VoxelShape value;
    public final BlockState block;

    public BlockShapeEvent(VoxelShape value,BlockState block){
        this.value = value;
        this.block = block;
    }
}
