package cn.ksmcbrigade.el;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickType;

public class InventoryUtil {
    public static boolean moveTo(int containerId, Player player, int from, int to){
        Minecraft MC = Minecraft.getInstance();
        if(MC.gameMode==null) return false;
        MC.gameMode.handleInventoryMouseClick(containerId, from, 0, ClickType.PICKUP, player);
        MC.gameMode.handleInventoryMouseClick(containerId, to, 0, ClickType.PICKUP, player);
        MC.gameMode.handleInventoryMouseClick(containerId, from, 0, ClickType.PICKUP, player);
        return true;
    }

    public static boolean moveTo(int from, int to){
        Minecraft MC = Minecraft.getInstance();
        if(MC.gameMode==null || MC.player==null) return false;
        return moveTo(MC.player.inventoryMenu.containerId,MC.player,from,to);
    }
}
