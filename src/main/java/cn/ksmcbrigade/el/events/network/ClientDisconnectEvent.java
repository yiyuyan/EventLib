package cn.ksmcbrigade.el.events.network;

import net.minecraft.network.Connection;
import net.minecraft.network.protocol.login.ClientboundLoginDisconnectPacket;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

public class ClientDisconnectEvent extends Event implements ICancellableEvent {
    public final Connection connection;
    public final ClientboundLoginDisconnectPacket packet;

    public ClientDisconnectEvent(Connection connection, ClientboundLoginDisconnectPacket packet){
        this.connection = connection;
        this.packet = packet;
    }
}
