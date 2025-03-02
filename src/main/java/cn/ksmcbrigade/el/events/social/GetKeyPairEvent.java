package cn.ksmcbrigade.el.events.social;

import com.mojang.authlib.yggdrasil.response.KeyPairResponse;
import net.neoforged.bus.api.Event;

public class GetKeyPairEvent extends Event {
    public KeyPairResponse value;

    public GetKeyPairEvent(KeyPairResponse value){
        this.value = value;
    }
}
