package cn.ksmcbrigade.el.mixin.render.gui;

import cn.ksmcbrigade.el.events.render.RenderScreenBackgroundEvent;
import cn.ksmcbrigade.el.events.render.RenderScreenBlurEvent;
import cn.ksmcbrigade.el.events.render.ScreenKeyInputEvent;
import cn.ksmcbrigade.el.events.render.ScreenTickEvent;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Screen.class)
public class ScreenMixin {
    @Inject(method = "tick",at = @At("HEAD"))
    public void tick(CallbackInfo ci){
        NeoForge.EVENT_BUS.post(new ScreenTickEvent((Screen) (Object)this));
    }

    @Inject(method = "keyPressed",at = @At("HEAD"), cancellable = true)
    public void tick(int p_96552_, int p_96553_, int p_96554_, CallbackInfoReturnable<Boolean> cir){
        ScreenKeyInputEvent event = new ScreenKeyInputEvent((Screen) (Object)this,p_96552_);
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()) cir.setReturnValue(event.result);
    }

    @Inject(method = "renderBackground",at = @At("HEAD"), cancellable = true)
    public void tick(GuiGraphics p_283688_, int p_296369_, int p_296477_, float p_294317_, CallbackInfo ci){
        RenderScreenBackgroundEvent event = new RenderScreenBackgroundEvent((Screen) (Object)this,p_283688_);
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()) ci.cancel();
    }

    @Inject(method = "renderBlurredBackground",at = @At("HEAD"), cancellable = true)
    public void tick(float p_330683_, CallbackInfo ci){
        RenderScreenBlurEvent event = new RenderScreenBlurEvent((Screen) (Object)this,p_330683_);
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()) ci.cancel();
    }
}
