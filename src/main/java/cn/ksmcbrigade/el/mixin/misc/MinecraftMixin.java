package cn.ksmcbrigade.el.mixin.misc;

import cn.ksmcbrigade.el.events.misc.ApplyModCheckEvent;
import cn.ksmcbrigade.el.events.misc.TimerEvent;
import cn.ksmcbrigade.el.interfaces.MinecraftFieldsX;
import net.minecraft.client.Minecraft;
import net.minecraft.client.User;
import net.minecraft.util.ModCheck;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public class MinecraftMixin implements MinecraftFieldsX {

    @Mutable
    @Shadow @Final private User user;

    @Shadow private int rightClickDelay;

    @Shadow protected int missTime;

    @Inject(method = {"getTickTargetMillis"},at = @At("RETURN"),cancellable = true)
    public void event(float p_308953_, CallbackInfoReturnable<Float> cir){
        TimerEvent event = new TimerEvent(cir.getReturnValue());
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.tickTargetMillis);
    }

    @Inject(method = "checkModStatus",at = @At("RETURN"),cancellable = true)
    private static void brand(CallbackInfoReturnable<ModCheck> cir){
        ApplyModCheckEvent event = new ApplyModCheckEvent(cir.getReturnValue());
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.value);
    }

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public int getRightClickDelay() {
        return this.rightClickDelay;
    }

    @Override
    public int getMissTime() {
        return this.missTime;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void setRightClickDelay(int delay) {
        this.rightClickDelay = delay;
    }

    @Override
    public void setMissTime(int time) {
        this.missTime = time;
    }
}
