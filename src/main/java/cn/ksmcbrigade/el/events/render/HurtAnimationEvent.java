package cn.ksmcbrigade.el.events.render;

import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundHurtAnimationPacket;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

public class HurtAnimationEvent extends Event implements ICancellableEvent {
    public final Connection connection;
    public final ClientboundHurtAnimationPacket packet;

    public HurtAnimationEvent(Connection connection, ClientboundHurtAnimationPacket packet){
        this.connection = connection;
        this.packet = packet;
    }
}
