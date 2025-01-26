package cn.ksmcbrigade.el.events.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.bus.api.Event;

public class ScreenTickEvent extends Event {
    public Screen screen;
    public Minecraft MC;
    public LocalPlayer player;

    public ScreenTickEvent(Screen screen){
        this.screen = screen;
        this.MC = Minecraft.getInstance();
        this.player = this.MC.player;
    }
}
