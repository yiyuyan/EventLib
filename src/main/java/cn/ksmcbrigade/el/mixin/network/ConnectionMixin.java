package cn.ksmcbrigade.el.mixin.network;

import cn.ksmcbrigade.el.events.network.PacketEvent;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import net.minecraft.network.Connection;
import net.minecraft.network.PacketSendListener;
import net.minecraft.network.protocol.Packet;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Connection.class)
public class ConnectionMixin {
    @Shadow private Channel channel;

    @Inject(method = "doSendPacket",at = @At("HEAD"),cancellable = true)
    public void send(Packet<?> p_243260_, PacketSendListener p_243290_, boolean p_294125_, CallbackInfo ci){
        PacketEvent event = new PacketEvent(p_243260_);
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()){
            ci.cancel();
        }
        else if(event.packet!=p_243260_){
            ChannelFuture channelfuture = p_294125_ ? this.channel.writeAndFlush(event.packet) : this.channel.write(event.packet);
            if (p_243290_ != null) {
                channelfuture.addListener(p_243167_ -> {
                    if (p_243167_.isSuccess()) {
                        p_243290_.onSuccess();
                    } else {
                        Packet<?> packet = p_243290_.onFailure();
                        if (packet != null) {
                            ChannelFuture channelfuture1 = this.channel.writeAndFlush(packet);
                            channelfuture1.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
                        }
                    }
                });
            }
            ci.cancel();
        }
    }
}
