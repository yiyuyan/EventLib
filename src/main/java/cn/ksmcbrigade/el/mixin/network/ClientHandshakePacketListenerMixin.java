package cn.ksmcbrigade.el.mixin.network;

import cn.ksmcbrigade.el.events.network.ClientDisconnectEvent;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.multiplayer.ClientHandshakePacketListenerImpl;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.login.ClientboundLoginDisconnectPacket;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientHandshakePacketListenerImpl.class)
public class ClientHandshakePacketListenerMixin {
    @Shadow @Final
    private Connection connection;

    @Inject(method = "handleDisconnect",at = @At("HEAD"),cancellable = true)
    public void pushPack(ClientboundLoginDisconnectPacket p_104553_, CallbackInfo ci){
        ClientDisconnectEvent event = new ClientDisconnectEvent(this.connection,p_104553_);
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()) ci.cancel();
    }
}
