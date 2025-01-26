package cn.ksmcbrigade.el.mixin.entity;

import cn.ksmcbrigade.el.events.entity.ApplyJumpBoostEffectEvent;
import cn.ksmcbrigade.el.events.entity.CheckHasEffectEvent;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "hasEffect",at = @At("RETURN"), cancellable = true)
    public void has(Holder<MobEffect> p_316430_, CallbackInfoReturnable<Boolean> cir){
        CheckHasEffectEvent event = new CheckHasEffectEvent(p_316430_,cir.getReturnValue());
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.has);
    }

    @Inject(method = "getEffect",at = @At("RETURN"), cancellable = true)
    public void get(Holder<MobEffect> p_316430_, CallbackInfoReturnable<MobEffectInstance> cir){
        CheckHasEffectEvent event = new CheckHasEffectEvent(p_316430_,cir.getReturnValue()!=null);
        NeoForge.EVENT_BUS.post(event);
        if(!event.has){
            cir.setReturnValue(null);
        }
    }

    @Inject(method = "getJumpBoostPower",at = @At("RETURN"),cancellable = true)
    public void jumpBoost(CallbackInfoReturnable<Float> cir){
        ApplyJumpBoostEffectEvent event = new ApplyJumpBoostEffectEvent(cir.getReturnValue());
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.value);
    }
}
