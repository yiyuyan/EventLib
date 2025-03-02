package cn.ksmcbrigade.el.mixin.entity;

import cn.ksmcbrigade.el.events.render.ApplyEyeInFluidEvent;
import cn.ksmcbrigade.el.events.render.ApplyUnderWaterEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = "isUnderWater",at = @At("RETURN"),cancellable = true)
    public void under_water(CallbackInfoReturnable<Boolean> cir){
        ApplyUnderWaterEvent event = new ApplyUnderWaterEvent(cir.getReturnValue());
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.value);
    }

    @Inject(method = "isEyeInFluid",at = @At("RETURN"),cancellable = true)
    public void eyeInFluid(TagKey<Fluid> p_204030_,CallbackInfoReturnable<Boolean> cir){
        ApplyEyeInFluidEvent event = new ApplyEyeInFluidEvent(cir.getReturnValue(),p_204030_);
        NeoForge.EVENT_BUS.post(event);
        cir.setReturnValue(event.value);
    }
}