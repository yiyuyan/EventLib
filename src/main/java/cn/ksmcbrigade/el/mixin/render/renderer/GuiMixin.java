package cn.ksmcbrigade.el.mixin.render.renderer;

import cn.ksmcbrigade.el.events.render.RenderGameMix;
import cn.ksmcbrigade.el.events.render.RenderOverlayEvent;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class GuiMixin {
    @Inject(method = "render",at = @At("HEAD"))
    public void render(GuiGraphics p_282884_, DeltaTracker p_348630_, CallbackInfo ci){
        NeoForge.EVENT_BUS.post(new RenderGameMix(p_282884_));
    }

    @Inject(method = "renderTextureOverlay",at = @At("HEAD"), cancellable = true)
    public void renderTexOverlay(GuiGraphics p_282304_, ResourceLocation p_281622_, float p_281504_, CallbackInfo ci){
        RenderOverlayEvent event = new RenderOverlayEvent(p_281622_);
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()){
            ci.cancel();
        }
    }
}
