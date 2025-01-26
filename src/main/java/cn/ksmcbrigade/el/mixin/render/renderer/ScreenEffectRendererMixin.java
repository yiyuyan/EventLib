package cn.ksmcbrigade.el.mixin.render.renderer;

import cn.ksmcbrigade.el.events.render.RenderFireEvent;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ScreenEffectRenderer.class)
public class ScreenEffectRendererMixin {
    @Inject(method = "renderFire",at = @At("HEAD"),cancellable = true)
    private static void render(Minecraft p_110729_, PoseStack p_110730_, CallbackInfo ci){
        RenderFireEvent event = new RenderFireEvent();
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()){
            ci.cancel();
        }
    }
}
