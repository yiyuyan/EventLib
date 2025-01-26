package cn.ksmcbrigade.el.events.network;

import net.minecraft.network.protocol.Packet;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

public class PacketEvent extends Event implements ICancellableEvent {
    public Packet<?> packet;

    public PacketEvent(Packet<?> packet){
        this.packet = packet;
    }
}
