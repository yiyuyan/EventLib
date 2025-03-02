package cn.ksmcbrigade.el.events.entity;

import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundDamageEventPacket;
import net.neoforged.bus.api.Event;

public class EntityDamageEvent extends Event {
    public final Connection connection;
    public final ClientboundDamageEventPacket packet;

    public EntityDamageEvent(Connection connection, ClientboundDamageEventPacket packet){
        this.connection = connection;
        this.packet = packet;
    }
}
