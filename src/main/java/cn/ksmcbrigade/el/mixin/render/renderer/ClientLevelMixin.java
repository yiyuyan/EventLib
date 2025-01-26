package cn.ksmcbrigade.el.mixin.render.renderer;

import cn.ksmcbrigade.el.events.render.DayTimeEvent;
import net.minecraft.client.multiplayer.ClientLevel;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientLevel.ClientLevelData.class)
public class ClientLevelMixin {
    @Inject(method = "getDayTime",at = @At("RETURN"),cancellable = true)
    public void dayTime(CallbackInfoReturnable<Long> cir){
        DayTimeEvent event = new DayTimeEvent(cir.getReturnValue());
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.time);
    }
}
