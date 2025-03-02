package cn.ksmcbrigade.el.mixin.block;

import cn.ksmcbrigade.el.events.block.BlockLightingEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class BlockStateBaseBaseMixin {

    @Shadow public abstract Block getBlock();

    /*@Inject(method = "getLightBlock",at = @At("RETURN"),cancellable = true)
    public void light(BlockGetter level, BlockPos pos, CallbackInfoReturnable<Integer> cir){
        BlockLightingEvent event = new BlockLightingEvent(cir.getReturnValue(),level.getBlockState(pos));
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.value);
    }
*/
    @Inject(method = "getLightEmission",at = @At("RETURN"),cancellable = true)
    public void light(CallbackInfoReturnable<Integer> cir){
        BlockLightingEvent event = new BlockLightingEvent(cir.getReturnValue(),this.getBlock().defaultBlockState());
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.value);
    }
}
