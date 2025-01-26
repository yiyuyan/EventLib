package cn.ksmcbrigade.el.mixin.block;

import cn.ksmcbrigade.el.events.block.BlockLightingEvent;
import cn.ksmcbrigade.el.events.block.BlockShapeEvent;
import cn.ksmcbrigade.el.events.render.RenderBlockEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.class)
public class BlockStateBaseMixin {
    @Inject(method = "getShape",at = @At("RETURN"),cancellable = true)
    public void shape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_, CallbackInfoReturnable<VoxelShape> cir){
        BlockShapeEvent event = new BlockShapeEvent(cir.getReturnValue(),p_60555_);
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.value);
    }

    @Inject(method = "skipRendering",at = @At("RETURN"),cancellable = true)
    public void shape(BlockState p_60532_, BlockState p_60533_, Direction p_60534_, CallbackInfoReturnable<Boolean> cir){
        RenderBlockEvent event = new RenderBlockEvent(p_60532_,!cir.getReturnValue());
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(!event.render);
    }

    @Inject(method = "getLightBlock",at = @At("RETURN"),cancellable = true)
    public void light(BlockState state, BlockGetter level, BlockPos pos, CallbackInfoReturnable<Integer> cir){
        BlockLightingEvent event = new BlockLightingEvent(cir.getReturnValue(),state);
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.value);
    }
}
