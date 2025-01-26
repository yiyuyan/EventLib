package cn.ksmcbrigade.el;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(value = "el")
public class EventLib {

    public EventLib(IEventBus modEventBus, ModContainer modContainer){
        System.out.println("Hello Event Lib.");
    }
}
