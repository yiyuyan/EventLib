package cn.ksmcbrigade.el.mixin.entity;

import cn.ksmcbrigade.el.events.entity.HandleConfusionTransitionEffectEvent;
import cn.ksmcbrigade.el.events.entity.LocalPlayerClientSideCloseContainerEvent;
import cn.ksmcbrigade.el.events.entity.LocalPlayerCloseContainerEvent;
import cn.ksmcbrigade.el.events.entity.SwingEvent;
import cn.ksmcbrigade.el.events.render.ApplyUnderWaterEvent;
import cn.ksmcbrigade.el.events.render.ApplyWaterVisionEvent;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LocalPlayer.class)
public class LocalPlayerMixin {
    @Inject(method = "swing",at = @At("HEAD"),cancellable = true)
    public void swing(InteractionHand p_108660_, CallbackInfo ci){
        SwingEvent event = new SwingEvent();
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()) ci.cancel();
    }

    @Inject(method = "closeContainer",at = @At("HEAD"),cancellable = true)
    public void closeContainer(CallbackInfo ci){
        LocalPlayerCloseContainerEvent event = new LocalPlayerCloseContainerEvent();
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()) ci.cancel();
    }

    @Inject(method = "closeContainer",at = @At("HEAD"),cancellable = true)
    public void closeContainerClient(CallbackInfo ci){
        LocalPlayerClientSideCloseContainerEvent event = new LocalPlayerClientSideCloseContainerEvent();
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()) ci.cancel();
    }

    @Inject(method = "handleConfusionTransitionEffect",at = @At("HEAD"),cancellable = true)
    public void handleConfusionTransitionEffect(CallbackInfo ci){
        HandleConfusionTransitionEffectEvent event = new HandleConfusionTransitionEffectEvent();
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()) ci.cancel();
    }

    @Inject(method = "getWaterVision",at = @At("RETURN"),cancellable = true)
    public void waterVision(CallbackInfoReturnable<Float> cir){
        ApplyWaterVisionEvent event = new ApplyWaterVisionEvent(cir.getReturnValue());
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.value);
    }

    @Inject(method = "isUnderWater",at = @At("RETURN"),cancellable = true)
    public void under_water(CallbackInfoReturnable<Boolean> cir){
        ApplyUnderWaterEvent event = new ApplyUnderWaterEvent(cir.getReturnValue());
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.value);
    }
}
