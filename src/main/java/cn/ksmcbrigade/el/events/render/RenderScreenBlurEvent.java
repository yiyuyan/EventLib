package cn.ksmcbrigade.el.events.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

public class RenderScreenBlurEvent extends Event implements ICancellableEvent {
    public Screen screen;
    public Minecraft MC;
    public LocalPlayer player;

    public float p_330683_;

    public RenderScreenBlurEvent(Screen screen, float p_330683_){
        this.screen = screen;
        this.MC = Minecraft.getInstance();
        this.player = this.MC.player;
        this.p_330683_ = p_330683_;
    }
}
