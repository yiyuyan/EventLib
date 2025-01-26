package cn.ksmcbrigade.el.events.render;

import net.minecraft.client.gui.GuiGraphics;
import net.neoforged.bus.api.Event;

public class RenderGameMix extends Event {

    public final GuiGraphics drawContext;

    public RenderGameMix(GuiGraphics drawContext){
        this.drawContext = drawContext;
    }
}
