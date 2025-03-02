package cn.ksmcbrigade.el.mixin.network;

import cn.ksmcbrigade.el.events.network.ResourcePackPopEvent;
import cn.ksmcbrigade.el.events.network.ResourcePackPushEvent;
import net.minecraft.client.multiplayer.ClientCommonPacketListenerImpl;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.common.ClientboundResourcePackPopPacket;
import net.minecraft.network.protocol.common.ClientboundResourcePackPushPacket;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientCommonPacketListenerImpl.class)
public class ClientboundPacketListenerMixin {
    @Shadow @Final protected Connection connection;

    @Inject(method = "handleResourcePackPush",at = @At("HEAD"),cancellable = true)
    public void pushPack(ClientboundResourcePackPushPacket p_314606_, CallbackInfo ci){
        ResourcePackPushEvent event = new ResourcePackPushEvent(this.connection,p_314606_);
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()) ci.cancel();
    }

    @Inject(method = "handleResourcePackPop",at = @At("HEAD"),cancellable = true)
    public void popPack(ClientboundResourcePackPopPacket p_314537_, CallbackInfo ci){
        ResourcePackPopEvent event = new ResourcePackPopEvent(this.connection,p_314537_);
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()) ci.cancel();
    }
}
