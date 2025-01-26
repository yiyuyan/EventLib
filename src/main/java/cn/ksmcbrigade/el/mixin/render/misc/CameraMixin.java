package cn.ksmcbrigade.el.mixin.render.misc;

import cn.ksmcbrigade.el.events.render.FluidTypeInCameraEvent;
import net.minecraft.client.Camera;
import net.minecraft.world.level.material.FogType;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Camera.class)
public class CameraMixin {
    @Inject(method = "getFluidInCamera",at = @At("RETURN"),cancellable = true)
    public void get(CallbackInfoReturnable<FogType> cir){
        FluidTypeInCameraEvent event = new FluidTypeInCameraEvent(cir.getReturnValue());
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.value);
    }
}
