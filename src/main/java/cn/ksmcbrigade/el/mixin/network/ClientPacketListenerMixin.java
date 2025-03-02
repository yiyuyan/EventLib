package cn.ksmcbrigade.el.mixin.network;

import cn.ksmcbrigade.el.events.entity.EntityDamageEvent;
import cn.ksmcbrigade.el.events.render.HurtAnimationEvent;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundDamageEventPacket;
import net.minecraft.network.protocol.game.ClientboundHurtAnimationPacket;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPacketListener.class)
public abstract class ClientPacketListenerMixin {

    @Shadow public abstract Connection getConnection();

    @Inject(method = "handleHurtAnimation",at = @At("HEAD"),cancellable = true)
    public void pushPack(ClientboundHurtAnimationPacket p_265581_, CallbackInfo ci){
        HurtAnimationEvent event = new HurtAnimationEvent(this.getConnection(),p_265581_);
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()) ci.cancel();
    }

    @Inject(method = "handleDamageEvent",at = @At("HEAD"))
    public void pushPack(ClientboundDamageEventPacket p_270800_, CallbackInfo ci){
        EntityDamageEvent event = new EntityDamageEvent(this.getConnection(),p_270800_);
        NeoForge.EVENT_BUS.post(event);
    }
}
