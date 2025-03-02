package cn.ksmcbrigade.el.events.network;

import net.minecraft.network.Connection;
import net.minecraft.network.protocol.common.ClientboundResourcePackPopPacket;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

public class ResourcePackPopEvent extends Event implements ICancellableEvent {
    public final Connection connection;
    public final ClientboundResourcePackPopPacket packet;

    public ResourcePackPopEvent(Connection connection, ClientboundResourcePackPopPacket packet){
        this.connection = connection;
        this.packet = packet;
    }
}
