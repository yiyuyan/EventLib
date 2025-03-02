package cn.ksmcbrigade.el.events.network;

import net.minecraft.network.Connection;
import net.minecraft.network.protocol.common.ClientboundResourcePackPushPacket;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

public class ResourcePackPushEvent extends Event implements ICancellableEvent {
    public final Connection connection;
    public final ClientboundResourcePackPushPacket packet;

    public ResourcePackPushEvent(Connection connection,ClientboundResourcePackPushPacket packet){
        this.connection = connection;
        this.packet = packet;
    }
}
