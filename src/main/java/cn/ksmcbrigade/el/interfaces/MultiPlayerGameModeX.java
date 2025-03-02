package cn.ksmcbrigade.el.interfaces;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.prediction.PredictiveAction;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.BlockHitResult;

public interface MultiPlayerGameModeX {
    Minecraft getMinecraft();
    ClientPacketListener getConnectionListener();

    BlockPos getDestroyPos();
    ItemStack getDestroyItem();

    float getDestroyProgress();
    float getDestroyTicks();
    int getDestroyDelay();
    boolean isDestroying();

    int getCarriedIndex();

    void setDestroyPos(BlockPos pos);
    void setDestroyItem(ItemStack stack);

    void setDestroyProgress(float progress);
    void setDestroyTicks(float ticks);
    void setDestroyDelay(int delay);
    void setDestroying(boolean destroying);

    void startPredictionI(ClientLevel p_233730_, PredictiveAction p_233731_);
    boolean sameDestroyTargetI(BlockPos p_105282_);
    void ensureHasSentCarriedItemI();
    InteractionResult performUseItemOnI(LocalPlayer p_233747_, InteractionHand p_233748_, BlockHitResult p_233749_);
}
