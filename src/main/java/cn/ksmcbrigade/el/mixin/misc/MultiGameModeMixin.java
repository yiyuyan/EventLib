package cn.ksmcbrigade.el.mixin.misc;

import cn.ksmcbrigade.el.events.block.ContinueDestroyBlockEvent;
import cn.ksmcbrigade.el.events.block.StartDestroyBlockEvent;
import cn.ksmcbrigade.el.events.block.StopDestroyBlockEvent;
import cn.ksmcbrigade.el.interfaces.MultiPlayerGameModeX;
import cn.ksmcbrigade.el.interfaces.Self;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.multiplayer.prediction.PredictiveAction;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MultiPlayerGameMode.class)
public abstract class MultiGameModeMixin implements Self<MultiPlayerGameMode>, MultiPlayerGameModeX {
    @Shadow @Final private Minecraft minecraft;

    @Shadow @Final private ClientPacketListener connection;

    @Shadow private BlockPos destroyBlockPos;

    @Shadow private ItemStack destroyingItem;

    @Shadow private float destroyProgress;

    @Shadow private float destroyTicks;

    @Shadow private int destroyDelay;

    @Shadow private boolean isDestroying;

    @Shadow private int carriedIndex;

    @Shadow protected abstract InteractionResult performUseItemOn(LocalPlayer p_233747_, InteractionHand p_233748_, BlockHitResult p_233749_);

    @Shadow protected abstract void startPrediction(ClientLevel p_233730_, PredictiveAction p_233731_);

    @Shadow protected abstract boolean sameDestroyTarget(BlockPos p_105282_);

    @Shadow protected abstract void ensureHasSentCarriedItem();

    @Inject(method = "startDestroyBlock",at = @At("HEAD"),cancellable = true)
    public void start(BlockPos p_105270_, Direction p_105271_, CallbackInfoReturnable<Boolean> cir){
        StartDestroyBlockEvent event = new StartDestroyBlockEvent(this.getSelf());
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()){
            cir.setReturnValue(event.value);
            cir.cancel();
        }
    }

    @Inject(method = "continueDestroyBlock",at = @At("HEAD"),cancellable = true)
    public void continueDestroy(BlockPos p_105270_, Direction p_105271_, CallbackInfoReturnable<Boolean> cir){
        ContinueDestroyBlockEvent event = new ContinueDestroyBlockEvent(this.getSelf(),p_105270_,p_105271_);
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()){
            cir.setReturnValue(event.value);
            cir.cancel();
        }
    }

    @Inject(method = "stopDestroyBlock",at = @At("HEAD"),cancellable = true)
    public void continueDestroy(CallbackInfo ci){
        StopDestroyBlockEvent event = new StopDestroyBlockEvent(this.getSelf());
        NeoForge.EVENT_BUS.post(event);
        if(event.isCanceled()) ci.cancel();
    }

    @Override
    public Minecraft getMinecraft() {
        return this.minecraft;
    }

    @Override
    public ClientPacketListener getConnectionListener() {
        return this.connection;
    }

    @Override
    public BlockPos getDestroyPos() {
        return this.destroyBlockPos;
    }

    @Override
    public ItemStack getDestroyItem() {
        return this.destroyingItem;
    }

    @Override
    public float getDestroyProgress() {
        return this.destroyProgress;
    }

    @Override
    public float getDestroyTicks() {
        return this.destroyTicks;
    }

    @Override
    public int getDestroyDelay() {
        return this.destroyDelay;
    }

    @Override
    public boolean isDestroying() {
        return this.isDestroying;
    }

    @Override
    public int getCarriedIndex() {
        return this.carriedIndex;
    }

    @Override
    public void setDestroyPos(BlockPos pos) {
        this.destroyBlockPos = pos;
    }

    @Override
    public void setDestroyItem(ItemStack stack) {
        this.destroyingItem = stack;
    }

    @Override
    public void setDestroyProgress(float progress) {
        this.destroyProgress = progress;
    }

    @Override
    public void setDestroyTicks(float ticks) {
        this.destroyTicks = ticks;
    }

    @Override
    public void setDestroyDelay(int delay) {
        this.destroyDelay = delay;
    }

    @Override
    public void setDestroying(boolean destroying) {
        this.isDestroying = destroying;
    }

    @Override
    public void startPredictionI(ClientLevel p_233730_, PredictiveAction p_233731_) {
        this.startPrediction(p_233730_,p_233731_);
    }

    @Override
    public boolean sameDestroyTargetI(BlockPos p_105282_) {
        return this.sameDestroyTarget(p_105282_);
    }

    @Override
    public void ensureHasSentCarriedItemI() {
        this.ensureHasSentCarriedItem();
    }

    @Override
    public InteractionResult performUseItemOnI(LocalPlayer p_233747_, InteractionHand p_233748_, BlockHitResult p_233749_) {
        return this.performUseItemOn(p_233747_, p_233748_, p_233749_);
    }
}
