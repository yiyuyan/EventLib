package cn.ksmcbrigade.el.events.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

public class ScreenKeyInputEvent extends Event implements ICancellableEvent {
    public Screen screen;
    public Minecraft MC;
    public LocalPlayer player;
    public int keyCode;

    public boolean result = true;

    public ScreenKeyInputEvent(Screen screen,int keyCode){
        this.screen = screen;
        this.keyCode = keyCode;
        this.MC = Minecraft.getInstance();
        this.player = this.MC.player;
    }
}
