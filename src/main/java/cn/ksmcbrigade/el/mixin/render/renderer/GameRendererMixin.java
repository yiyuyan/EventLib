package cn.ksmcbrigade.el.mixin.render.renderer;

import cn.ksmcbrigade.el.events.render.ZoomEvent;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.GameRenderer;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Inject(method = "getFov",at = @At("RETURN"),cancellable = true)
    public void fov(Camera p_109142_, float p_109143_, boolean p_109144_, CallbackInfoReturnable<Double> cir){
        ZoomEvent event = new ZoomEvent(cir.getReturnValue());
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.foV);
    }
}
