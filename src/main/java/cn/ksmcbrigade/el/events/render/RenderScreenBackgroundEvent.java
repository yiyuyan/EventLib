package cn.ksmcbrigade.el.events.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

public class RenderScreenBackgroundEvent extends Event implements ICancellableEvent {
    public Screen screen;
    public Minecraft MC;
    public LocalPlayer player;

    public GuiGraphics guiGraphics;

    public RenderScreenBackgroundEvent(Screen screen, GuiGraphics guiGraphics){
        this.screen = screen;
        this.MC = Minecraft.getInstance();
        this.player = this.MC.player;
    }
}
